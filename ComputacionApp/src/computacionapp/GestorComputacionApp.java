/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package computacionapp;

import java.util.ArrayList;
import java.util.List;

public class GestorComputacionApp {

    public static void main(String[] args) {
        List<Componente> componentesDisponibles = new ArrayList<>();
        componentesDisponibles.add(new Componente("CPU001", "CPU", "i7-10700K", "Intel"));
        componentesDisponibles.add(new Componente("RAM001", "RAM", "DDR4 16GB", "Corsair"));
        componentesDisponibles.add(new Componente("DISK001", "Disco Duro", "1TB SSD", "Samsung"));
        componentesDisponibles.add(new Componente("GPU001", "Tarjeta Gráfica", "RTX 3080", "NVIDIA"));
        componentesDisponibles.add(new Componente("RAM002", "RAM", "DDR4 8GB", "Kingston"));

        Computadora pcOficina = new Computadora("PC001", "Computadora de Oficina");
        Computadora pcGaming = new Computadora("PC002", "Computadora Gaming");

        pcOficina.agregarComponente(componentesDisponibles.get(0)); // CPU
        pcOficina.agregarComponente(componentesDisponibles.get(1)); // RAM 16GB
        pcOficina.agregarComponente(componentesDisponibles.get(2)); // Disco Duro

        pcGaming.agregarComponente(componentesDisponibles.get(0)); // Mismo CPU (compartido)
        pcGaming.agregarComponente(componentesDisponibles.get(3)); // GPU
        pcGaming.agregarComponente(componentesDisponibles.get(4)); // RAM 8GB

        pcOficina.mostrarComponentes();
        pcGaming.mostrarComponentes();

        pcOficina.verificarEstado();
        pcGaming.verificarEstado();

        System.out.println("\nSimulando fallo en la RAM de la computadora de oficina...");
        pcOficina.simularFalloComponente("RAM001");

        pcOficina.verificarEstado();
        pcGaming.verificarEstado();

        System.out.println("\nTrasladando RAM de oficina a gaming...");
        pcOficina.removerComponente("RAM001");
        pcGaming.agregarComponente(componentesDisponibles.get(1)); // RAM 16GB

        pcOficina.mostrarComponentes();
        pcGaming.mostrarComponentes();
    }
}
