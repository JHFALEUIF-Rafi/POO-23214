/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio1;
import java.util.Scanner;

public class GestorEjercicio1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Respuestas correctas: ");
        int rc = scanner.nextInt();
        
        System.out.print("Respuestas incorrectas: ");
        int ri = scanner.nextInt();
        
        System.out.print("Respuestas en blanco: ");
        int rb = scanner.nextInt();
        
        int ca = rc * 3;
        int ia = ri * -1;
        int ea = rb * 0;
        
        int pf = ca + ia + ea;
        
        System.out.println("\n****PUNTAJES****");
        System.out.println("Respuestas Correctas: " + ca);
        System.out.println("Respuestas Incorrectas: " + ia);
        System.out.println("Respuestas en Blanco: " + rb);
        System.out.println(" ");
        System.out.println("Puntaje Final: " + pf);
        
        scanner.close();
    }
    
}
