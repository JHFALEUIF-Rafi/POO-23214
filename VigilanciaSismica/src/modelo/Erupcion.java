package modelo;

import java.util.Date;
import java.util.List;

public class Erupcion extends Evento {  // Ahora hereda de Evento
    private double VEI;
    private String descripcion;
    private String nombreVolcan;
    private double volumenTefra;
    private double alturaColumna;
    private String tipoErupcion;  // Ej: "Pliniana", "Estromboliana", etc.

    public Erupcion(String id, Date fecha, List<String> estaciones,
                   String nombreVolcan, double volumenTefra, 
                   double alturaColumna, String descripcion) {
        super(id, fecha, estaciones);
        this.nombreVolcan = nombreVolcan;
        this.volumenTefra = volumenTefra;
        this.alturaColumna = alturaColumna;
        this.descripcion = descripcion;
        this.VEI = calcularVEI();  // Auto-cálculo al crear
    }

    private double calcularVEI() {
        // Fórmula según tu documento (ajusta esto):
        return Math.log10(volumenTefra + 1) * 2.5 + (alturaColumna / 15);
    }
    
    public String getTipo() {
        return "ERUPCION_VOLCANICA";
    }
    
  
    public String getNombreVolcan() {
        return nombreVolcan;
    }
    
    public String getTipoErupcion() {
        return tipoErupcion;
    }

    public double getVEI() {
        return VEI;
    }

    public void setVEI(double VEI) {
        this.VEI = VEI;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getVolumenTefra() {
        return volumenTefra;
    }

    public void setVolumenTefra(double volumenTefra) {
        this.volumenTefra = volumenTefra;
    }

    public double getAlturaColumna() {
        return alturaColumna;
    }

    public void setAlturaColumna(double alturaColumna) {
        this.alturaColumna = alturaColumna;
    }
    
    
}
