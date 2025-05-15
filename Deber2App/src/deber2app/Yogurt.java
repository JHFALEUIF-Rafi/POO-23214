    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deber2app;

/**
 *
 * @author Rafa
 */
public class Yogurt {
    private float calorias;

    public Yogurt(float calorias) {
        this.calorias = calorias;
    }

    public float getCalorias() {
        return calorias;
    }
    
    public void mostrarCalorias(){
        System.out.println("Calorias: "+ this.calorias);
    }
}
