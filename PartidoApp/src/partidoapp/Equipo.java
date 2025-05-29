/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package partidoapp;
import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String nombre;
    private List<Jugador> jugadores;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
    }

    public void agregarJugador(Jugador jugador) {
        if (jugador.getEquipo() != null) {
            System.out.println("El jugador " + jugador.getNombre() + " ya pertenece a otro equipo");
            return;
        }

        jugadores.add(jugador);
        jugador.setEquipo(this); 
        System.out.println(jugador.getNombre() + " agregado al equipo " + nombre);
    }

    public void transferirJugador(Jugador jugador, Equipo nuevoEquipo) {
        if (!jugadores.contains(jugador)) {
            System.out.println("El jugador " + jugador.getNombre() + " no pertenece a este equipo");
            return;
        }

        jugadores.remove(jugador);
        nuevoEquipo.agregarJugador(jugador);
        System.out.println(jugador.getNombre() + " transferido de " + nombre + " a " + nuevoEquipo.getNombre());
    }

    public void mostrarJugadores() {
        if (jugadores.isEmpty()) {
            System.out.println("El equipo " + nombre + " no tiene jugadores");
            return;
        }

        System.out.println("Jugadores del equipo " + nombre + ":");
        for (Jugador jugador : jugadores) {
            System.out.println(" - " + jugador);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }
}
