/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deber2app;

/**
 *
 * @author Rafa
 */
public class Agua extends Congelado {

    private double salinidad;

    public Agua(double salinidad, String cosa, double temperatura, String envasado, String paisOrigen, String fCaducidad, int nLote) {
        super(cosa, temperatura, envasado, paisOrigen, fCaducidad, nLote);
        this.salinidad = salinidad;
    }

    public double getSalinidad() {
        return salinidad;
    }

    public void setSalinidad(double salinidad) {
        this.salinidad = salinidad;
    }

    @Override
    public String toString() {
        return super.toString() + "Agua{" + "salinidad=" + salinidad + '}';
    }

}
