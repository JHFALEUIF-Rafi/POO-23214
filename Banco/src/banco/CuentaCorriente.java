/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

public class CuentaCorriente extends Cuenta {
    private static final double LIMITE_DIARIO = 1000000;

    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial) {
        super(numeroCuenta, titular, saldoInicial);
    }

    @Override
    public void retirar(double monto) throws SaldoInsuficienteException, LimiteDiarioException, CuentaBloqueadaException {
        if (isBloqueada()) {
            throw new CuentaBloqueadaException();
        }
        if (monto > LIMITE_DIARIO) {
            throw new LimiteDiarioException();
        }
        if (getSaldo() < monto) {
            setIntentosFallidos(getIntentosFallidos() + 1);
            if (getIntentosFallidos() >= 3) {
                setBloqueada(true);
            }
            throw new SaldoInsuficienteException();
        }
        setSaldo(getSaldo() - monto);
        setIntentosFallidos(0);  
    }
}

