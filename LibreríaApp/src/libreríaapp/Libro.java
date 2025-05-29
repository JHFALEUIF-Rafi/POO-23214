/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreríaapp;

public class Libro {
    private String titulo;
    private String autor;
    private int año;

    public Libro(String titulo, String autor, int año) {
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAño() {
        return año;
    }

    public void mostrarInfo() {
        System.out.println("Título: " + titulo + ", Autor: " + autor + ", Año: " + año);
    }

    public int compareTo(Libro otroLibro) {
        return Integer.compare(this.año, otroLibro.año);
    }
}
