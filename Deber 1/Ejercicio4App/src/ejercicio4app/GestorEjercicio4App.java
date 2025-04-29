/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio4app;
import java.util.Scanner;

public class GestorEjercicio4App {
    public static void main(String[] args) {
      Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese numero positivo entero: ");
        int numero = entrada.nextInt();
        
        if(numero < 0 ){
            System.out.println("El numero debe ser positivo");
            return;
        }
        
        int numeroInvertido = 0;
        int numeroOriginal = numero;
        
        while(numero > 0){
            int digito = numero % 10;
            numeroInvertido = numeroInvertido * 10 + digito;
            numero = numero / 10;
        }
        System.out.println("Numero original: " + numeroOriginal);
        System.out.println("Numero invertido: " + numeroInvertido);
        entrada.close();
    }
    
}
