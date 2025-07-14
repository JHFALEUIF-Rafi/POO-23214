package controlador;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import modelo.Empleado;
import modelo.EmpleadoDAO;
import vista.FrmEmpleado;

public class ControladorEmpleado implements ActionListener {

    private FrmEmpleado vista;
    private EmpleadoDAO modeloDAO;
    private ArrayList<Empleado> empleados;

    public ControladorEmpleado(FrmEmpleado vista) {
        this.vista = vista;
        this.modeloDAO = new EmpleadoDAO();
        this.empleados = new ArrayList<>();

        cargarProvincias();
        cargarEmpleados();
        configurarEventos();
    }

    private void cargarProvincias() {
        String[] provincias = {"Azuay", "Bolívar", "Cañar", "Carchi", "Chimborazo",
            "Cotopaxi", "El Oro", "Esmeraldas", "Galápagos",
            "Guayas", "Imbabura", "Loja", "Los Ríos", "Manabí",
            "Morona Santiago", "Napo", "Orellana", "Pastaza",
            "Pichincha", "Santa Elena", "Santo Domingo",
            "Sucumbíos", "Tungurahua", "Zamora Chinchipe"};

        // Limpiar los combobox antes de agregar items
        vista.cbProvincia.removeAllItems();
        vista.cbFiltrar.removeAllItems();

        // Agregar todas las provincias
        for (String provincia : provincias) {
            vista.cbProvincia.addItem(provincia);
            vista.cbFiltrar.addItem(provincia);
        }

        // Agregar la opción "Todos" solo al combobox de filtro
        vista.cbFiltrar.addItem("Todos");
    }

    private void cargarEmpleados() {
        empleados = modeloDAO.obtenerEmpleados();
        actualizarTabla(empleados);
    }

