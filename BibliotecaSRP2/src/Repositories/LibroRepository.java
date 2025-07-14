/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LibroRepository {

    private final List<Libro> libros = new ArrayList<>();

    public void guardar(Libro libro) {
        libros.add(libro);
    }

    public Optional<Libro> buscarPorId(String id) {
        return libros.stream()
                .filter(l -> l.getId().equals(id))
                .findFirst();
    }

    public List<Libro> obtenerTodos() {
        return new ArrayList<>(libros);
    }

    public List<Libro> obtenerDisponibles() {
        return libros.stream()
                .filter(Libro::isDisponible)
                .toList();
    }
}
