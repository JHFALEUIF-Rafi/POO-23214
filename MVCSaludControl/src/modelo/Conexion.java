package modelo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class Conexion {
    private MongoClient mongoClient;
    private MongoDatabase database;
    
    public Conexion() {
        try {
            this.mongoClient = MongoClients.create("mongodb://localhost:27017");
            this.database = mongoClient.getDatabase("FarmaS");
            System.out.println("Conexión exitosa a MongoDB");
        } catch (Exception e) {
            System.err.println("Error de conexión a MongoDB: " + e.getMessage());
        }
    }
    
    public MongoDatabase getDatabase() {
        return this.database;
    }
    
    public void cerrarConexion() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
