/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deber2app;

/**
 *
 * @author Rafa
 */
public class Frescos extends Producto {

    private String envasado;
    private String paisOrigen;

    public Frescos(String envasado, String paisOrigen, String fCaducidad, int nLote) {
        super(fCaducidad, nLote);
        this.envasado = envasado;
        this.paisOrigen = paisOrigen;
    }

    public String getEnvasado() {
        return envasado;
    }

    public void setEnvasado(String envasado) {
        this.envasado = envasado;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    @Override
    public String toString() {
        return super.toString() + "Frescos{" + "envasado=" + envasado + ", paisOrigen=" + paisOrigen + '}';
    }

}
