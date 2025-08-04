package modelo;

import com.mongodb.*;
import org.mindrot.jbcrypt.BCrypt;
import java.util.*;

public class UsuarioDAO {
    private final DBCollection coleccion;

    public UsuarioDAO() {
        this.coleccion = Conexion.getInstancia()
                               .getDB("sistema_sismico")
                               .getCollection("usuarios");
        crearIndiceUnico();
        cargarUsuariosIniciales();
    }

    public void guardarUsuario(Usuario usuario) {
        if (buscarPorUsername(usuario.getUsername()) != null) {
            throw new RuntimeException("Usuario ya existe");
        }
        BasicDBObject doc = new BasicDBObject()
            .append("username", usuario.getUsername())
            .append("passwordHash", BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt()))
            .append("rol", usuario.getRol());
        coleccion.insert(doc);
    }

    public Usuario buscarPorUsername(String username) {
        DBObject doc = coleccion.findOne(new BasicDBObject("username", username));
        return doc != null ? 
            new Usuario(
                doc.get("username").toString(),
                doc.get("passwordHash").toString(),
                doc.get("rol").toString()
            ) : null;
    }

    private void crearIndiceUnico() {
        coleccion.createIndex(new BasicDBObject("username", 1), "unique", true);
    }

    private void cargarUsuariosIniciales() {
        if (coleccion.count() == 0) {
            guardarUsuario(new Usuario("admin", "admin123", "ADMIN"));
            guardarUsuario(new Usuario("operador", "oper123", "OPERADOR"));
        }
    }
}
