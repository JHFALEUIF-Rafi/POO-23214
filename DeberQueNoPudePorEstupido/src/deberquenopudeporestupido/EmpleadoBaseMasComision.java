package deberquenopudeporestupido;

public class EmpleadoBaseMasComision extends EmpleadoPorComision{
    private double salarioBase;

    public EmpleadoBaseMasComision(double salarioBase, double ventasBrutas, double tarifaComision, String numero_seguro_social, String nombre) {
        super(ventasBrutas, tarifaComision, numero_seguro_social, nombre);
        this.salarioBase = salarioBase;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    @Override
    public String toString() {
        return super.toString() + "EmpleadoBaseMasComision{" + "salarioBase=" + salarioBase + '}';
    }
    
    
}
