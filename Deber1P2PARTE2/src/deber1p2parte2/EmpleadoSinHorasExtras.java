package deber1p2parte2;

public class EmpleadoSinHorasExtras extends Empleado {

    public EmpleadoSinHorasExtras(int horasTrabajadas, double sueldoPorHora) {
        super(horasTrabajadas, sueldoPorHora);
    }

    @Override
    public double CalcularSalario() {
        return horasTrabajadas * sueldoPorHora;
    }
}
