/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package figuraabstractaapp;

public class Rectangulo extends Figura{
      private double base;

    public Rectangulo(double base, double lado) {
        super(lado);
        this.base = base;
    }

    public double getBase() {
        return base;
    }
    
    @Override
    public double calcularArea() {
        return base*lado;
    }      
}
