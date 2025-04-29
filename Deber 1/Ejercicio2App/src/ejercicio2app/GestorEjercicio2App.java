/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio2app;
import java.util.Scanner;

public class GestorEjercicio2App {
    public static void main(String[] args) {
        final float litxg = 3.79f;
        final float precioxl = 3.52f;
        
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese cantidad surtida: ");
        float consu = entrada.nextFloat();
        
        if (consu <= 0){
            System.out.println("La cantidad de consumo debe ser mayor a cero");
            return;
        }
        
        float total = consu * litxg * precioxl;
        
        System.out.println("\n*********FACTURACION*********");
        System.out.println("Litro por galon: " + litxg);
        System.out.println("Precio por galon: " + precioxl + " $");
        System.out.println("-----------------------------");
        System.out.printf("Total a pagar: %.2f $\n", total);
        
        entrada.close();           
    }
}
