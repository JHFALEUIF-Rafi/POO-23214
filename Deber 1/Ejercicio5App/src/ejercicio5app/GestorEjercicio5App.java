/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio5app;
import java.util.Scanner;

public class GestorEjercicio5App {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Ingrese numeros a evaluar: ");
        int cantidadNumeros = entrada.nextInt();
        
        if(cantidadNumeros < 0){
            System.out.println("Los numeros deben ser positivos. Intente de nuevo");
            return; 
        }
        
        int contarCeros = 0;
        System.out.println("Ingrese los " + cantidadNumeros + " numeros: ");
        
        for (int i=0; i<cantidadNumeros; i++){
            int numero = entrada.nextInt();
            if (numero == 0){
                contarCeros++;
            }
        }
        System.out.println("Hay "+ contarCeros + "ceros en el numero ingresado");
        entrada.close();
    }
}
