/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bomberoapp;

public class Bombero {
    //Atributos
    private String nombre;
    private String apellido;
    private int edad;
    
    public Bombero(String n, String a, int e){
        nombre = n;
        apellido = a;
        edad = e;
    }
    
    public void imprimir(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellidos: " + apellido);
        System.out.println("Edad: " + edad);
    }
}
