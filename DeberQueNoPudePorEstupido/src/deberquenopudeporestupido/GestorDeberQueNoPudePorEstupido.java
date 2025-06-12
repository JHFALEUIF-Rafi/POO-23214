package deberquenopudeporestupido;
public class GestorDeberQueNoPudePorEstupido {

    public static void main(String[] args) {
        
        EmpleadoAsalariado empleado1 = new EmpleadoAsalariado(1000.0, "123-45-6789", "Juan Pérez");
        EmpleadoPorHoras empleado2 = new EmpleadoPorHoras(15.0, 45.0, "234-56-7890", "María López");
        EmpleadoPorComision empleado3 = new EmpleadoPorComision(50000.0, 0.1, "345-67-8901", "Carlos García");
        EmpleadoBaseMasComision empleado4 = new EmpleadoBaseMasComision(2000.0, 30000.0, 0.08, "456-78-9012", "Ana Martínez");

        System.out.println("=== EMPLEADOS ===");
        mostrarEmpleado(empleado1);
        mostrarEmpleado(empleado2);
        mostrarEmpleado(empleado3);
        mostrarEmpleado(empleado4);
    }

    public static void mostrarEmpleado(Empleado empleado) {
        System.out.println("\n" + empleado.getClass().getSimpleName() + ":");
        System.out.println(empleado.toString());
        System.out.printf("Ingresos: $%,.2f%n", empleado.ingresos());
       
        if (empleado instanceof EmpleadoPorHoras) {
            EmpleadoPorHoras empHoras = (EmpleadoPorHoras) empleado;
            System.out.printf("Horas trabajadas: %.2f, Sueldo por hora: $%.2f%n", 
                empHoras.getHorasTrabajadas(), empHoras.getSueldoPorHoras());
        } else if (empleado instanceof EmpleadoPorComision) {
            EmpleadoPorComision empComision = (EmpleadoPorComision) empleado;
            System.out.printf("Ventas brutas: $%,.2f, Tarifa comisión: %.2f%%%n", 
                empComision.getVentasBrutas(), empComision.getTarifaComision() * 100);
            
            if (empleado instanceof EmpleadoBaseMasComision) {
                EmpleadoBaseMasComision empBaseComision = (EmpleadoBaseMasComision) empleado;
                System.out.printf("Salario base: $%,.2f%n", empBaseComision.getSalarioBase());
            }
        } else if (empleado instanceof EmpleadoAsalariado) {
            System.out.printf("Salario semanal: $%,.2f%n", ((EmpleadoAsalariado) empleado).ingresos());
        }
    }
}