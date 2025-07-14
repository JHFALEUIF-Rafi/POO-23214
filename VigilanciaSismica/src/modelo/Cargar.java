package modelo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.bson.Document;

public class Cargar {

    DB baseDatos;
    DBCollection coleccion;

    public Cargar() {
        try {
            MongoClient mongo = new MongoClient("localhost", 27017);
            baseDatos = mongo.getDB("sistema_sismico");
            coleccion = baseDatos.getCollection("usuarios");
            System.out.println("Conexión a MongoDB exitosa");
        } catch (Exception e) {
            System.out.println("Error conectando a MongoDB: " + e.getMessage());
        }
    }

    public void cargarUsuariosDesdeTXT() {
        String rutaArchivo = "C:/Users/WINDOWS/OneDrive/Escritorio/PY JAVA/VigilanciaSismica/usuarios.txt"; // Ruta al archivo TXT

        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 2) {
                    String usuario = datos[0].trim();
                    String password = datos[1].trim();

                    BasicDBObject documento = new BasicDBObject();
                    documento.put("usuario", usuario);
                    documento.put("password", password);

                    coleccion.insert(documento);
                    System.out.println("✅ Usuario agregado: " + usuario);
                }
            }

            br.close();
            System.out.println("Todos los usuarios fueron cargados correctamente.");

        } catch (IOException e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Cargar cargar = new Cargar();
        cargar.cargarUsuariosDesdeTXT();
    }
}
