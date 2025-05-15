/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package realarchivoapp;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class GestorRealArchivoApp {

    /*public static void main(String[] args) {
        File archivo;
        FileWriter escribir;
        PrintWriter linea;

        archivo = new File("Escritura.txt");
        int x = 10;
        double y = 1004.5;
        String s = "Es una prueba miso";

        try {
            escribir = new FileWriter(archivo, true);
            linea = new PrintWriter(escribir);
            linea.println("Entero: " + x + " ||| " + "Real: " + y);
            linea.println("String: " + s);
            linea.close();
            escribir.close();
        } catch (IOException ex) {

        }
    }*/
    public static void main(String[] args) {
        String palabra = "";
        double d;
        File archivo = new File("Escritura.txt");

        try {
            FileReader f = new FileReader(archivo);
            Scanner entrada = new Scanner(f);
            entrada.useLocale(Locale.ENGLISH);
            while (entrada.hasNext()) {
                palabra = entrada.next();
                System.out.println("Palabra: " + palabra);
                while (entrada.hasNextDouble()) {
                    d = entrada.nextDouble();
                    System.out.println("Double: " + d);
                }
            }
        } catch (IOException ex) {

        }
    }

}
