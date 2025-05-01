/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herenciapersonaapp;

public class Estudiante extends Persona {

    private int codigoEstudiante;
    private float notaFinal;

    public Estudiante(int ce, float nf, String n, String a, int e) {
        super(n, a, e);
        codigoEstudiante = ce;
        notaFinal = nf;
    }

    public void mostrarDatos() {
        super.mostrarPersona();
        System.out.println("Codigo Estudiante: " + codigoEstudiante);
        System.out.println("Nota final: " + notaFinal);
    }
}
