/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rafa
 */
public class Pais {
    private String nombre;
    private int iD;

    public Pais(String nombre, int iD) {
        this.nombre = nombre;
        this.iD = iD;
    }

    public Pais() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    @Override
    public String toString() {
        return "Pais{" + "iD=" + iD + ", nombre=" + nombre + '}';
    }
    
}
