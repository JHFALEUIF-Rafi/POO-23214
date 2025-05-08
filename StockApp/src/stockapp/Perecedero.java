/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stockapp;

public class Perecedero extends Producto {

    private int diasCalcular;

    public Perecedero(int diasCalcular, String nombre, float precio) {
        super(nombre, precio);
        this.diasCalcular = diasCalcular;
    }

    public int getDiasCalcular() {
        return diasCalcular;
    }

    public void setDiasCalcular(int diasCalcular) {
        this.diasCalcular = diasCalcular;
    }

    public float calcular(int cantidad) {
        float total = super.calcular(cantidad);
        total = (diasCalcular == 1) ? total -= (total / 4)
                : (diasCalcular == 2) ? total -= (total / 3)
                        : (diasCalcular == 3) ? total -= (total / 2) : total;
        return total;
    }

    @Override
    public String toString() {
        return super.toString() + "Perecedero{" + "diasCalcular=" + diasCalcular + '}';
    }

}
