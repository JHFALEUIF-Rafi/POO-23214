/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package partidoapp;

public class GestorPartidoApp {

    public static void main(String[] args) {
        Equipo equipoA = new Equipo("Equipo A");
        Equipo equipoB = new Equipo("Equipo B");

        Jugador jugador1 = new Jugador("Lionel Messi", 10, "Delantero");
        Jugador jugador2 = new Jugador("Sergio Ramos", 4, "Defensa");
        Jugador jugador3 = new Jugador("Manuel Neuer", 1, "Portero");

        equipoA.agregarJugador(jugador1);
        equipoA.agregarJugador(jugador2);

        equipoB.agregarJugador(jugador3);

        equipoA.mostrarJugadores();
        equipoB.mostrarJugadores();

        equipoA.transferirJugador(jugador2, equipoB);

        equipoA.mostrarJugadores();
        equipoB.mostrarJugadores();
    }
}
