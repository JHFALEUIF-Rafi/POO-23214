/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package computacionapp;

import java.util.ArrayList;
import java.util.List;

public class Computadora {
    private String id;
    private String nombre;
    private List<Componente> componentes;

    public Computadora(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.componentes = new ArrayList<>();
    }

    public void agregarComponente(Componente componente) {
        if (!contieneComponente(componente.getId())) {
            componentes.add(componente);
            System.out.println("Componente " + componente.getId() + " agregado a " + nombre);
        } else {
            System.out.println("El componente ya está en esta computadora");
        }
    }

    public void removerComponente(String idComponente) {
        Componente aRemover = null;
        for (Componente c : componentes) {
            if (c.getId().equals(idComponente)) {
                aRemover = c;
                break;
            }
        }
        
        if (aRemover != null) {
            componentes.remove(aRemover);
            System.out.println("Componente " + idComponente + " removido de " + nombre);
        } else {
            System.out.println("Componente no encontrado en esta computadora");
        }
    }

    private boolean contieneComponente(String idComponente) {
        for (Componente c : componentes) {
            if (c.getId().equals(idComponente)) {
                return true;
            }
        }
        return false;
    }

    public void mostrarComponentes() {
        System.out.println("\nComponentes de " + nombre + " (" + id + "):");
        if (componentes.isEmpty()) {
            System.out.println("  - No tiene componentes");
        } else {
            for (Componente c : componentes) {
                System.out.println("  - " + c);
            }
        }
    }

    public void simularFalloComponente(String idComponente) {
        for (Componente c : componentes) {
            if (c.getId().equals(idComponente)) {
                c.fallar();
                return;
            }
        }
        System.out.println("Componente no encontrado");
    }

    public void verificarEstado() {
        System.out.println("\nEstado de " + nombre + ":");
        boolean todosFuncionan = true;
        
        for (Componente c : componentes) {
            if (!c.isFunciona()) {
                todosFuncionan = false;
                System.out.println("  [!] " + c.getTipo() + " (" + c.getId() + ") no funciona");
            }
        }
        
        if (todosFuncionan) {
            System.out.println("  Todos los componentes funcionan correctamente");
        }
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Componente> getComponentes() {
        return new ArrayList<>(componentes); 
    }
}
