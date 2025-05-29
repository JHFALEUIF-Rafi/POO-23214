/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package empresa;

import java.util.ArrayList;

public class GestorEmpresa {

    public static void main(String[] args) {
        ListaEmpleados gestor = new ListaEmpleados();

        gestor.agregarEmpleado(new Empleado("Ana López", 3000, "Ventas"));
        gestor.agregarEmpleado(new Empleado("Carlos Ruiz", 4500, "TI"));
        gestor.agregarEmpleado(new Empleado("Marta Díaz", 3500, "Ventas"));
        gestor.agregarEmpleado(new Empleado("Pedro Sánchez", 5000, "TI"));
        gestor.agregarEmpleado(new Empleado("Luisa Gómez", 2500, "RH"));

        gestor.mostrarTodosLosEmpleados();

        String departamentoBusqueda = "TI";
        double promedioTI = gestor.promedioSalarioPorDepartamento(departamentoBusqueda);
        System.out.println("\nPromedio salarial en " + departamentoBusqueda + ": $" + promedioTI);

        System.out.println("\n--- Empleados con salario mayor al promedio general ---");
        ArrayList<Empleado> empleadosDestacados = gestor.empleadosSalarioMayorAlPromedio();
        for (Empleado emp : empleadosDestacados) {
            emp.mostrarInfo();
        }

        System.out.println("\n--- Reporte por departamento ---");
        gestor.generarReportePorDepartamento();
    }
}
