/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deber2app;

/**
 *
 * @author Rafa
 */
public class Refrigerado extends Frescos {

    private String cosa;
    private double temperatura;

    public Refrigerado(String cosa, double temperatura, String envasado, String paisOrigen, String fCaducidad, int nLote) {
        super(envasado, paisOrigen, fCaducidad, nLote);
        this.cosa = cosa;
        this.temperatura = temperatura;
    }

    public String getCosa() {
        return cosa;
    }

    public void setCosa(String cosa) {
        this.cosa = cosa;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return super.toString() + "Refrigerado{" + "cosa=" + cosa + ", temperatura=" + temperatura + '}';
    }

}
