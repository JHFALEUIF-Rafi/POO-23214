/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package banco;

public class GestorBanco {

  
    public static void main(String[] args) {
        CuentaCorriente cc = new CuentaCorriente("123456", "Juan Pérez", 500000);
        CuentaAhorros ca = new CuentaAhorros("654321", "María Gómez", 1000000);

        try {
            cc.depositar(200000);
            System.out.println("Saldo CC después de depósito: " + cc.getSaldo());

            cc.retirar(100000);
            System.out.println("Saldo CC después de retiro: " + cc.getSaldo());

            cc.transferir(ca, 150000);
            System.out.println("Saldo CC después de transferencia: " + cc.getSaldo());
            System.out.println("Saldo CA después de transferencia: " + ca.getSaldo());

            for (int i = 0; i < 3; i++) {
                try {
                    cc.retirar(1000000);
                } catch (SaldoInsuficienteException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            cc.retirar(1000); 

        } catch (OperacionInvalidaException | SaldoInsuficienteException | 
                LimiteDiarioException | CuentaBloqueadaException e) {
            System.out.println("Operación fallida: " + e.getMessage());
        }
    }
}

