/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cargamentoapp;
import java.util.ArrayList;
import java.util.List;

public class Camion {
    private String matricula;
    private double capacidadMaxima; 
    private List<Carga> cargas;

    public Camion(String matricula, double capacidadMaxima) {
        this.matricula = matricula;
        this.capacidadMaxima = capacidadMaxima;
        this.cargas = new ArrayList<>();
    }

    public boolean agregarCarga(Carga carga) {
        if (pesoTotal() + carga.getPeso() <= capacidadMaxima) {
            cargas.add(carga);
            System.out.println("Carga agregada: " + carga);
            return true;
        } else {
            System.out.println("No se puede agregar la carga. Peso excedido.");
            return false;
        }
    }

    public boolean eliminarCarga(int indice) {
        if (indice >= 0 && indice < cargas.size()) {
            Carga eliminada = cargas.remove(indice);
            System.out.println("Carga eliminada: " + eliminada);
            return true;
        }
        System.out.println("Índice de carga no válido.");
        return false;
    }

   
    public double pesoTotal() {
        double total = 0;
        for (Carga carga : cargas) {
            total += carga.getPeso();
        }
        return total;
    }

    public double cargaDisponible() {
        return capacidadMaxima - pesoTotal();
    }

    public boolean puedeAgregar(double peso) {
        return (pesoTotal() + peso) <= capacidadMaxima;
    }

    public void mostrarEstado() {
        System.out.println("Camión: " + matricula);
        System.out.println("Capacidad máxima: " + capacidadMaxima + " kg");
        System.out.println("Peso actual: " + pesoTotal() + " kg");
        System.out.println("Carga disponible: " + cargaDisponible() + " kg");
        System.out.println("Cargas transportadas:");
        
        if (cargas.isEmpty()) {
            System.out.println("  - No hay cargas");
        } else {
            for (int i = 0; i < cargas.size(); i++) {
                System.out.println("  " + (i+1) + ". " + cargas.get(i));
            }
        }
        System.out.println("----------------------");
    }

    public String getMatricula() {
        return matricula;
    }

    public double getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public List<Carga> getCargas() {
        return new ArrayList<>(cargas);
    }
}
