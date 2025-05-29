/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cargamentoapp;
public class GestrorCargamentoApp {

    
    public static void main(String[] args) {
        Camion camion = new Camion("ABC-1234", 5000);
        camion.mostrarEstado();

        // Crear algunas cargas
        Carga caja1 = new Carga("Electrodomésticos", 1200);
        Carga caja2 = new Carga("Muebles", 2500);
        Carga caja3 = new Carga("Materiales de construcción", 1800);
        Carga caja4 = new Carga("Alimentos", 800);

        camion.agregarCarga(caja1);
        camion.agregarCarga(caja2);
        camion.mostrarEstado();

        camion.agregarCarga(caja3);
        camion.mostrarEstado();

        camion.agregarCarga(caja4);
        camion.mostrarEstado();

        camion.eliminarCarga(0);
        camion.mostrarEstado();

        camion.agregarCarga(caja3);
        camion.mostrarEstado();

        System.out.println("Carga disponible restante: " + camion.cargaDisponible() + " kg");
    }
}
