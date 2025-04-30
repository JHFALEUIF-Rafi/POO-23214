/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bomberoapp;

public class GestorBomberoApp {
    public static void main(String[] args) {
        Bombero objtBombero = new Bombero("Javier", "Serrano Vera", 19);
        System.out.println("Nombre: " + objtBombero.getNombre());
        System.out.println("Apellidos: " + objtBombero.getApellido());
        System.out.println("Edad: "+objtBombero.getEdad());
    }
    
}
