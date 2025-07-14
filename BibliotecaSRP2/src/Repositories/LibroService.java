/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import java.util.List;
import java.util.Optional;

public class LibroService {

    private final LibroRepository repository;

    public LibroService(LibroRepository repository) {
        this.repository = repository;
    }

    public void registrarLibro(String id, String titulo, String autor) {
        Libro nuevoLibro = new Libro(id, titulo, autor);
        repository.guardar(nuevoLibro);
    }

    public Optional<Libro> buscarLibro(String id) {
        return repository.buscarPorId(id);
    }

    public List<Libro> listarDisponibles() {
        return repository.obtenerDisponibles();
    }
}
