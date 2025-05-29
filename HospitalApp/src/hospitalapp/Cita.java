/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalapp;

import java.time.LocalDateTime;

public class Cita {
    private String idCita;
    private LocalDateTime fechaHora;
    private String motivo;
    private Doctor doctor;
    private Paciente paciente;
    private boolean cancelada;

    public Cita(String idCita, LocalDateTime fechaHora, String motivo, Doctor doctor, Paciente paciente) {
        this.idCita = idCita;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.doctor = doctor;
        this.paciente = paciente;
        this.cancelada = false;

        doctor.agregarCita(this);
        paciente.agregarCita(this);
    }

    public void modificarCita(LocalDateTime nuevaFecha, String nuevoMotivo) {
        this.fechaHora = nuevaFecha;
        this.motivo = nuevoMotivo;
        System.out.println("Cita modificada: " + this);
    }

    public void cancelarCita() {
        this.cancelada = true;
        doctor.removerCita(this);
        paciente.removerCita(this);
        System.out.println("Cita cancelada: " + this);
    }

    // Getters
    public String getIdCita() {
        return idCita;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    @Override
    public String toString() {
        return "Cita #" + idCita + " - " + fechaHora + 
               "\nDoctor: " + doctor.getNombre() + 
               "\nPaciente: " + paciente.getNombre() + 
               "\nMotivo: " + motivo + 
               "\nEstado: " + (cancelada ? "Cancelada" : "Programada");
    }
}
