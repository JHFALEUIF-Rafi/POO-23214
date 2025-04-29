/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio9app;
import java.util.Scanner;

public class GestorEjercicio9App {
    public static void main(String[] args) {
             Scanner scanner = new Scanner(System.in);
        final int MAX_ELEMENTOS = 200;
        int[] vectorOriginal = new int[MAX_ELEMENTOS];
        int[] vectorSinDuplicados = new int[MAX_ELEMENTOS];
        int cantidad, nuevaCantidad = 0;

        do {
            System.out.print("Ingrese la cantidad de elementos (maximo 200): ");
            cantidad = scanner.nextInt();
            if (cantidad <= 0 || cantidad > MAX_ELEMENTOS) {
                System.out.println("Cantidad no válida. Intente nuevamente.");
            }
        } while (cantidad <= 0 || cantidad > MAX_ELEMENTOS);

        System.out.println("Ingrese los elementos del vector ORDENADO:");
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            vectorOriginal[i] = scanner.nextInt();
            
            if (i > 0 && vectorOriginal[i] < vectorOriginal[i - 1]) {
                System.out.println("Error: El vector debe estar ordenado.");
                i--;
            }
        }

        if (cantidad > 0) {
            vectorSinDuplicados[0] = vectorOriginal[0];
            nuevaCantidad = 1;
            
            for (int i = 1; i < cantidad; i++) {
                if (vectorOriginal[i] != vectorOriginal[i - 1]) {
                    vectorSinDuplicados[nuevaCantidad] = vectorOriginal[i];
                    nuevaCantidad++;
                }
            }
        }

        System.out.println("\nVector original (" + cantidad + " elementos):");
        mostrarVector(vectorOriginal, cantidad);
        
        System.out.println("\nVector sin duplicados (" + nuevaCantidad + " elementos):");
        mostrarVector(vectorSinDuplicados, nuevaCantidad);
        
        scanner.close();
    }

    public static void mostrarVector(int[] vector, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            System.out.print(vector[i] + " ");
        }
        System.out.println();
    }
    
}
