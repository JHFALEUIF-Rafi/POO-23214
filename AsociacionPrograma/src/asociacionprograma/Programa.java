/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asociacionprograma;

import java.util.ArrayList;
import java.util.Iterator;

public class Programa {

    private String nombrePrograma;
    private float peso;

    //Asociacion NN
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public Programa(String nombrePrograma, float peso) {
        this.nombrePrograma = nombrePrograma;
        this.peso = peso;
    }

    public Programa() {
    }

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void crearUsuario(Usuario usuario) {
        Iterator<Usuario> iterator = usuarios.iterator();
        Usuario aux = new Usuario();
        boolean encontrado = false;
        while (iterator.hasNext() && !encontrado) {
            aux = iterator.next();
            if (aux.getClave() == usuario.getClave()) {
                encontrado = true;
            }
        }
        if (encontrado) {
            System.out.println("El usuario ya existe");
        } else {
            usuarios.add(usuario);
            System.out.println("Usuario creado");
        }
    }
}
