/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deber2app;

/**
 *
 * @author Rafa
 */
public class Cd extends Publicacion {

    private int tReproduccion;

    public Cd(int tReproduccion, String titulo, double precio) {
        super(titulo, precio);
        this.tReproduccion = tReproduccion;
    }

    public double gettReproduccion() {
        return tReproduccion;
    }

    public void settReproduccion(int tReproduccion) {
        this.tReproduccion = tReproduccion;
    }

    public void datosCd() {
        System.out.println("T.Reproduccion: " + tReproduccion + " min");
    }
}
