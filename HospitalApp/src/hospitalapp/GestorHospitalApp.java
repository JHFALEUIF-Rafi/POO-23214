/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hospitalapp;

import java.time.LocalDateTime;

public class GestorHospitalApp {

    public static void main(String[] args) {
        SistemaHospital hospital = new SistemaHospital();

        // Registrar doctores
        Doctor drSmith = new Doctor("John Smith", "Cardiología", "LIC123");
        Doctor drJohnson = new Doctor("Emily Johnson", "Pediatría", "LIC456");
        hospital.registrarDoctor(drSmith);
        hospital.registrarDoctor(drJohnson);

        // Registrar pacientes
        Paciente paciente1 = new Paciente("María González", "PAC001", "555-1234");
        Paciente paciente2 = new Paciente("Carlos López", "PAC002", "555-5678");
        hospital.registrarPaciente(paciente1);
        hospital.registrarPaciente(paciente2);

        // Programar citas
        hospital.programarCita("CITA001", 
            LocalDateTime.of(2023, 12, 15, 10, 0), 
            "Consulta rutinaria", "LIC123", "PAC001");

        hospital.programarCita("CITA002", 
            LocalDateTime.of(2023, 12, 16, 11, 30), 
            "Control anual", "LIC456", "PAC002");

        // Modificar una cita
        hospital.modificarCita("CITA001", 
            LocalDateTime.of(2023, 12, 15, 11, 0), 
            "Consulta urgente");

        // Mostrar historiales
        hospital.mostrarHistorialPaciente("PAC001");
        hospital.mostrarHistorialDoctor("LIC123");

        // Cancelar una cita
        hospital.cancelarCita("CITA002");

        // Mostrar historiales después de cancelar
        hospital.mostrarHistorialPaciente("PAC002");
        hospital.mostrarHistorialDoctor("LIC456");
    }
}

