/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresa;

import java.util.ArrayList;

public class ListaEmpleados {

    private ArrayList<Empleado> empleados;

    public ListaEmpleados() {
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public double promedioSalarioPorDepartamento(String departamento) {
        double sumaSalarios = 0;
        int contador = 0;

        for (Empleado emp : empleados) {
            if (emp.getDepartamento().equalsIgnoreCase(departamento)) {
                sumaSalarios += emp.getSalario();
                contador++;
            }
        }

        return (contador == 0) ? 0 : sumaSalarios / contador;
    }

    public ArrayList<Empleado> empleadosSalarioMayorAlPromedio() {
        ArrayList<Empleado> empleadosFiltrados = new ArrayList<>();
        double promedioGeneral = calcularPromedioGeneral();

        for (Empleado emp : empleados) {
            if (emp.getSalario() > promedioGeneral) {
                empleadosFiltrados.add(emp);
            }
        }

        return empleadosFiltrados;
    }

    private double calcularPromedioGeneral() {
        double suma = 0;
        for (Empleado emp : empleados) {
            suma += emp.getSalario();
        }
        return (empleados.isEmpty()) ? 0 : suma / empleados.size();
    }

    public void generarReportePorDepartamento() {
        ArrayList<String> departamentosUnicos = obtenerDepartamentosUnicos();

        for (String depto : departamentosUnicos) {
            System.out.println("\n--- Departamento: " + depto + " ---");
            for (Empleado emp : empleados) {
                if (emp.getDepartamento().equalsIgnoreCase(depto)) {
                    emp.mostrarInfo();
                }
            }
        }
    }

    private ArrayList<String> obtenerDepartamentosUnicos() {
        ArrayList<String> departamentos = new ArrayList<>();
        for (Empleado emp : empleados) {
            String depto = emp.getDepartamento();
            if (!departamentos.contains(depto)) {
                departamentos.add(depto);
            }
        }
        return departamentos;
    }

    public void mostrarTodosLosEmpleados() {
        System.out.println("--- Todos los empleados ---");
        for (Empleado emp : empleados) {
            emp.mostrarInfo();
        }
    }
}

