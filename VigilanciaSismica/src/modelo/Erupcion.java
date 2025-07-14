package modelo;

import java.util.Date;

public class Erupcion {

    private Date fecha;
    private double VEI;
    private String descripcion;

    public Erupcion(Date fecha, double VEI, String descripcion) {
        this.fecha = fecha;
        this.VEI = VEI;
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
    
}
