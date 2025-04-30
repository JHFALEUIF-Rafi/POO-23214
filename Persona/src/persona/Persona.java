/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona;

public class Persona {

    //Atributos
    private String nombre;
    private int edad;
    private String id;

    //
    public Persona(String n, int a, String c) {
        nombre = n;
        edad = a;
        id = c;
    }

    public Persona() {
        nombre = "";
        edad = 0;
        id = "";
    }

    public Persona(String n, String c) {
        nombre = n;
        edad = 0;
        id = c;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getId() {
        return id;
    }

    public void setNombre(String n) {
        nombre = n;
    }

    public void setEdad(int a) {
        edad = a;
    }

    public void setId(String c) {
        id = c;
    }
    
    public void mostrarPersona(){
        System.out.println("****DATOS****");
        System.out.println("Nombre: "+ nombre);
        System.out.println("Edad: " + edad);
        System.out.println("ID: "+ id);
    }
    
    public boolean esMayorEdad(){
        if(edad > 17){
            System.out.println("Es mayor de edad");
            return true;
        }else{
            System.out.println("Pollito jugador de brawlstars");
            return false;
        }
    }
}
