/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alumnoapp;

public class Alumno {

    //Atributos
    private String nombre;
    private int edad;

    //METODOS//
    //Constructor 1
    public Alumno(String n, int e) {
        nombre = n;
        edad = e;
    }

    //Constructor 2
    public Alumno(int e, String n) {
        nombre = n;
        edad = e;
    }

    //Constructor 3
    public Alumno() {
        nombre = "";
        edad = 0;
    }

    //Constructor 5
    public Alumno(int e) {
        nombre = "";
        edad = e;
    }

    //Constructor 6
    public Alumno(String n) {
        nombre = n;
        edad = 0;
    }

    //Metodo get
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    //Método set
    public void setNombre(String n) {
        nombre = n;
    }

    public void setEdad(int e) {
        edad = e;
    }

    //Métodos
    public void imprimir() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad + "\n");
    }

    public boolean comprobarEdad() {
        if (edad >= 18) {
            return true;
        } else {
            return false;
        }
    }
}
