package modelo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import java.util.ArrayList;
import java.util.List;

public class SismoDAO {
    private final DBCollection coleccion;

    public SismoDAO() {
        try {
            MongoClient mongo = Conexion.getInstancia();
            DB db = mongo.getDB("sistema_sismico");
            this.coleccion = db.getCollection("sismos");
        } catch (MongoException e) {
            throw new RuntimeException("Error al conectar con MongoDB: " + e.getMessage(), e);
        }
    }

    public void guardarSismo(Sismo sismo) {
        try {
            BasicDBObject doc = sismo.toDBObject();
            coleccion.insert(doc);
        } catch (MongoException e) {
            throw new RuntimeException("Error al guardar el sismo: " + e.getMessage(), e);
        }
    }

    public List<Sismo> listarSismosNoProcesados() {
        List<Sismo> sismos = new ArrayList<>();
        try {
            BasicDBObject query = new BasicDBObject("medido", false);
            DBCursor cursor = coleccion.find(query);

            while (cursor.hasNext()) {
                DBObject doc = cursor.next();
                sismos.add(Sismo.fromDBObject((BasicDBObject) doc));
            }
        } catch (MongoException e) {
            throw new RuntimeException("Error al listar sismos: " + e.getMessage(), e);
        }
        return sismos;
    }

    public void marcarSismoComoMedido(String idSismo) {
        try {
            BasicDBObject query = new BasicDBObject("id", idSismo);
            BasicDBObject update = new BasicDBObject("$set", new BasicDBObject("medido", true));
            coleccion.update(query, update);
        } catch (MongoException e) {
            throw new RuntimeException("Error al actualizar el sismo: " + e.getMessage(), e);
        }
    }

    // Método adicional para buscar por ID (útil para validaciones)
    public Sismo buscarPorId(String idSismo) {
        try {
            BasicDBObject query = new BasicDBObject("id", idSismo);
            DBObject doc = coleccion.findOne(query);
            return (doc != null) ? Sismo.fromDBObject((BasicDBObject) doc) : null;
        } catch (MongoException e) {
            throw new RuntimeException("Error al buscar sismo: " + e.getMessage(), e);
        }
    }
}
