/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deber1p2parte2;

public abstract class Empleado {
    protected int horasTrabajadas;
    protected double sueldoPorHora;

    public Empleado(int horasTrabajadas, double sueldoPorHora) {
        this.horasTrabajadas = horasTrabajadas;
        this.sueldoPorHora = sueldoPorHora;
    }
    
    public abstract double CalcularSalario();
}
