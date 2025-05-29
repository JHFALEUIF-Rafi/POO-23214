/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

public class CuentaBloqueadaException extends Exception {

    public CuentaBloqueadaException() {
        super("La cuenta está bloqueada");
    }
}
