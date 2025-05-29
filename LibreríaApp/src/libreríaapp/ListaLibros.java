/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreríaapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Comparator;

public class ListaLibros {

    private ArrayList<Libro> libros;

    public ListaLibros() {
        this.libros = new ArrayList<>();
    }

    // 1. Agregar un libro
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public ArrayList<Libro> buscarPorAutor(String autor) {
        ArrayList<Libro> librosAutor = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                librosAutor.add(libro);
            }
        }
        return librosAutor;
    }

    public void eliminarAntesDeAño(int añoLimite) {
        Iterator<Libro> iter = libros.iterator();
        while (iter.hasNext()) {
            Libro libro = iter.next();
            if (libro.getAño() < añoLimite) {
                iter.remove();
            }
        }
    }

    public void mostrarLibrosOrdenadosPorAño() {
        Collections.sort(libros, new Comparator<Libro>() {
            @Override
            public int compare(Libro libro1, Libro libro2) {
                return Integer.compare(libro1.getAño(), libro2.getAño());
            }
        });

        System.out.println("--- Libros ordenados por año ---");
        for (Libro libro : libros) {
            libro.mostrarInfo();
        }
    }

    public void mostrarTodosLosLibros() {
        System.out.println("--- Todos los libros ---");
        for (Libro libro : libros) {
            libro.mostrarInfo();
        }
    }
}
