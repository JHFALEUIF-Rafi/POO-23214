/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package asociacionprograma;

public class GestorAsociacionPrograma {

    public static void main(String[] args) {
        Usuario u1 = new Usuario("Pedro", 111);
        Usuario u2 = new Usuario("Ana", 222);
        Programa p1 = new Programa("Adobe", 2.5f);
        Programa p2 = new Programa("Netbeans", 2.3f);

        u1.instalarPrograma(p1);
        u1.instalarPrograma(p2);
        u1.instalarPrograma(p1);
    }
}
