/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo8app;
import java.util.Scanner;

public class GestorEjemplo8App {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        final int cantidadCaracteres = 50;
        char[] caracteres = new char[cantidadCaracteres];
        int contadorA=0;
        
        System.out.println("Ingrese 50 caracteres (uno por cada uno con enter): ");
        
        for (int i=0; i<cantidadCaracteres; i++){
            System.out.print("Caracter " + (i+1) + ": ");
            caracteres[i]=entrada.next().charAt(0);
        }
        
        for(char c : caracteres){
           if(c == 'a'|| c == 'A'){
               contadorA++;
           }
        }
        System.out.println("\nEl caracter 'a' o 'A' aparece "+ contadorA + " veces");
        entrada.close();
    }
    
}
