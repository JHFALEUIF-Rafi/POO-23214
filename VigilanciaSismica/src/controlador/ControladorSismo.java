package controlador;

import modelo.*;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.List;

public class ControladorSismo {

    private final SismoDAO sismoDAO;
    private final CalcularSismo calculadora;

    public ControladorSismo(SismoDAO sismoDAO, CalcularSismo calculadora) {
        this.sismoDAO = sismoDAO;
        this.calculadora = calculadora;
    }

    public void procesarDatosSismicos(String id, double duracion, double amplitud,
            Coordenada epicentro, Date fecha, List<String> estaciones) {

        // 1. Calcular magnitud (Flujo Normal, paso 3)
        double magnitud = calculadora.calcularMagnitud(duracion, amplitud);

        // 2. Crear y guardar sismo
        Sismo sismo = new Sismo(id, magnitud, epicentro, fecha, estaciones);
        sismoDAO.guardarSismo(sismo);

        // 3. Validar alerta (Flujo Normal, paso 4)
        if (magnitud >= 6.0) {
            mostrarAlertaSismica(magnitud, epicentro);
            sismoDAO.marcarSismoComoCritico(id); // Método adicional a implementar
        }

        // 4. Mostrar confirmación (Flujo Normal, paso 6)
        JOptionPane.showMessageDialog(null,
                "Magnitud calculada: " + magnitud + "\nEvento registrado correctamente.",
                "Proceso Completado",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarAlertaSismica(double magnitud, Coordenada epicentro) {
        String mensaje = String.format(
                "⚠️ **ALERTA PREVENTIVA** ⚠️\n"
                + "Magnitud: %.1f\n"
                + "Epicentro: Lat %.4f, Long %.4f\n"
                + "Se activaron protocolos de emergencia.",
                magnitud, epicentro.getLatitud(), epicentro.getLongitud()
        );
        JOptionPane.showMessageDialog(null, mensaje, "Alerta Sísmica", JOptionPane.WARNING_MESSAGE);
    }

    public void marcarComoMedido(String idSismo) {
        sismoDAO.marcarSismoComoMedido(idSismo);
    }

    public double calcularMagnitud(double tiempoP, double tiempoS) {
        double amplitud = tiempoS - tiempoP; 
        return calculadora.calcularMagnitud(tiempoP, amplitud);
    }
}
