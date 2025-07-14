package modelo;

import org.bson.Document;
import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.*;
import java.util.ArrayList;

public class EmpleadoDAO {

    private MongoCollection<Document> coleccion;

    public EmpleadoDAO() {
        Conexion conexion = new Conexion();
        this.coleccion = conexion.getDatabase().getCollection("empleados");
    }

    public boolean insertarEmpleado(Empleado e) {
        try {
            Document doc = new Document()
                    .append("nombre", e.getNombre())
                    .append("provincia", e.getProvincia())
                    .append("peso", e.getPeso())
                    .append("estatura", e.getEstatura())
                    .append("edad", e.getEdad());

            coleccion.insertOne(doc);
            System.out.println("Empleado insertado: " + e.getNombre()); // Debug
            return true;
        } catch (Exception ex) {
            System.err.println("Error al insertar empleado: " + ex.getMessage());
            return false;
        }
    }

    public ArrayList<Empleado> obtenerEmpleados() {
        ArrayList<Empleado> lista = new ArrayList<>();
        try {
            for (Document doc : coleccion.find()) {
                Empleado emp = new Empleado(
                        doc.getString("nombre"),
                        doc.getString("provincia"),
                        doc.getDouble("peso"),
                        doc.getDouble("estatura"),
                        doc.getInteger("edad")
                );
                lista.add(emp);
            }
            System.out.println("Empleados obtenidos: " + lista.size()); // Debug
        } catch (Exception e) {
            System.err.println("Error al obtener empleados: " + e.getMessage());
        }
        return lista;
    }

    // En EmpleadoDAO.java
    public void verificarConexion() {
        try {
            long count = coleccion.countDocuments();
            System.out.println("Conexión verificada. Documentos en colección: " + count);
        } catch (Exception e) {
            System.err.println("Error al verificar conexión: " + e.getMessage());
        }
    }

    public void limpiarColeccion() {
        try {
            coleccion.deleteMany(new Document());
            System.out.println("Colección limpiada exitosamente");
        } catch (Exception e) {
            System.err.println("Error al limpiar colección: " + e.getMessage());
        }
    }
}
