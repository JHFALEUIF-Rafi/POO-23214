/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import Repositories.LibroRepository;

/**
 *
 * @author Rafa
 */
public class Main {

    public static void main(String[] args) {
        // Inicialización
        LibroRepository libroRepo = new LibroRepository();
        UsuarioRepository usuarioRepo = new UsuarioRepository();
        PrestamoRepository prestamoRepo = new PrestamoRepository();

        LibroService libroService = new LibroService(libroRepo);
        UsuarioService usuarioService = new UsuarioService(usuarioRepo);
        PrestamoService prestamoService = new PrestamoService(prestamoRepo, libroRepo);

        // Datos de prueba
        libroService.registrarLibro("L-001", "Clean Code", "Robert C. Martin");
        libroService.registrarLibro("L-002", "Design Patterns", "Erich Gamma");
        usuarioService.registrarUsuario("U-001", "María López", "maria@email.com");

        // Operaciones
        Libro libro = libroService.buscarLibro("L-001").orElseThrow();
        Usuario usuario = usuarioService.buscarUsuario("U-001").orElseThrow();

        prestamoService.realizarPrestamo("P-001", libro, usuario);

        // Mostrar resultados
        System.out.println("=== LIBROS DISPONIBLES ===");
        libroService.listarDisponibles().forEach(l
                -> System.out.println(l.getTitulo() + " - " + l.getAutor()));

        System.out.println("\n=== PRÉSTAMOS ACTIVOS ===");
        prestamoService.obtenerPrestamosActivos().forEach(p
                -> System.out.println(p.getUsuario().getNombre() + p.getLibro().getTitulo() + " prestado a "));
    }
}

