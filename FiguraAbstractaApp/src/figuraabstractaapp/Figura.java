/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figuraabstractaapp;

public abstract class Figura {
    protected double lado;

    public Figura(double lado) {
        this.lado = lado;
    }
    
    public abstract double calcularArea();
    
}