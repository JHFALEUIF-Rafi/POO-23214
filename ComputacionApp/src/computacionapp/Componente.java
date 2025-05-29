/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package computacionapp;

public class Componente {

    private String id;
    private String tipo;
    private String modelo;
    private String fabricante;
    private boolean funciona;

    public Componente(String id, String tipo, String modelo, String fabricante) {
        this.id = id;
        this.tipo = tipo;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.funciona = true;
    }

    public void fallar() {
        this.funciona = false;
        System.out.println("¡El componente " + id + " (" + tipo + ") ha fallado!");
    }

    public void reparar() {
        this.funciona = true;
        System.out.println("Componente " + id + " (" + tipo + ") reparado");
    }

    public String getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public boolean isFunciona() {
        return funciona;
    }

    @Override
    public String toString() {
        return tipo + " - " + fabricante + " " + modelo
                + " (ID: " + id + ") - Estado: " + (funciona ? "OK" : "FALLADO");
    }
}
