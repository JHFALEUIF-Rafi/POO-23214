package modelo;

import java.util.Date;

public class Proveedor {
    private String nombre;
    private String pais;
    private int cedula;
    private Date fechaNacimiento;

    public Proveedor(String nombre, String pais, int cedula, Date fechaNacimiento) {
        this.nombre = nombre;
        this.pais = pais;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento != null ? fechaNacimiento : new Date();
    }

    Proveedor(String nombre, String pais, String cedula, Date fechaNacimiento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    
}