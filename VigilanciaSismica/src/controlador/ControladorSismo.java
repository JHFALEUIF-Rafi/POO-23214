package controlador;

import modelo.CalcularSismo;
import modelo.Sismo;
import modelo.SismoDAO;

public class ControladorSismo {

    private SismoDAO sismoDAO;
    private CalcularSismo calculadora;

    public void procesarSismo(Sismo sismo) {
        double magnitud = calculadora.calcularMagnitud(sismo.getDuracion(), sismo.getAmplitud());
        sismo.setMagnitud(magnitud);
        sismoDAO.guardarSismo(sismo);
    }
}
