/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleadoherenciaapp;

public class Operario extends Empleado {

    private String horario;

    public Operario(String horario, String nombre) {
        super(nombre);
        this.horario = horario;
    }

    @Override
    public String toString() {
        return super.toString() + "Operario{" + "horario=" + horario + '}';
    }

}
