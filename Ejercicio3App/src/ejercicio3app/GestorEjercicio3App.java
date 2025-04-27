/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio3app;
import java.util.Scanner;

public class GestorEjercicio3App {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Ingrese dia (1-30): ");
        int dia = entrada.nextInt();
        
        System.out.print("Ingrese mes (1-12): ");
        int mes = entrada.nextInt();
        
        System.out.print("Ingrese anio (A partir del 2000): ");
        int anio = entrada.nextInt();
        
        if(anio < 2000 || mes < 1 || mes > 12 || dia < 1 || dia > 30) {
            System.out.println("Datos fuera de rango. Intente de nuevo");
            entrada.close();
            return;
        }
        
        int diaSiguiente = dia + 1;
        int mesSiguiente = mes;
        int anioSiguiente = anio;
        
        if (diaSiguiente > 30) {
            diaSiguiente = 1;
            mesSiguiente++;
            
            if (mesSiguiente > 12) {
                mesSiguiente = 1;
                anioSiguiente++;
            }
        }
        
        System.out.printf("La fecha es: %02d/%02d/%04d%n",
                diaSiguiente, mesSiguiente, anioSiguiente);
        entrada.close();
    }
    
}
