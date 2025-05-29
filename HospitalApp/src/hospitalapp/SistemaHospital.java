/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalapp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SistemaHospital {
    private List<Doctor> doctores;
    private List<Paciente> pacientes;
    private List<Cita> citas;

    public SistemaHospital() {
        this.doctores = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.citas = new ArrayList<>();
    }

    // Métodos para doctores
    public void registrarDoctor(Doctor doctor) {
        doctores.add(doctor);
    }

    public Doctor buscarDoctorPorLicencia(String licencia) {
        for (Doctor doctor : doctores) {
            if (doctor.getLicencia().equals(licencia)) {
                return doctor;
            }
        }
        return null;
    }

    public void registrarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public Paciente buscarPacientePorId(String idPaciente) {
        for (Paciente paciente : pacientes) {
            if (paciente.getIdPaciente().equals(idPaciente)) {
                return paciente;
            }
        }
        return null;
    }

    public Cita programarCita(String idCita, LocalDateTime fechaHora, String motivo, 
                            String licenciaDoctor, String idPaciente) {
        Doctor doctor = buscarDoctorPorLicencia(licenciaDoctor);
        Paciente paciente = buscarPacientePorId(idPaciente);

        if (doctor == null || paciente == null) {
            System.out.println("Doctor o paciente no encontrado");
            return null;
        }

        Cita nuevaCita = new Cita(idCita, fechaHora, motivo, doctor, paciente);
        citas.add(nuevaCita);
        System.out.println("Cita programada exitosamente:\n" + nuevaCita);
        return nuevaCita;
    }

    public void cancelarCita(String idCita) {
        Cita cita = buscarCitaPorId(idCita);
        if (cita != null) {
            cita.cancelarCita();
            citas.remove(cita);
        } else {
            System.out.println("Cita no encontrada");
        }
    }

    public void modificarCita(String idCita, LocalDateTime nuevaFecha, String nuevoMotivo) {
        Cita cita = buscarCitaPorId(idCita);
        if (cita != null) {
            cita.modificarCita(nuevaFecha, nuevoMotivo);
        } else {
            System.out.println("Cita no encontrada");
        }
    }

    public Cita buscarCitaPorId(String idCita) {
        for (Cita cita : citas) {
            if (cita.getIdCita().equals(idCita)) {
                return cita;
            }
        }
        return null;
    }

    public void mostrarHistorialPaciente(String idPaciente) {
        Paciente paciente = buscarPacientePorId(idPaciente);
        if (paciente != null) {
            System.out.println("Historial de citas para " + paciente.getNombre() + ":");
            for (Cita cita : paciente.getHistorialCitas()) {
                System.out.println(cita);
            }
        } else {
            System.out.println("Paciente no encontrado");
        }
    }

    public void mostrarHistorialDoctor(String licencia) {
        Doctor doctor = buscarDoctorPorLicencia(licencia);
        if (doctor != null) {
            System.out.println("Historial de citas para Dr. " + doctor.getNombre() + ":");
            for (Cita cita : doctor.getHistorialCitas()) {
                System.out.println(cita);
            }
        } else {
            System.out.println("Doctor no encontrado");
        }
    }
}