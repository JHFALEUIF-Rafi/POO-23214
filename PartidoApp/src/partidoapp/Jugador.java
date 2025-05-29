/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package partidoapp;


public class Jugador {
    private String nombre;
    private int numero;
    private String posicion;
    private Equipo equipo; 

    public Jugador(String nombre, int numero, String posicion) {
        this.nombre = nombre;
        this.numero = numero;
        this.posicion = posicion;
        this.equipo = null; 
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }

    public String getPosicion() {
        return posicion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    protected void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return nombre + " (#" + numero + ") - " + posicion;
    }
}
