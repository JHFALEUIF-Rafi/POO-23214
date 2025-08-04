package modelo;

import com.mongodb.*;
import java.util.*;
import java.util.stream.Collectors;

public class VolcanDAO {

    private final DBCollection coleccion;

    public VolcanDAO() {
        this.coleccion = Conexion.getInstancia()
                .getDB("sistema_sismico")
                .getCollection("volcanes");
    }

    // Métodos clave para tu ventana de explosividad
    public void guardarVolcan(Volcan volcan) {
        BasicDBObject updateDoc = new BasicDBObject()
                .append("VEI", volcan.getVEI())
                .append("erupciones", convertirErupciones(volcan.getHistorico()));

        coleccion.update(
                new BasicDBObject("nombre", volcan.getNombre()),
                new BasicDBObject("$set", updateDoc), // ← usa $set
                true,
                false
        );
    }

    public Volcan buscarPorNombre(String nombreVolcan) {
        DBObject doc = coleccion.findOne(new BasicDBObject("nombre", nombreVolcan));
        if (doc == null) {
            return null;
        }

        List<Erupcion> erupciones = ((List<DBObject>) doc.get("erupciones")).stream()
                .map(this::convertirAErupcion)
                .collect(Collectors.toList());

        Volcan volcan = new Volcan(nombreVolcan, (double) doc.get("VEI"));
        volcan.setHistorico(erupciones);
        return volcan;
    }

    // Método específico para tu JTable
    public List<Erupcion> obtenerHistorico(String nombreVolcan) {
        DBObject volcanDoc = coleccion.findOne(new BasicDBObject("nombre", nombreVolcan));
        if (volcanDoc == null) {
            return new ArrayList<>();
        }

        List<DBObject> erupcionesDoc = (List<DBObject>) volcanDoc.get("erupciones");
        return erupcionesDoc.stream()
                .map(this::convertirAErupcion)
                .collect(Collectors.toList());
    }

    // Helpers
    private List<BasicDBObject> convertirErupciones(List<Erupcion> erupciones) {
        return erupciones.stream()
                .map(e -> {
                    Erupcion eru = (Erupcion) e;
                    return new BasicDBObject()
                            .append("fecha", eru.getFecha())
                            .append("VEI", eru.getVEI())
                            .append("volumenTefra", eru.getVolumenTefra())
                            .append("alturaColumna", eru.getAlturaColumna())
                            .append("descripcion", eru.getDescripcion())
                            .append("nombreVolcan", eru.getNombreVolcan());  // <- ahora sí compila
                })
                .collect(Collectors.toList());
    }

    private Erupcion convertirAErupcion(DBObject doc) {
        return new Erupcion(
                UUID.randomUUID().toString(), // O usa doc.get("id") si existe
                (Date) doc.get("fecha"),
                new ArrayList<>(), // O doc.get("estaciones") si las tienes
                doc.get("nombreVolcan") != null ? doc.get("nombreVolcan").toString() : "Desconocido",
                (double) doc.get("volumenTefra"),
                (double) doc.get("alturaColumna"),
                doc.get("descripcion").toString()
        );
    }

    public double obtenerVEIMaximoHistorico(String nombreVolcan) {
        DBObject volcanDoc = coleccion.findOne(new BasicDBObject("nombre", nombreVolcan));
        if (volcanDoc == null) {
            return 0.0;
        }

        return ((List<DBObject>) volcanDoc.get("erupciones")).stream()
                .mapToDouble(e -> (double) e.get("VEI"))
                .max()
                .orElse(0.0);
    }

    public List<Volcan> listarTodos() {
        List<Volcan> volcanes = new ArrayList<>();
        DBCursor cursor = coleccion.find();

        while (cursor.hasNext()) {
            DBObject doc = cursor.next();
            Volcan volcan = new Volcan(
                    doc.get("nombre").toString(),
                    (double) doc.get("VEI")
            );
            volcanes.add(volcan);
        }
        return volcanes;
    }
}
