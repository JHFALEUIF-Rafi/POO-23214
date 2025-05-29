/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

public class LimiteDiarioException extends Exception {
    public LimiteDiarioException() {
        super("Límite diario de retiro excedido");
    }
}
