package modelo;

import com.mongodb.*;
import java.util.*;

public class SismoDAO {

    private final DBCollection coleccion;

    public SismoDAO() {
        this.coleccion = Conexion.getInstancia()
                .getDB("sistema_sismico")
                .getCollection("sismos");
    }

    public void guardarSismo(Sismo sismo) {
        BasicDBObject doc = new BasicDBObject()
                .append("id", sismo.getId())
                .append("magnitud", sismo.getMagnitud())
                .append("epicentro", new BasicDBObject()
                        .append("latitud", sismo.getEpicentro().getLatitud())
                        .append("longitud", sismo.getEpicentro().getLongitud()))
                .append("fecha", sismo.getFecha())
                .append("estaciones", sismo.getEstaciones())
                .append("medido", false); // Por defecto no medido

        coleccion.insert(doc);
    }

    public void marcarSismoComoMedido(String idSismo) {
        BasicDBObject query = new BasicDBObject("id", idSismo);
        BasicDBObject update = new BasicDBObject("$set",
                new BasicDBObject("medido", true));

        coleccion.update(query, update);
    }

    public List<Sismo> listarSismosNoProcesados() {
        List<Sismo> sismos = new ArrayList<>();
        DBCursor cursor = coleccion.find(new BasicDBObject("medido", false));

        while (cursor.hasNext()) {
            DBObject doc = cursor.next();
            sismos.add(new Sismo(
                    doc.get("id").toString(),
                    (double) doc.get("magnitud"),
                    new Coordenada(
                            ((BasicDBObject) doc.get("epicentro")).getDouble("latitud"),
                            ((BasicDBObject) doc.get("epicentro")).getDouble("longitud")
                    ),
                    (Date) doc.get("fecha"),
                    (List<String>) doc.get("estaciones")
            ));
        }
        return sismos;
    }

    public void marcarComoMedido(String idSismo) {
        try {
            DBObject query = new BasicDBObject("id", idSismo);
            DBObject update = new BasicDBObject("$set", new BasicDBObject("medido", true));

            coleccion.update(query, update, false, false); // Aquí 'coleccion' debe estar bien definido en tu clase

        } catch (MongoException e) {
            throw new RuntimeException("Error al marcar el sismo como medido: " + e.getMessage());
        }
    }

    public void marcarSismoComoCritico(String idSismo) {
        DBObject query = new BasicDBObject("id", idSismo);
        DBObject update = new BasicDBObject("$set", new BasicDBObject("critico", true));
        coleccion.update(query, update, false, false);
    }

    public Sismo buscarPorId(String id) {
        try {
            DBObject query = new BasicDBObject("id", id);
            DBObject doc = coleccion.findOne(query);

            if (doc == null) {
                return null;
            }

            return new Sismo(
                    doc.get("id").toString(),
                    (double) doc.get("magnitud"),
                    new Coordenada(
                            ((BasicDBObject) doc.get("epicentro")).getDouble("latitud"),
                            ((BasicDBObject) doc.get("epicentro")).getDouble("longitud")
                    ),
                    (Date) doc.get("fecha"),
                    (List<String>) doc.get("estaciones")
            );
        } catch (MongoException e) {
            System.err.println("Error en buscarPorId: " + e.getMessage());
            return null;
        }
    }

    public void marcarComoReportado(String idSismo) {
        try {
            DBObject query = new BasicDBObject("id", idSismo);
            DBObject update = new BasicDBObject("$set",
                    new BasicDBObject("reportado", true) // Nuevo campo
            );
            coleccion.update(query, update, false, false);
        } catch (MongoException e) {
            System.err.println("Error en marcarComoReportado: " + e.getMessage());
        }
    }
    
    
}
