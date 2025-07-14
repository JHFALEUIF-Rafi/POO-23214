package modelo;

public class CalcularSismo {

    // Constante de corrección (ajústala según tus necesidades)
    private static final double FACTOR_CORRECCION = 0.2; // Ejemplo: valor típico para ajuste local

    // Método para calcular magnitud según fórmula del PDF (página 6)
    public double calcularMagnitud(double duracion, double amplitud) {
        return Math.log10(duracion) + 0.5 * Math.log10(amplitud) + FACTOR_CORRECCION;
    }

    // Método adicional para validar alertas (página 6 - Flujo Normal, paso 4)
    public String verificarAlerta(double magnitud) {
        if (magnitud >= 6.0) {
            return "ALERTA PREVENTIVA: Magnitud crítica (" + magnitud + ")";
        } else {
            return "Magnitud dentro de rango normal (" + magnitud + ")";
        }
    }
}
