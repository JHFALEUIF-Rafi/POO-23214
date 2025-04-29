/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio7app;
import java.util.Scanner;

public class GestorEjercicio7App {
    public static void main(String[] args) {
    final int Limite = 100;
    boolean[] esPrimo = new boolean[Limite + 1];
    
        for (int i=0; i<=Limite; i++){
            esPrimo[i]=true;
        }
        
        esPrimo[0]=false;
        esPrimo[1]=false;
        
        for (int p=2; p * p <= Limite; p++){
            if(esPrimo[p]){
                for(int i=p*p; i<=Limite; i+=p){
                    esPrimo[i]=false;
                }
            }
        }
        System.out.println("Numeros primos entre 0 y 100:");
        for (int i=0; i<=Limite; i++){
            if (esPrimo[i]){
                System.out.print(i + " ");
            }
        }
    }    
}
