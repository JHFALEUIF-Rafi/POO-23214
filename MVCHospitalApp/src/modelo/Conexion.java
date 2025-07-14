package modelo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class Conexion {

    DB baseDatos;
    DBCollection coleccion;

    public Conexion() {
        MongoClient mongo = new MongoClient("localhost", 27017);
        baseDatos = mongo.getDB("hospital");
        coleccion = baseDatos.getCollection("proveedor");
    }
    
}
