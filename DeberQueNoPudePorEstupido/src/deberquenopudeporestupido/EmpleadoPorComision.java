package deberquenopudeporestupido;

public class EmpleadoPorComision extends Empleado {

    private double ventasBrutas;
    private double tarifaComision;

    public EmpleadoPorComision(double ventasBrutas, double tarifaComision, String numero_seguro_social, String nombre) {
        super(numero_seguro_social, nombre);
        this.ventasBrutas = ventasBrutas;
        this.tarifaComision = tarifaComision;
    }

    @Override
    public double ingresos() {
        return tarifaComision * ventasBrutas;
    }

    public double getVentasBrutas() {
        return ventasBrutas;
    }

    public double getTarifaComision() {
        return tarifaComision;
    }

    @Override
    public String toString() {
        return super.toString() + "EmpleadoPorComision{" + "ventasBrutas=" + ventasBrutas + ", tarifaComision=" + tarifaComision + '}';
    }    
}
