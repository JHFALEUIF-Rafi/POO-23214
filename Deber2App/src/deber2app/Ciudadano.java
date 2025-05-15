/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deber2app;

/**
 *
 * @author Rafa
 */
public class Ciudadano extends Humano {

    private int identificacion;

    public Ciudadano(int identificacion, String nombre, String apellido) {
        super(nombre, apellido);
        this.identificacion = identificacion;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public void imprimirId() {
        System.out.println("ID: " + this.identificacion);
    }

}
