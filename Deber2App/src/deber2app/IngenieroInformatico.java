/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deber2app;

/**
 *
 * @author Rafa
 */
public class IngenieroInformatico extends Ingeniero{

    public IngenieroInformatico(String name, String lastName, int age) {
        super(name, lastName, age);
    }
    
    public boolean crearPrograma(int validar){
        if (validar != 1) {
            return false;
        } else {
            return true;
        }
    }
}
