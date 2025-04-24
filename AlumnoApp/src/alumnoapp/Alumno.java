/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alumnoapp;

public class Alumno {
    //Atributos
    private String nombre;
    private int edad;
    
    //METODOS
    
    //METODO CONSTRUCTOR
    public Alumno(String n, int e){
    nombre=n;
    edad=e;
    } 
    public void imprimirNombre(){
        System.out.println("Nombre: "+ nombre);
    }
    public boolean comprobarEdad(){
        if(edad>=17)
            return true;
        else
            return false;
    }
}
