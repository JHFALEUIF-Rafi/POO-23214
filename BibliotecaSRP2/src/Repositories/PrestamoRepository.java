/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import java.util.ArrayList;
import java.util.List;

public class PrestamoRepository {

    private final List<Prestamo> prestamos = new ArrayList<>();

    public void guardar(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    public List<Prestamo> obtenerActivos() {
        return prestamos.stream()
                .filter(p -> p.getFechaDevolucion() == null)
                .toList();
    }
}
