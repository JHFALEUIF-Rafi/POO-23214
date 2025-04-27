/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package primerprogramaapp;
import java.util.Scanner;
/**
 *
 * @author Rafa
 */
public class GestorPrimerProgramaApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //System.out.println("K lo q world");
        
        Scanner sc = new Scanner (System.in);
        /*System.out.println("Ingrese nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Hola "+ nombre);*/
        
        System.out.println("Ingrese numero 1: ");
        int num1 = sc.nextInt();        
        System.out.println("Ingrese numero 2: ");
        int num2 = sc.nextInt();
        int suma=num1+num2;
        System.out.println("La suma de " + num1 + " y " + num2 + " es:  " + suma);
    }
}
