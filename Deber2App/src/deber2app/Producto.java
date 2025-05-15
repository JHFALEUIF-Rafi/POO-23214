/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deber2app;

/**
 *
 * @author Rafa
 */
public class Producto {
    private String fCaducidad;
    private int nLote;

    public Producto(String fCaducidad, int nLote) {
        this.fCaducidad = fCaducidad;
        this.nLote = nLote;
    }

    public String getfCaducidad() {
        return fCaducidad;
    }

    public void setfCaducidad(String fCaducidad) {
        this.fCaducidad = fCaducidad;
    }

    public int getnLote() {
        return nLote;
    }

    public void setnLote(int nLote) {
        this.nLote = nLote;
    }

    @Override
    public String toString() {
        return "Producto{" + "fCaducidad=" + fCaducidad + ", nLote=" + nLote + '}';
    }
    
}
