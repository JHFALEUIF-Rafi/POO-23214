/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deber2app;

/**
 *
 * @author Rafa
 */
public class YogurtDeslactosado extends Yogurt{
    
    public YogurtDeslactosado(float cal) {
        super(cal);
    }
    
    public float calcularCalorias(){
        return super.getCalorias()/2;
    }
    
    public void imprimirCal(){
        System.out.println("Calorias: "+calcularCalorias());
    }
}
