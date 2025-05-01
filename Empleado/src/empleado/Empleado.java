/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleado;

public class Empleado {

    private String nombre;
    private String apellido;
    private double salariom;

    public Empleado(String n, String a, double s) {
        nombre = n;
        apellido = a;
        salariom = s;
    }
    
    public void aumentarSalario(){
        salariom +=(0.10*salariom);
    }

    public void mostrarSalario() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Salario: " + salariom);
    }

    //Get
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getSalarioMensual() {
        return salariom;
    }

    //Set
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setSalarioMensual(double salarioMensual) {
        if (salarioMensual > 0) {
            this.salariom = salariom;
        }
    }
}
