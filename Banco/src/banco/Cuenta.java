/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;
public abstract class Cuenta {
    private String numeroCuenta;
    private double saldo;
    private String titular;
    private boolean bloqueada;
    private int intentosFallidos;

    public Cuenta(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
        this.bloqueada = false;
        this.intentosFallidos = 0;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {  
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public boolean isBloqueada() {
        return bloqueada;
    }

    protected void setBloqueada(boolean bloqueada) {  
        this.bloqueada = bloqueada;
    }

    protected int getIntentosFallidos() {  
        return intentosFallidos;
    }

    protected void setIntentosFallidos(int intentosFallidos) {  
        this.intentosFallidos = intentosFallidos;
    }


    public void depositar(double monto) throws OperacionInvalidaException {
        if (monto <= 0) {
            throw new OperacionInvalidaException("El monto debe ser positivo");
        }
        saldo += monto;
    }

    public abstract void retirar(double monto) throws SaldoInsuficienteException, LimiteDiarioException, CuentaBloqueadaException;

    public void transferir(Cuenta destino, double monto) throws OperacionInvalidaException {
        if (destino == null) {
            throw new OperacionInvalidaException("Cuenta destino inválida");
        }
        try {
            this.retirar(monto);
            destino.depositar(monto);
        } catch (SaldoInsuficienteException | LimiteDiarioException | CuentaBloqueadaException e) {
            throw new OperacionInvalidaException("Transferencia fallida: " + e.getMessage());
        }
    }
}
