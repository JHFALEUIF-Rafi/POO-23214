/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleadoherenciaapp;

public class Oficial extends Operario{
    private int horasExtras;

    public Oficial(int horasExtras, String horario, String nombre) {
        super(horario, nombre);
        this.horasExtras = horasExtras;
    }

    @Override
    public String toString() {
        return super.toString()+ "Oficial{" + "horasExtras=" + horasExtras + '}';
    }
    
    
}
