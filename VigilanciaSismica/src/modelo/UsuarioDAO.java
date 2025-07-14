package modelo;

import com.mongodb.*;
import com.mongodb.MongoClient;
import org.mindrot.jbcrypt.BCrypt;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private final DBCollection coleccion;

    public UsuarioDAO() {
        try {
            // 1. Conexión a MongoDB
            MongoClient mongo = new MongoClient("localhost", 27017);
            DB db = mongo.getDB("sistema_sismico");
            this.coleccion = db.getCollection("usuarios");
            
            // 2. Crear índice único para username
            coleccion.createIndex(new BasicDBObject("username", 1), 
                               new BasicDBObject("unique", true));
            
        } catch (Exception e) {
            throw new RuntimeException("Error al conectar con MongoDB: " + e.getMessage());
        }
    }

    // Método mejorado para buscar usuarios
    public Usuario buscarPorUsername(String username) {
        try {
            BasicDBObject query = new BasicDBObject("username", username.toLowerCase());
            DBObject doc = coleccion.findOne(query);
            
            if (doc != null) {
                return new Usuario(
                    doc.get("username").toString(),
                    doc.get("passwordHash").toString(),
                    doc.get("rol").toString()
                );
            }
            return null;
            
        } catch (Exception e) {
            throw new RuntimeException("Error en buscarPorUsername: " + e.getMessage());
        }
    }

    // Método seguro para guardar usuarios
    public void guardarUsuario(Usuario usuario) {
        try {
            // Verificar si el usuario ya existe
            if (buscarPorUsername(usuario.getUsername()) != null) {
                throw new RuntimeException("El usuario ya existe");
            }
            
            // Hashear la contraseña
            String hash = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
            usuario.setPasswordHash(hash);
            
            // Guardar en MongoDB
            BasicDBObject doc = new BasicDBObject()
                .append("username", usuario.getUsername())
                .append("passwordHash", usuario.getPasswordHash())
                .append("rol", usuario.getRol());
                
            coleccion.insert(doc);
            
        } catch (MongoException e) {
            throw new RuntimeException("Error al guardar usuario: " + e.getMessage());
        }
    }

    // Autenticación segura
    public boolean autenticar(String username, String password) {
        try {
            Usuario usuario = buscarPorUsername(username);
            return usuario != null && BCrypt.checkpw(password, usuario.getPasswordHash());
        } catch (Exception e) {
            throw new RuntimeException("Error en autenticar: " + e.getMessage());
        }
    }

    // Listar todos los usuarios (para administración)
    public List<Usuario> listarTodos() {
        List<Usuario> usuarios = new ArrayList<>();
        try (DBCursor cursor = coleccion.find()) {
            while (cursor.hasNext()) {
                DBObject doc = cursor.next();
                usuarios.add(new Usuario(
                    doc.get("username").toString(),
                    doc.get("passwordHash").toString(),
                    doc.get("rol").toString()
                ));
            }
        }
        return usuarios;
    }
}
