/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asociaciondepartamento;

import java.util.ArrayList;

public class Departamento {

    private ArrayList employees = new ArrayList();
    private String ndp;
    private String direccion;

    public Departamento(String ndp, String direccion) {
        this.ndp = ndp;
        this.direccion = direccion;
    }

    public String getNdp() {
        return ndp;
    }

    public void setNdp(String ndp) {
        this.ndp = ndp;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void AddEmployee(Persona employee) {
        employees.add(employee);
    }

    public void RemoveEmployee(Persona employee) {
        employees.remove(employee);
    }

    public Persona GetEmployee(int index) {
        return (Persona) employees.get(index);
    }

    public int GetEmployeeCount() {
        return employees.size();
    }

    public void imprimirdp() {
        System.out.println("Empleados" + employees);
        System.out.println("Nombre departamento: " + ndp);
        System.out.println("Direccion: " + direccion);
    }
}
