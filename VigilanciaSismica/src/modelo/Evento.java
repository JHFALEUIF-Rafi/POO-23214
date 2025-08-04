package modelo;

import java.util.Date;
import java.util.List;

public abstract class Evento {
    private String id;
    private Date fecha;
    private List<String> estaciones;
    
    public Evento(String id, Date fecha, List<String> estaciones) {
        this.id = id;
        this.fecha = fecha;
        this.estaciones = estaciones;
    }
    
    // Getters
    public String getId() { return id; }
    public Date getFecha() { return fecha; }
    public List<String> getEstaciones() { return estaciones; }
}