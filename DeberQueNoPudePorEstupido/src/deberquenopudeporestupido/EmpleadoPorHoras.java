package deberquenopudeporestupido;

public class EmpleadoPorHoras extends Empleado {

    private double sueldoPorHoras;
    private double horasTrabajadas;

    public EmpleadoPorHoras(double sueldoPorHoras, double horasTrabajadas, String numero_seguro_social, String nombre) {
        super(numero_seguro_social, nombre);
        this.sueldoPorHoras = sueldoPorHoras;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double ingresos() {
        if (horasTrabajadas <= 40) {
            return sueldoPorHoras * horasTrabajadas;
        } else if (horasTrabajadas >= 40) {
            return 40 * sueldoPorHoras + (horasTrabajadas - 40) * sueldoPorHoras * 1.5;
        }
        return 0;
    }

    public double getSueldoPorHoras() {
        return sueldoPorHoras;
    }

    public double getHorasTrabajadas() {
        return horasTrabajadas;
    }
    
    @Override
    public String toString() {
        return super.toString() + "EmpleadoPorHoras{" + "sueldoPorHoras=" + sueldoPorHoras + ", horasTrabajadas=" + horasTrabajadas + '}';
    }

}
