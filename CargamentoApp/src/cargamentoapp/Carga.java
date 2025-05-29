/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cargamentoapp;

public class Carga {
    private String tipo;
    private double peso;

    public Carga(String tipo, double peso) {
        this.tipo = tipo;
        this.peso = peso;
    }

    // Getters
    public String getTipo() {
        return tipo;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return tipo + " (" + peso + " kg)";
    }
}

