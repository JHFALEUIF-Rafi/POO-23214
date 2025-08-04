package Clases;

import interfaces.ISaldos;

public class Policia extends Persona implements ISaldos {

    private int edad;
    private int rango;
    private double saldo;

    public Policia(int edad, int rango, double saldo, String codigo, String nombres, String apellidos, String DNI) {
        super(codigo, nombres, apellidos, DNI);
        this.edad = edad;
        this.rango = rango;
        this.saldo = saldo;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public void calcularS() {
        saldo = 120 * rango;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return super.toString() + "Policia{" + "edad=" + edad + ", rango=" + rango + ", saldo=" + saldo + '}';
    }

}
