/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package empleado;

public class GestorEmpleado {

    public static void main(String[] args) {
        //Ejercicio 1
        Empleado objtEmp1 = new Empleado("Rafi", "Tilin", 450.22);
        System.out.println("****Resumen****");
        objtEmp1.mostrarSalario();
        objtEmp1.aumentarSalario();
        objtEmp1.mostrarSalario();
        
        Empleado objtEmp2 = new Empleado("Javier", "Serrano",-2000.50);
        System.out.println("****Resumen****");
        objtEmp2.mostrarSalario();
        objtEmp2.aumentarSalario();
        objtEmp2.mostrarSalario();
        
        //Ejercicio 2
        
    }
    
}
