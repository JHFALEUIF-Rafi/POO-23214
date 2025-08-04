package controlador;

import modelo.*;
import vista.sub_CalcularOrigenSismica_Operador;
import javax.swing.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ControladorOrigenSismico {

    private final sub_CalcularOrigenSismica_Operador vista;
    private final ControladorSismo controladorSismo;
    private final SismoDAO sismoDAO;

    public ControladorOrigenSismico(sub_CalcularOrigenSismica_Operador vista) {
        this.vista = vista;
        this.sismoDAO = new SismoDAO();
        this.controladorSismo = new ControladorSismo(sismoDAO, new CalcularSismo());
        configurarEventos();
        cargarDatos();
    }

    private void configurarEventos() {
        vista.btnCalcular.addActionListener(e -> calcularEpicentro());
        vista.btnGuardar.addActionListener(e -> guardarDatos());
    }

    private void cargarDatos() {
        // Limpiar comboBox primero
        vista.cbxEvento.removeAllItems();

        // Llenar comboBox con sismos no procesados
        List<Sismo> sismos = sismoDAO.listarSismosNoProcesados();
        sismos.forEach(sismo -> vista.cbxEvento.addItem(sismo.getId()));

        // Llenar tabla con datos reales (ejemplo con el primer sismo si existe)
        if (!sismos.isEmpty()) {
            Sismo primerSismo = sismos.get(0);
            DefaultTableModel model = (DefaultTableModel) vista.jtTablaEstaciones.getModel();
            model.setRowCount(0); // Limpiar tabla

            // Agregar datos de las estaciones (esto debería venir de la base de datos)
            primerSismo.getEstaciones().forEach(estacion -> {
                // Aquí deberías obtener los datos reales de cada estación
                model.addRow(new Object[]{
                    estacion,
                    "0.0", // Latitud (debería ser real)
                    "0.0", // Longitud (debería ser real)
                    "0.0", // Tiempo P (debería ser real)
                    "0.0" // Tiempo S (debería ser real)
                });
            });
        }
    }

    private void calcularEpicentro() {
        try {
            // 1. Obtener tiempos P y S de la tabla (simulados)
            double tiempoP = Double.parseDouble(vista.jtTablaEstaciones.getValueAt(0, 3).toString());
            double tiempoS = Double.parseDouble(vista.jtTablaEstaciones.getValueAt(0, 4).toString());

            // 2. Usar ControladorSismo para cálculos básicos
            double magnitud = controladorSismo.calcularMagnitud(tiempoP, tiempoS);

            // 3. Cálculo de coordenadas (simplificado)
            double latitud = -12.045 + (Math.random() * 0.01); // Ejemplo aleatorio
            double longitud = -77.030 + (Math.random() * 0.01);

            // Mostrar resultados
            vista.txtLatitud.setText(String.format("%.4f", latitud));
            vista.txtLongitud.setText(String.format("%.4f", longitud));
            vista.txtMargenError.setText("0.5"); // Margen simulado

        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void guardarDatos() {
        String idSismo = (String) vista.cbxEvento.getSelectedItem();
        Sismo sismo = sismoDAO.buscarPorId(idSismo);

        // Actualizar epicentro usando Coordenada
        sismo.setEpicentro(new Coordenada(
                Double.parseDouble(vista.txtLatitud.getText()),
                Double.parseDouble(vista.txtLongitud.getText())
        ));

        // Marcar como procesado
        controladorSismo.marcarComoMedido(idSismo);
        JOptionPane.showMessageDialog(vista, "¡Datos guardados!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
}
