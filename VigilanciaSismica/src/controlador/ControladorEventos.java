package controlador;

import java.awt.BorderLayout;
import java.util.Random;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class ControladorEventos {

    public static void graficarMagnitudSismica(JPanel panel) {
        panel.removeAll(); 
        panel.setLayout(new BorderLayout());

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Random rand = new Random();

      
        for (int i = 1; i <= 10; i++) {
            double duracion = 10 + rand.nextDouble() * 30; // entre 10 y 40 segundos
            double amplitud = 1 + rand.nextDouble() * 100; // entre 1 y 100 mm
            double factor = -1 + rand.nextDouble() * 2;    // entre -1 y 1

            // Calcular magnitud (fórmula simplificada)
            double magnitud = Math.log10(amplitud) + 3 * Math.log10(8 * duracion) - 2.92 + factor;
            magnitud = Math.round(magnitud * 100.0) / 100.0;

            dataset.addValue(magnitud, "Magnitud", "Evento " + i);
        }

        JFreeChart chart = ChartFactory.createBarChart(
            "Magnitud Sísmica por Evento",
            "Evento",
            "Magnitud",
            dataset
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel, BorderLayout.CENTER);
        panel.validate();
    }
    
    public static void graficarIndiceVolcanico(JPanel panel) {
        panel.removeAll();
        panel.setLayout(new BorderLayout());

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Random rand = new Random();

        for (int i = 1; i <= 10; i++) {
            double alturaColumna = 1 + rand.nextDouble() * 20;     // Altura entre 1 y 21 km
            double volumen = 1e6 + rand.nextDouble() * 1e9;         // Volumen entre 10^6 y 10^9 m³
            double duracion = 0.5 + rand.nextDouble() * 5;          // Duración entre 0.5 y 5 h

        // Calcular VEI estimado
            double vei = Math.log10(volumen) - 7;
            vei = Math.round(vei * 100.0) / 100.0;

            dataset.addValue(vei, "VEI", "Evento " + i);
        }

        JFreeChart chart = ChartFactory.createBarChart(
            "Índice de Explosividad Volcánica (VEI)",
            "Evento",
            "VEI",
            dataset
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel, BorderLayout.CENTER);
        panel.validate();
    }

}


