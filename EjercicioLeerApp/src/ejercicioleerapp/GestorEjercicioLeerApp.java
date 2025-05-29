/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioleerapp;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class GestorEjercicioLeerApp {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        int a = 0, e = 0, i = 0, o = 0, u = 0;
        int contarVolcales = 0;

        File archivo = new File("Ejercicio DP47.txt");
        try (Scanner entrada = new Scanner(new FileReader(archivo))) {
            while (entrada.hasNextLine()) {
                String linea = entrada.nextLine().toLowerCase();
                for (char c : linea.toCharArray()) {
                    switch (c) {
                        case 'a':
                            a++;
                            contarVolcales++;
                            break;
                        case 'e':
                            e++;
                            contarVolcales++;
                            break;
                        case 'i':
                            i++;
                            contarVolcales++;
                            break;
                        case 'o':
                            o++;
                            contarVolcales++;
                            break;
                        case 'u':
                            u++;
                            contarVolcales++;
                            break;
                    }
                }
            }
        } catch (IOException ex) {
            System.err.println("Error al leer: " + ex.getMessage());
            return;
        }

        System.out.println("****Resumen Contador    ****");
        System.out.println("Total vocales: " + contarVolcales);
        System.out.println("a: " + a);
        System.out.println("e: " + e);
        System.out.println("i: " + i);
        System.out.println("o: " + o);
        System.out.println("u: " + u);
    }
}
