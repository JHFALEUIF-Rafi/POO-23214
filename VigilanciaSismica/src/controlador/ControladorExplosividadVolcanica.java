package controlador;

import modelo.*;
import vista.sub_CuantificarExplosividad_Operador;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class ControladorExplosividadVolcanica {

    private final sub_CuantificarExplosividad_Operador vista;
    private final VolcanDAO volcanDAO;
    private final ControladorVEI controladorVEI;

    public ControladorExplosividadVolcanica(sub_CuantificarExplosividad_Operador vista) {
        this.vista = vista;
        this.volcanDAO = new VolcanDAO();
        this.controladorVEI = new ControladorVEI(volcanDAO);
        configurarEventos();
        cargarVolcanes();
    }

    // --- Métodos clave ---
    private void configurarEventos() {
        vista.btnCalcularVEI.addActionListener(e -> calcularVEI());
        vista.btnGuardar.addActionListener(e -> guardarErupcion());
        vista.cbxEventosVolcanicos.addActionListener(e -> cargarHistorico());
    }

    private void cargarVolcanes() {
        try {
            List<Volcan> volcanes = volcanDAO.listarTodos();
            volcanes.forEach(v -> vista.cbxEventosVolcanicos.addItem(v.getNombre()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Error al cargar volcanes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarHistorico() {
        String nombreVolcan = (String) vista.cbxEventosVolcanicos.getSelectedItem();
        if (nombreVolcan != null && !nombreVolcan.isEmpty()) {
            try {
                List<Erupcion> historico = volcanDAO.obtenerHistorico(nombreVolcan);
                DefaultTableModel model = (DefaultTableModel) vista.jtTablaHistorico.getModel();
                model.setRowCount(0); // Limpiar tabla antes de agregar datos

                historico.forEach(erupcion -> {
                    model.addRow(new Object[]{
                        erupcion.getId(),
                        erupcion.getFecha(),
                        nombreVolcan,
                        String.format("%.2f", erupcion.getVEI()),
                        erupcion.getDescripcion()
                    });
                });
            } catch (Exception e) {
                JOptionPane.showMessageDialog(vista,
                        "Error al cargar histórico: " + e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Método para el botón "Calcular VEI"
    private void calcularVEI() {
        try {
            double volumen = Double.parseDouble(vista.txtVolumenTr.getText());
            double altura = Double.parseDouble(vista.txtAlturaColumna.getText());

            // Usar la fórmula de Erupcion.java
            Erupcion erupcionTemp = new Erupcion(
                    "temp", new Date(),
                    List.of(), "temp", volumen, altura, "Cálculo temporal"
            );

            vista.lbNivelConfianza.setText("VEI: " + erupcionTemp.getVEI());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Ingrese valores numéricos válidos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para el botón "Guardar"
    private void guardarErupcion() {
        try {
            String nombreVolcan = (String) vista.cbxEventosVolcanicos.getSelectedItem();
            double volumen = Double.parseDouble(vista.txtVolumenTr.getText());
            double altura = Double.parseDouble(vista.txtAlturaColumna.getText());

            // Registrar la erupción
            Erupcion erupcion = controladorVEI.registrarErupcion(
                    "ERU-" + System.currentTimeMillis(),
                    nombreVolcan,
                    volumen,
                    altura,
                    List.of("Estación1", "Estación2")
            );

            // Actualizar la tabla con los nuevos datos
            DefaultTableModel model = (DefaultTableModel) vista.jtTablaHistorico.getModel();
            model.addRow(new Object[]{
                erupcion.getId(),
                erupcion.getFecha(),
                nombreVolcan,
                erupcion.getVEI(),
                erupcion.getDescripcion()
            });

            JOptionPane.showMessageDialog(vista,
                    "¡Datos guardados y tabla actualizada!",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista,
                    "Error al guardar: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
