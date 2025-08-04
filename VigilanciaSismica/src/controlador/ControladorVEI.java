package controlador;

import java.util.Collections;
import java.util.Date;
import modelo.*;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.Objects;

public class ControladorVEI {

    private final VolcanDAO volcanDao;

    public ControladorVEI(VolcanDAO volcanDao) {
        this.volcanDao = volcanDao;
    }

    public Erupcion registrarErupcion(String idEvento, String nombreVolcan,
            double volumenTefra, double alturaColumna, List<String> estaciones) {

        if (volumenTefra <= 0 || alturaColumna <= 0) {
            JOptionPane.showMessageDialog(null,
                    "Error: Volumen y altura deben ser positivos.",
                    "Datos Inválidos",
                    JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Datos inválidos");
        }

        Erupcion erupcion = new Erupcion(
                idEvento, new Date(), estaciones,
                nombreVolcan, volumenTefra, alturaColumna,
                "Registro automático"
        );

        double VEIHistoricoMax = obtenerVEIHistoricoMax(nombreVolcan);
        if (erupcion.getVEI() > VEIHistoricoMax + 1) {
            mostrarAlertaVolcanica(erupcion, VEIHistoricoMax);
        }

        Volcan volcan = volcanDao.buscarPorNombre(nombreVolcan);
        if (volcan == null) {
            volcan = new Volcan(nombreVolcan, erupcion.getVEI());
        }
        volcan.agregarErupcion(erupcion);
        volcanDao.guardarVolcan(volcan);

        return erupcion;
    }

    private double obtenerVEIHistoricoMax(String nombreVolcan) {
        return volcanDao.obtenerHistorico(nombreVolcan).stream()
                .mapToDouble(Erupcion::getVEI)
                .max()
                .orElse(0.0);
    }

    private void mostrarAlertaVolcanica(Erupcion erupcion, double VEIHistoricoMax) {
        String mensaje = String.format(
                "🚨 **ALERTA VOLCÁNICA** 🚨\n"
                + "Volcán: %s\n"
                + "VEI Actual: %.1f (VEI Histórico Máximo: %.1f)\n"
                + "¡Notificar a equipo científico!",
                erupcion.getNombreVolcan(), erupcion.getVEI(), VEIHistoricoMax
        );
        JOptionPane.showMessageDialog(null, mensaje, "Alerta Crítica", JOptionPane.ERROR_MESSAGE);
    }

    public List<Erupcion> obtenerHistorico(String nombreVolcan) {
        Objects.requireNonNull(nombreVolcan, "El nombre del volcán no puede ser nulo");
        List<Erupcion> historico = volcanDao.obtenerHistorico(nombreVolcan);
        return historico != null ? historico : Collections.emptyList();
    }
}
