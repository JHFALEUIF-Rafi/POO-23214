package modelo;

import javax.swing.JOptionPane;

public class Alerta {
    
    public static void mostrarAlertaSismo(double magnitud) {
        String mensaje;
        String titulo = "Alerta Sísmica";
        
        if (magnitud >= 6.0) {
            mensaje = String.format(
                "⚠️ ALERTA PREVENTIVA ⚠️\n" +
                "Magnitud crítica detectada: %.1f\n" +
                "Se activaron protocolos de emergencia.",
                magnitud
            );
            JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
        } else {
            mensaje = String.format(
                "✅ Situación normal\n" +
                "Magnitud registrada: %.1f\n" +
                "No se requieren acciones adicionales.",
                magnitud
            );
            JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Método para alertas volcánicas (basado en página 9 del PDF)
    public static void mostrarAlertaVolcan(double VEI, String nombreVolcan) {
        String mensaje;
        String titulo = "Alerta Volcánica";
        
        if (VEI >= 4.0) {
            mensaje = String.format(
                "⚠️ ERUPCIÓN INMINENTE ⚠️\n" +
                "Volcán: %s\n" +
                "VEI: %.1f (Explosividad alta)\n" +
                "Evacuar zonas aledañas.",
                nombreVolcan, VEI
            );
            JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
        } else {
            mensaje = String.format(
                "🌋 Actividad normal\n" +
                "Volcán: %s\n" +
                "VEI: %.1f\n" +
                "Monitoreo continuo.",
                nombreVolcan, VEI
            );
            JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
