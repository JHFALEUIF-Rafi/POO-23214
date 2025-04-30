/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bicicletaapp;

public class Bicicleta {

    private int velocidadActual;
    private int platoActual;
    private int piñonActual;

    public Bicicleta(int va, int pa, int pña) {
        velocidadActual = va;
        platoActual = pa;
        piñonActual = pña;
    }

    public void acelerar() {
        velocidadActual *= 2;        
    }

    public void frenar(){
        velocidadActual /= 2;
    }

    public int cambiarPlato(int plato) {
        platoActual = plato;
    }

    public int cambiarPiñon(int piñon) {
        piñonActual = piñon;
    }
    
    public void imprimir(){
       // Guardar velocidad original
        int velocidadOriginal = velocidadActual;
        
        System.out.println("Estado actual:");
        System.out.println("  Velocidad normal: " + velocidadActual);
        
        // Calcular y mostrar velocidad acelerada
        acelerar();
        System.out.println("  Velocidad acelerada: " + velocidadActual);
        velocidadActual = velocidadOriginal; // Restaurar valor original
        
        // Calcular y mostrar velocidad frenada
        frenar();
        System.out.println("  Velocidad frenada: " + velocidadActual);
        velocidadActual = velocidadOriginal; // Restaurar valor original
        
        System.out.println("  Plato actual: " + platoActual);
        System.out.println("  Piñón actual: " + piñonActual); 
    }
}