    private void actualizarTabla(ArrayList<Empleado> listaEmpleados) {
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hace que la tabla no sea editable
            }
        };

        modelo.addColumn("Nombre");
        modelo.addColumn("Provincia");
        modelo.addColumn("Peso (kg)");
        modelo.addColumn("Estatura (m)");
        modelo.addColumn("Edad");
        modelo.addColumn("IMC");
        modelo.addColumn("Estado");

        for (Empleado emp : listaEmpleados) {
            double imc = calcularIMC(emp.getPeso(), emp.getEstatura());
            String estado = determinarEstadoIMC(imc);

            modelo.addRow(new Object[]{
                emp.getNombre(),
                emp.getProvincia(),
                String.format("%.2f", emp.getPeso()),
                String.format("%.2f", emp.getEstatura()),
                emp.getEdad(), // Mostrar edad como entero sin formato decimal
                String.format("%.2f", imc),
                estado
            });
        }

        vista.jtEmpleado.setModel(modelo);
    }

    private double calcularIMC(double peso, double estatura) {
        if (estatura == 0) {
            return 0;
        }
        return peso / (estatura * estatura);
    }

    private String determinarEstadoIMC(double imc) {
        if (imc < 17) {
            return "Muy bajo peso";
        }
        if (imc >= 17 && imc < 18.5) {
            return "Bajo peso";
        }
        if (imc >= 18.5 && imc < 25) {
            return "Peso normal";
        }
        if (imc >= 25 && imc < 30) {
            return "Sobrepeso";
        }
        if (imc >= 30 && imc < 35) {
            return "Obesidad grado I";
        }
        return "Obesidad grado II o superior";
    }

    private void configurarEventos() {
        vista.btnAgregar.addActionListener(this);
        vista.btnActualizar.addActionListener(this);
        vista.cbFiltrar.addActionListener(this);
        vista.btnMigrar.addActionListener(e -> migrarDatosTXT());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnAgregar) {
            agregarEmpleado();
        } else if (e.getSource() == vista.btnActualizar) {
            actualizarEstadisticas();
        } else if (e.getSource() == vista.cbFiltrar) {
            filtrarPorProvincia();
        } else if (e.getSource() == vista.btnMigrar) {
            migrarDatosExcel(); // Nueva función
        }
    }

    private void agregarEmpleado() {
        try {
            String nombre = vista.txtNombre.getText().trim();
            String provincia = vista.cbProvincia.getSelectedItem().toString();
            double peso = Double.parseDouble(vista.txtPeso.getText());
            double estatura = Double.parseDouble(vista.txtEstatura.getText());
            int edad = Integer.parseInt(vista.txtEdad.getText());

            if (nombre.isEmpty() || peso <= 0 || estatura <= 0) {
                JOptionPane.showMessageDialog(vista,
                        "Ingrese datos válidos:\n- Nombre no puede estar vacío\n- Peso y estatura deben ser mayores a 0",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Empleado nuevo = new Empleado(nombre, provincia, peso, estatura, edad);  // Actualizado
            modeloDAO.insertarEmpleado(nuevo);
            cargarEmpleados();

            // Limpiar campos
            vista.txtNombre.setText("");
            vista.txtPeso.setText("");
            vista.txtEstatura.setText("");
            vista.txtEdad.setText("");

            JOptionPane.showMessageDialog(vista, "Empleado agregado exitosamente");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista,
                    "Ingrese valores numéricos válidos para peso, estatura y edad",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarEstadisticas() {
        cargarEmpleados();
        mostrarEstadisticas();
    }

    private void mostrarEstadisticas() {
        int muyBajoPeso = 0, bajoPeso = 0, normal = 0, sobrepeso = 0, obesidadI = 0, obesidadII = 0;

        for (Empleado emp : empleados) {
            double imc = calcularIMC(emp.getPeso(), emp.getEstatura());
            if (imc < 17) {
                muyBajoPeso++;
            } else if (imc >= 17 && imc < 18.5) {
                bajoPeso++;
            } else if (imc >= 18.5 && imc < 25) {
                normal++;
            } else if (imc >= 25 && imc < 30) {
                sobrepeso++;
            } else if (imc >= 30 && imc < 35) {
                obesidadI++;
            } else {
                obesidadII++;
            }
        }

        String estadisticas = "ESTADÍSTICAS DE IMC\n\n"
                + "Muy bajo peso (<17): " + muyBajoPeso + "\n"
                + "Bajo peso (17-18.49): " + bajoPeso + "\n"
                + "Peso normal (18.5-24.99): " + normal + "\n"
                + "Sobrepeso (25-29.99): " + sobrepeso + "\n"
                + "Obesidad grado I (30-34.99): " + obesidadI + "\n"
                + "Obesidad grado II o superior (≥35): " + obesidadII + "\n\n"
                + "PROVINCIA CON MÁS BAJO PESO:\n" + provinciaConMasBajoPeso();

        JOptionPane.showMessageDialog(vista, estadisticas, "Estadísticas de Salud", JOptionPane.INFORMATION_MESSAGE);
    }

    private String provinciaConMasBajoPeso() {
        ArrayList<String> provincias = new ArrayList<>();
        ArrayList<Integer> contadores = new ArrayList<>();

        for (Empleado emp : empleados) {
            double imc = calcularIMC(emp.getPeso(), emp.getEstatura());
            if (imc >= 17 && imc < 18.5) {
                String provincia = emp.getProvincia();
                int index = provincias.indexOf(provincia);

                if (index == -1) {
                    provincias.add(provincia);
                    contadores.add(1);
                } else {
                    contadores.set(index, contadores.get(index) + 1);
                }
            }
        }

        if (provincias.isEmpty()) {
            return "No hay empleados con bajo peso registrados";
        }

        int maxIndex = 0;
        for (int i = 1; i < contadores.size(); i++) {
            if (contadores.get(i) > contadores.get(maxIndex)) {
                maxIndex = i;
            }
        }

        return provincias.get(maxIndex) + " (" + contadores.get(maxIndex) + " empleados)";
    }

    private void filtrarPorProvincia() {
        String provinciaSeleccionada = vista.cbFiltrar.getSelectedItem().toString();

        if (provinciaSeleccionada.equals("Todos")) {
            actualizarTabla(empleados);
            return;
        }

        ArrayList<Empleado> filtrados = new ArrayList<>();
        for (Empleado emp : empleados) {
            if (emp.getProvincia().equals(provinciaSeleccionada)) {
                filtrados.add(emp);
            }
        }

        actualizarTabla(filtrados);

        // Mostrar reporte de sobrepeso y obesidad para la provincia seleccionada
        mostrarReporteProvincia(provinciaSeleccionada);
    }

    private void mostrarReporteProvincia(String provincia) {
        ArrayList<Empleado> conProblemas = new ArrayList<>();

        for (Empleado emp : empleados) {
            if (emp.getProvincia().equals(provincia)) {
                double imc = calcularIMC(emp.getPeso(), emp.getEstatura());
                if (imc >= 25) { // Sobrepeso u obesidad
                    conProblemas.add(emp);
                }
            }
        }

        if (conProblemas.isEmpty()) {
            JOptionPane.showMessageDialog(vista,
                    "No hay empleados con sobrepeso u obesidad en " + provincia,
                    "Reporte de Salud", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder reporte = new StringBuilder();
        reporte.append("EMPLEADOS CON SOBREPESO/OBESIDAD EN ").append(provincia.toUpperCase()).append("\n\n");

        for (Empleado emp : conProblemas) {
            double imc = calcularIMC(emp.getPeso(), emp.getEstatura());
            reporte.append("• ").append(emp.getNombre())
                    .append(" - IMC: ").append(String.format("%.2f", imc))
                    .append(" (").append(determinarEstadoIMC(imc)).append(")\n");
        }

        JOptionPane.showMessageDialog(vista, reporte.toString(), "Reporte de Salud", JOptionPane.WARNING_MESSAGE);
    }

    public void migrarDatosTXT() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar archivo TXT");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de texto", "txt"));

        int result = fileChooser.showOpenDialog(vista);
        if (result != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File archivoTXT = fileChooser.getSelectedFile();
        System.out.println("Archivo seleccionado: " + archivoTXT.getAbsolutePath());

        try (BufferedReader br = new BufferedReader(new FileReader(archivoTXT))) {
            int registrosInsertados = 0;
            int registrosConError = 0;
            String linea;

            while ((linea = br.readLine()) != null) {
                try {
                    // Parsear la línea
                    String[] partes = linea.split("\\|");

                    // Validar estructura
                    if (partes.length != 5) {
                        System.err.println("Formato incorrecto en línea: " + linea);
                        registrosConError++;
                        continue;
                    }

                    // Extraer valores
                    String nombre = partes[0].split(":")[1].trim();
                    String provincia = partes[1].split(":")[1].trim();
                    double peso = Double.parseDouble(partes[2].split(":")[1].trim());
                    double estatura = Double.parseDouble(partes[3].split(":")[1].trim());
                    int edad = Integer.parseInt(partes[4].split(":")[1].trim());

                    // Validar datos
                    if (nombre.isEmpty() || provincia.isEmpty() || peso <= 0 || estatura <= 0 || edad <= 0) {
                        throw new Exception("Datos inválidos");
                    }

                    // Insertar en MongoDB
                    Empleado nuevo = new Empleado(nombre, provincia, peso, estatura, edad);
                    if (modeloDAO.insertarEmpleado(nuevo)) {
                        registrosInsertados++;
                        System.out.println("Insertado: " + nuevo.getNombre());
                    } else {
                        registrosConError++;
                    }

                } catch (Exception e) {
                    registrosConError++;
                    System.err.println("Error en línea: " + linea + " - " + e.getMessage());
                }
            }

            // Mostrar resultados en el EDT
            SwingUtilities.invokeLater(() -> {
                cargarEmpleados(); // Actualizar tabla

                String mensaje = String.format(
                        "Resultado de migración:\n"
                        + "Registros insertados: %d\n"
                        + "Registros con errores: %d\n"
                        + "Total procesado: %d",
                        registrosInsertados,
                        registrosConError,
                        (registrosInsertados + registrosConError)
                );

                JOptionPane.showMessageDialog(
                        vista,
                        mensaje,
                        "Proceso completado",
                        JOptionPane.INFORMATION_MESSAGE
                );
            });

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    vista,
                    "Error al leer el archivo: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            e.printStackTrace();
        }
    }
}
