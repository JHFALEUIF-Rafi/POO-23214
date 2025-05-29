/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package libreríaapp;

import java.util.ArrayList;

/**
 *
 * @author Rafa
 */
public class GestorLibreríaApp {

    public static void main(String[] args) {
        ListaLibros gestor = new ListaLibros();

        gestor.agregarLibro(new Libro("Cien años de soledad", "Gabriel García Márquez", 1967));
        gestor.agregarLibro(new Libro("El principito", "Antoine de Saint-Exupéry", 1943));
        gestor.agregarLibro(new Libro("1984", "George Orwell", 1949));
        gestor.agregarLibro(new Libro("La sombra del viento", "Carlos Ruiz Zafón", 2001));

        gestor.mostrarTodosLosLibros();


        System.out.println("\n--- Libros de George Orwell ---");
        ArrayList<Libro> librosOrwell = gestor.buscarPorAutor("George Orwell");
        for (Libro libro : librosOrwell) {
            libro.mostrarInfo();
        }

        gestor.eliminarAntesDeAño(1950);
        System.out.println("\n--- Libros después de eliminar los publicados antes de 1950 ---");
        gestor.mostrarTodosLosLibros();

        gestor.mostrarLibrosOrdenadosPorAño();
    }
}
