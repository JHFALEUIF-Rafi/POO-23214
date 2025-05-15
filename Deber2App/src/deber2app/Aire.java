/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deber2app;

/**
 *
 * @author Rafa
 */
public class Aire extends Congelado {

    private double dioxCar;
    private double oxigeno;
    private double vaporAg;

    public Aire(double dioxCar, double oxigeno, double vaporAg, String cosa, double temperatura, String envasado, String paisOrigen, String fCaducidad, int nLote) {
        super(cosa, temperatura, envasado, paisOrigen, fCaducidad, nLote);
        this.dioxCar = dioxCar;
        this.oxigeno = oxigeno;
        this.vaporAg = vaporAg;
    }

    public double getDioxCar() {
        return dioxCar;
    }

    public void setDioxCar(double dioxCar) {
        this.dioxCar = dioxCar;
    }

    public double getOxigeno() {
        return oxigeno;
    }

    public void setOxigeno(double oxigeno) {
        this.oxigeno = oxigeno;
    }

    public double getVaporAg() {
        return vaporAg;
    }

    public void setVaporAg(double vaporAg) {
        this.vaporAg = vaporAg;
    }

    @Override
    public String toString() {
        return super.toString() + "Aire{" + "dioxCar=" + dioxCar + ", oxigeno=" + oxigeno + ", vaporAg=" + vaporAg + '}';
    }
}
