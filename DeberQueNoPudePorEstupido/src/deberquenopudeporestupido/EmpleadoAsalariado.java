package deberquenopudeporestupido;

public class EmpleadoAsalariado extends Empleado {

    private double salarioSemanal;

    public EmpleadoAsalariado(double salarioSemanal, String numero_seguro_social, String nombre) {
        super(numero_seguro_social, nombre);
        this.salarioSemanal = salarioSemanal;
    }

    public double getSalarioSemanal() {
        return salarioSemanal;
    }

    @Override
    public double ingresos() {
        return salarioSemanal;
    }
}
