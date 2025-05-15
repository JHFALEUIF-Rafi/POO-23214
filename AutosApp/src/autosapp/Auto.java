/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autosapp;

public class Auto implements Comparable <Auto>{

    private String modelo;
    private int km;

    public Auto(String modelo, int km) {
        this.modelo = modelo;
        this.km = km;
    }

    public Auto() {
        this.modelo="";
        this.km=0;
    }
    

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    @Override
    public String toString() {
        return "Auto{" + "modelo=" + modelo + ", km=" + km + '}';
    }

    @Override
    public int compareTo(Auto o) {
        return this.modelo.compareTo(o.getModelo());
    }

}
