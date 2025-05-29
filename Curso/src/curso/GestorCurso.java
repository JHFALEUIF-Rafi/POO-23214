/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package curso;

import java.io.PrintWriter;

public class GestorCurso {

    public static void main(String[] args) {
      ArchivoNotas archivoNotas = new ArchivoNotas();
        
        String datosPrueba = "Juan Pérez,8.5,7.0,9.2\n" +
                            "María Gómez,6.0,7.5,8.0\n" +
                            "Carlos Ruiz,9.0,9.5,9.8\n" +
                            "Ana Torres,5.0,6.0,7.0";
        
        try (PrintWriter writer = new PrintWriter("estudiantes.txt")) {
            writer.print(datosPrueba);
        } catch (java.io.IOException e) {
            System.err.println("Error creando archivo de prueba: " + e.getMessage());
            return;
        }
        

        archivoNotas.leerArchivo("estudiantes.txt");
        System.out.println("Promedio general: " + archivoNotas.getPromedioGeneral());
        archivoNotas.guardarEstudiantesDestacados("destacados.txt");
        
        System.out.println("¡Prueba completada! Revisa el archivo destacados.txt");
    }
}

