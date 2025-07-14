
package modelo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ProveedorDAO {

    public void insertarProveedor(Proveedor p) {
        try {
            BasicDBObject documento = new BasicDBObject();
            documento.put("nombre", p.getNombre());
            documento.put("pais", p.getPais());
            documento.put("cedula", p.getCedula());

            // Garantizar que siempre haya una fecha
            documento.put("fechaNacimiento",
                    p.getFechaNacimiento() != null
                    ? p.getFechaNacimiento()
                    : new Date()
            );

            new Conexion().coleccion.insert(documento);
        } catch (Exception e) {
        }
    }

    public ArrayList<Proveedor> obtenerProveedores() {
        ArrayList<Proveedor> listaProv = new ArrayList<>();
        Conexion objCon = new Conexion();

        DBCursor cursor = objCon.coleccion.find();
        while (cursor.hasNext()) {
            BasicDBObject doc = (BasicDBObject) cursor.next();

            String nombre = doc.getString("nombre");
            String pais = doc.getString("pais");
            int cedula = doc.containsField("cedula") ? doc.getInt("cedula") : 0;
            Date fechaNacimiento = doc.containsField("fechaNacimiento") ? doc.getDate("fechaNacimiento") : null;

            Proveedor aux = new Proveedor(nombre, pais, cedula, fechaNacimiento);
            listaProv.add(aux);
        }
        return listaProv;
    }

    public void eliminarProveedor(Proveedor p) {
        Conexion objtConexion = new Conexion();
        BasicDBObject documento = new BasicDBObject();
        documento.put("cedula", p.getCedula());
        objtConexion.coleccion.remove(documento);
    }

    public void modificarProveedor(Proveedor viejo, Proveedor nuevo) {
        try {
            BasicDBObject query = new BasicDBObject()
                .append("nombre", viejo.getNombre())
                .append("pais", viejo.getPais())
                .append("cedula", viejo.getCedula());

            BasicDBObject update = new BasicDBObject("$set", 
                new BasicDBObject()
                    .append("nombre", nuevo.getNombre())
                    .append("pais", nuevo.getPais())
                    .append("cedula", nuevo.getCedula())
                    .append("fechaNacimiento", 
                        nuevo.getFechaNacimiento() != null ? 
                        nuevo.getFechaNacimiento() : 
                        new Date())
            );

            new Conexion().coleccion.update(query, update);
        } catch (Exception e) {
        }
    }

    public void insertarProveedores(ArrayList<Proveedor> proveedores) {
        Conexion objtConexion = new Conexion();
        List<BasicDBObject> documentos = new ArrayList<>();

        for (Proveedor p : proveedores) {
            BasicDBObject documento = new BasicDBObject();
            documento.put("nombre", p.getNombre());
            documento.put("pais", p.getPais());
            documento.put("cedula", p.getCedula());
            documento.put("fechaNacimiento", p.getFechaNacimiento());
            documentos.add(documento);
        }
        objtConexion.coleccion.insert(documentos);
    }

    public boolean existeCedula(int cedula) {
        Conexion objtConexion = new Conexion();
        BasicDBObject query = new BasicDBObject();
        query.put("cedula", cedula);
        return objtConexion.coleccion.findOne(query) != null;
    }
}
