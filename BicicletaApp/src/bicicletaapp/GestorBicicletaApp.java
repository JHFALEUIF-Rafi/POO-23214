/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bicicletaapp;

public class GestorBicicletaApp {

    
    public static void main(String[] args) {
        Bicicleta objtMiBicicleta = new Bicicleta(14, 3, 2);
        System.out.println("Mi Bicicleta:");
        objtMiBicicleta.imprimir();
        
        Bicicleta objtTuBicicleta = new Bicicleta(10, 2, 5);
        System.out.println("\nTu Bicicleta:");
        objtTuBicicleta.imprimir();
    }
    
}
