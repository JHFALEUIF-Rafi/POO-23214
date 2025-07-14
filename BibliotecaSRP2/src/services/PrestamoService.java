/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.util.List;

public class PrestamoService {

    private final PrestamoRepository prestamoRepo;
    private final LibroRepository libroRepo;

    public PrestamoService(PrestamoRepository prestamoRepo, LibroRepository libroRepo) {
        this.prestamoRepo = prestamoRepo;
        this.libroRepo = libroRepo;
    }

    public void realizarPrestamo(String idPrestamo, Libro libro, Usuario usuario) {
        if (!libro.isDisponible()) {
            throw new IllegalStateException("El libro no está disponible");
        }

        libro.setDisponible(false);
        Prestamo nuevoPrestamo = new Prestamo(idPrestamo, libro, usuario);
        prestamoRepo.guardar(nuevoPrestamo);
    }

    public List<Prestamo> obtenerPrestamosActivos() {
        return prestamoRepo.obtenerActivos();
    }
}
