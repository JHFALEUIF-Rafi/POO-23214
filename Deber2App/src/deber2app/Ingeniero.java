/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deber2app;

/**
 *
 * @author Rafa
 */
public class Ingeniero extends Persona{

    public Ingeniero(String name, String lastName, int age) {
        super(name, lastName, age);
    }
        
    public boolean razonar(int validar){
        if (validar != 1) {
            return false;
        } else {
            return true;
        }
    }
    
    public boolean trabajarEnGrupo(int validar){
        if (validar != 1) {
            return false;
        } else {
            return true;
        }
    }
}
