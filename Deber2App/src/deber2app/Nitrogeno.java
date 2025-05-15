/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deber2app;

/**
 *
 * @author Rafa
 */
public class Nitrogeno extends Congelado {

    private String metodo;
    private int tempExpo;

    public Nitrogeno(String metodo, int tempExpo, String cosa, double temperatura, String envasado, String paisOrigen, String fCaducidad, int nLote) {
        super(cosa, temperatura, envasado, paisOrigen, fCaducidad, nLote);
        this.metodo = metodo;
        this.tempExpo = tempExpo;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public int getTempExpo() {
        return tempExpo;
    }

    public void setTempExpo(int tempExpo) {
        this.tempExpo = tempExpo;
    }

    @Override
    public String toString() {
        return super.toString() + "Nitrogeno{" + "metodo=" + metodo + ", tempExpo=" + tempExpo + '}';
    }
}
