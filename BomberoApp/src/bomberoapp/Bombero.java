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

    public Bombero(String n, String a, int e) {
        nombre = n;
        apellido = a;
        edad = e;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String n) {
        nombre = n;
    }

    public void setApellido(String a) {
        apellido = a;
    }

    public void setEdad(int e) {
        edad = e;
    }
}
