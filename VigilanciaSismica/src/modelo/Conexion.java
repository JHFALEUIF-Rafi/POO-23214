package modelo;

import com.mongodb.MongoClient;

public class Conexion {
    private static MongoClient mongo;
    
    public static MongoClient getInstancia() {
        if (mongo == null) {
            mongo = new MongoClient("localhost", 27017);
        }
        return mongo;
    }
}
