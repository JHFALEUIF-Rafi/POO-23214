/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deber2app;

/**
 *
 * @author Rafa
 */
public class Libro extends Publicacion {

    private int nPaginas;

    public Libro(int nPaginas, String titulo, double precio) {
        super(titulo, precio);
        this.nPaginas = nPaginas;
    }

    public int getnPaginas() {
        return nPaginas;
    }

    public void setnPaginas(int nPaginas) {
        this.nPaginas = nPaginas;
    }

    public void datosLibro() {
        System.out.println("nPaginas: " + nPaginas);
    }
}
