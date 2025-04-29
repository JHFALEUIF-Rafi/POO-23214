/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio10app;
import java.util.Scanner;

public class GestorEjercicio10App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese los caracteres (sin espacios entre ellos): ");
        String entrada = scanner.nextLine();
        
        char[] caracteres = entrada.toCharArray();
        int n = caracteres.length;
        
        System.out.println("\nVector original:");
        System.out.println(entrada);
        
        // Invertir el vector
        for (int i = 0; i < n / 2; i++) {
            char temp = caracteres[i];
            caracteres[i] = caracteres[n - 1 - i];
            caracteres[n - 1 - i] = temp;
        }
        
        System.out.println("\nVector invertido:");
        System.out.println(new String(caracteres));
        
        scanner.close();
    }
}
