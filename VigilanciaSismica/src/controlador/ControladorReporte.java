package controlador;

import modelo.Sismo;
import modelo.SismoDAO;
import javax.swing.JOptionPane;
import java.util.Date;

public class ControladorReporte {

    private final SismoDAO sismoDao;

    public ControladorReporte() {
        this.sismoDao = new SismoDAO();
    }


    public void generarReporte(String idSismo) {
        try {
            // 1. Buscar sismo en la base de datos
            Sismo sismo = sismoDao.buscarPorId(idSismo);

            if (sismo == null) {
                JOptionPane.showMessageDialog(null,
                        "⚠️ Sismo no encontrado en la base de datos",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 2. Crear contenido del reporte (formato simplificado)
            String reporte = String.format(
                    "📄 **REPORTE TÉCNICO**\n\n"
                    + "ID: %s\n"
                    + "Fecha: %s\n"
                    + "Magnitud: %.1f\n"
                    + "Epicentro: Lat %.4f, Long %.4f\n"
                    + "Estaciones: %s",
                    sismo.getId(),
                    sismo.getFecha(),
                    sismo.getMagnitud(),
                    sismo.getEpicentro().getLatitud(),
                    sismo.getEpicentro().getLongitud(),
                    String.join(", ", sismo.getEstaciones())
            );

            JOptionPane.showMessageDialog(null, reporte, "Reporte Generado", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al generar reporte: " + e.getMessage(),
                    "Error crítico",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void enviarNotificacion(String idSismo) {
        try {
            // 1. Marcar como reportado en la base de datos
            sismoDao.marcarComoReportado(idSismo);

            // 2. Simular envío de notificación
            JOptionPane.showMessageDialog(null,
                    "🚨 **NOTIFICACIÓN ENVIADA**\n\n"
                    + "El sismo " + idSismo + " ha sido reportado a:\n"
                    + "- Equipos de emergencia\n"
                    + "- Monitoreo sísmico nacional",
                    "Notificación Exitosa",
                    JOptionPane.WARNING_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al enviar notificación: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
