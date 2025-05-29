/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalapp;

import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private String nombre;
    private String idPaciente;
    private String telefono;
    private List<Cita> historialCitas;

    public Paciente(String nombre, String idPaciente, String telefono) {
        this.nombre = nombre;
        this.idPaciente = idPaciente;
        this.telefono = telefono;
        this.historialCitas = new ArrayList<>();
    }

    public void agregarCita(Cita cita) {
        historialCitas.add(cita);
    }

    public void removerCita(Cita cita) {
        historialCitas.remove(cita);
    }

    public List<Cita> getHistorialCitas() {
        return new ArrayList<>(historialCitas);
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return nombre + " (ID: " + idPaciente + ")";
    }
}
