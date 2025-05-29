/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalapp;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String nombre;
    private String especialidad;
    private String licencia;
    private List<Cita> citas;

    public Doctor(String nombre, String especialidad, String licencia) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.licencia = licencia;
        this.citas = new ArrayList<>();
    }

    public void agregarCita(Cita cita) {
        citas.add(cita);
    }

    public void removerCita(Cita cita) {
        citas.remove(cita);
    }

    public List<Cita> getHistorialCitas() {
        return new ArrayList<>(citas); 
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getLicencia() {
        return licencia;
    }

    @Override
    public String toString() {
        return "Dr. " + nombre + " - " + especialidad + " (Lic. " + licencia + ")";
    }
}
