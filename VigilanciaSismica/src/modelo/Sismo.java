package modelo;

import com.mongodb.BasicDBObject;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Sismo {

    private String id;
    private double magnitud;
    private Coordenada epicentro;
    private Date fecha;
    private List<String> estaciones;  // Lista de estaciones que detectaron el sismo
    private boolean medido;           // Para el flujo del PDF (página 6: "Evento marcado como medido")

    // Constructor
    public Sismo(String id, double magnitud, Coordenada epicentro, Date fecha, List<String> estaciones) {
        this.id = id;
        this.magnitud = magnitud;
        this.epicentro = epicentro;
        this.fecha = fecha;
        this.estaciones = new ArrayList<>(estaciones);  // Evita aliasing
        this.medido = false;  // Por defecto, no procesado
    }

    // Getters y Setters (necesarios para MongoDB y la lógica de negocio)
    public String getId() {
        return id;
    }

    public double getMagnitud() {
        return magnitud;
    }

    public void setMagnitud(double magnitud) {
        this.magnitud = magnitud;
    }

    public Coordenada getEpicentro() {
        return epicentro;
    }

    public void setEpicentro(Coordenada epicentro) {
        this.epicentro = epicentro;
    }

    public Date getFecha() {
        return fecha;
    }

    public List<String> getEstaciones() {
        return new ArrayList<>(estaciones);  // Devuelve una copia para encapsulamiento
    }

    public boolean isMedido() {
        return medido;
    }

    public void marcarComoMedido() {
        this.medido = true;
    }

    public BasicDBObject toDBObject() {
        BasicDBObject doc = new BasicDBObject();
        doc.put("id", this.id);
        doc.put("magnitud", this.magnitud);
        doc.put("epicentro", new BasicDBObject() 
                .append("latitud", this.epicentro.getLatitud())
                .append("longitud", this.epicentro.getLongitud())
        );
        doc.put("fecha", this.fecha);
        doc.put("estaciones", this.estaciones);
        doc.put("medido", this.medido);
        return doc;
    }

    public static Sismo fromDBObject(BasicDBObject doc) {
        BasicDBObject epicentroDoc = (BasicDBObject) doc.get("epicentro");
        Coordenada epicentro = new Coordenada(
                epicentroDoc.getDouble("latitud"),
                epicentroDoc.getDouble("longitud")
        );

        return new Sismo(
                doc.getString("id"),
                doc.getDouble("magnitud"),
                epicentro, // ¡No olvidar el epicentro!
                doc.getDate("fecha"),
                (List<String>) doc.get("estaciones")
        );
    }
}
