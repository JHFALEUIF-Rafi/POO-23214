package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.ArchivoProveedor;
import modelo.Proveedor;
import modelo.ProveedorDAO;
import vista.FrmProveedor;

public class ControladorProveedor implements ActionListener {

    private ProveedorDAO objtDAO;
    private FrmProveedor objtVista;
    private Proveedor proveedorSeleccionado;
    private ArchivoProveedor archivoProv = new ArchivoProveedor();
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private final Pattern cedulaPattern = Pattern.compile("^\\d{10}$");

    public ControladorProveedor(FrmProveedor vista, ProveedorDAO dao) {
        objtVista = vista;
        objtDAO = dao;

        // Configurar listeners para los botones
        objtVista.btnAgregar.addActionListener(this);
        objtVista.btnMostrar.addActionListener(this);
        objtVista.btnEliminar.addActionListener(this);
        objtVista.btnModificar.addActionListener(this);
        objtVista.btnMigracion.addActionListener(this);

        // Listener para selección en la tabla
        objtVista.tablaDatos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                cargarProveedorSeleccionado();
            }
        });

        // Cargar datos iniciales
        llenarTabla(objtVista.tablaDatos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == objtVista.btnAgregar) {
            agregarProveedor();
        } else if (e.getSource() == objtVista.btnMostrar) {
            llenarTabla(objtVista.tablaDatos);
        } else if (e.getSource() == objtVista.btnEliminar) {
            eliminarProveedorSeleccionado();
        } else if (e.getSource() == objtVista.btnModificar) {
            modificarProveedor();
        } else if (e.getSource() == objtVista.btnMigracion) {
            migrarDatos();
        }
    }

    private boolean validarCedula(String cedula) {
        return cedulaPattern.matcher(cedula).matches();
    }

    private void agregarProveedor() {
        try {
            String nombre = objtVista.txtNombre.getText().trim();
            String pais = objtVista.txtPaís.getText().trim();
            String cedulaStr = objtVista.txtCedula.getText().trim();

            Date fechaNacimiento = obtenerFechaValidada();

            if (nombre.isEmpty() || pais.isEmpty() || cedulaStr.isEmpty()) {
                mostrarError("Los campos nombre, país y cédula son obligatorios");
                return;
            }

            if (!validarCedula(cedulaStr)) {
                mostrarError("La cédula debe tener exactamente 10 dígitos");
                return;
            }

            if (fechaNacimiento == null) {
                mostrarError("Debe seleccionar una fecha de nacimiento");
                return;
            }

            int cedula = Integer.parseInt(cedulaStr);
            Proveedor nuevoProveedor = new Proveedor(nombre, pais, cedula, fechaNacimiento);

            objtDAO.insertarProveedor(nuevoProveedor);
            mostrarMensaje("Proveedor agregado correctamente");
            limpiarCampos();
            llenarTabla(objtVista.tablaDatos);
        } catch (Exception ex) {
        }
    }

    private void modificarProveedor() {
        try {
            if (proveedorSeleccionado == null) {
                mostrarError("Seleccione un proveedor primero");
                return;
            }

            String nombre = objtVista.txtNombre.getText().trim();
            String pais = objtVista.txtPaís.getText().trim();
            Date fechaNacimiento = obtenerFechaValidada();

            Proveedor actualizado = new Proveedor(
                    nombre,
                    pais,
                    proveedorSeleccionado.getCedula(),
                    fechaNacimiento
            );

            objtDAO.modificarProveedor(proveedorSeleccionado, actualizado);
            mostrarMensaje("Proveedor actualizado correctamente");
            limpiarCampos();
            llenarTabla(objtVista.tablaDatos);
        } catch (Exception ex) {
        }
    }

    private void eliminarProveedorSeleccionado() {
        try {
            if (proveedorSeleccionado == null) {
                mostrarError("Debe seleccionar un proveedor para eliminar");
                return;
            }

            int confirmacion = JOptionPane.showConfirmDialog(
                    objtVista,
                    "¿Está seguro que desea eliminar el proveedor: " + proveedorSeleccionado.getNombre() + "?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                objtDAO.eliminarProveedor(proveedorSeleccionado);

                mostrarMensaje("Proveedor eliminado exitosamente");
                limpiarCampos();
                llenarTabla(objtVista.tablaDatos);
                proveedorSeleccionado = null;
            }

        } catch (Exception ex) {
        }
    }

    private void migrarDatos() {
        try {
            ArrayList<Proveedor> proveedores = archivoProv.lecturaArchivo();

            if (proveedores.isEmpty()) {
                mostrarError("El archivo está vacío");
                return;
            }

            // Filtramos y aseguramos fechas válidas
            ArrayList<Proveedor> validos = new ArrayList<>();
            for (Proveedor p : proveedores) {
                if (p.getFechaNacimiento() == null) {
                    p.setFechaNacimiento(new Date()); // Asignamos fecha actual
                }
                validos.add(p);
            }

            objtDAO.insertarProveedores(validos);
            llenarTabla(objtVista.tablaDatos);
            mostrarMensaje(validos.size() + " proveedores migrados correctamente");
        } catch (Exception ex) {
        }
    }

    public void llenarTabla(JTable tablaDat) {
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaDat.setModel(modeloT);

        modeloT.addColumn("Nombre");
        modeloT.addColumn("País");
        modeloT.addColumn("Cédula");
        modeloT.addColumn("Fecha Nacimiento");

        ArrayList<Proveedor> proveedores = objtDAO.obtenerProveedores();
        for (Proveedor p : proveedores) {
            Object[] fila = {
                p.getNombre() != null ? p.getNombre() : "",
                p.getPais() != null ? p.getPais() : "",
                p.getCedula(),
                p.getFechaNacimiento() != null ? dateFormat.format(p.getFechaNacimiento()) : ""
            };
            modeloT.addRow(fila);
        }
    }

    private void cargarProveedorSeleccionado() {
        int filaSeleccionada = objtVista.tablaDatos.getSelectedRow();
        if (filaSeleccionada >= 0) {
            try {
                String nombre = objtVista.tablaDatos.getValueAt(filaSeleccionada, 0).toString();
                String pais = objtVista.tablaDatos.getValueAt(filaSeleccionada, 1).toString();
                String cedulaStr = objtVista.tablaDatos.getValueAt(filaSeleccionada, 2).toString();
                String fechaStr = objtVista.tablaDatos.getValueAt(filaSeleccionada, 3).toString();

                int cedula = Integer.parseInt(cedulaStr);
                Date fechaNacimiento = fechaStr.isEmpty() ? new Date() : dateFormat.parse(fechaStr);

                proveedorSeleccionado = new Proveedor(nombre, pais, cedula, fechaNacimiento);

                // Cargar datos en los campos
                objtVista.txtNombre.setText(nombre);
                objtVista.txtPaís.setText(pais);
                objtVista.txtCedula.setText(cedulaStr);
                objtVista.jCalendar1.setDate(fechaNacimiento);

            } catch (Exception ex) {
            }
        }
    }

    private void limpiarCampos() {
        objtVista.txtNombre.setText("");
        objtVista.txtPaís.setText("");
        objtVista.txtCedula.setText("");
        objtVista.jCalendar1.setDate(null);
    }

    private Date obtenerFechaValidada() {
        // Obtener fecha del calendario o usar fecha actual si es nula
        return objtVista.jCalendar1.getDate() != null
                ? objtVista.jCalendar1.getDate()
                : new Date();
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(objtVista, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(objtVista, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }
}
