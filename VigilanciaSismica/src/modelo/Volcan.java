package modelo;

import java.util.List;
import java.util.ArrayList;

public class Volcan {

    private String nombre;
    private double VEI;
    private List<Erupcion> historico;

    public Volcan(String nombre, double VEI) {
        this.nombre = nombre;
        this.VEI = VEI;
        this.historico = new ArrayList<>();
    }

    public void agregarErupcion(Erupcion erupcion) {
        this.historico.add(erupcion);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getVEI() {
        return VEI;
    }

    public void setVEI(double VEI) {
        if (VEI < 0 || VEI > 8) {
            throw new IllegalArgumentException("VEI debe estar entre 0 y 8");
        }
        this.VEI = VEI;
    }

    public List<Erupcion> getHistorico() {
        return new ArrayList<>(historico);
    }

    public void setHistorico(List<Erupcion> historico) {
        this.historico = new ArrayList<>(historico);
    }
    
}
