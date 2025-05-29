/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package curso;

public class Estudiante {
    private String nombre;
    private double[] calificaciones;
    private double promedio;

    public Estudiante(String nombre, double[] calificaciones) {
        this.nombre = nombre;
        this.calificaciones = calificaciones;
        this.promedio = calcularPromedio();
    }

    private double calcularPromedio() {
        if (calificaciones == null || calificaciones.length == 0) {
            return 0.0;
        }
        
        double suma = 0.0;
        for (double calificacion : calificaciones) {
            suma += calificacion;
        }
        return suma / calificaciones.length;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPromedio() {
        return promedio;
    }

    public double[] getCalificaciones() {
        return calificaciones;
    }

    public boolean tienePromedioMayorA(double valor) {
        return promedio > valor;
    }
}
