package deber1p2parte2;

public class EmpleadoConHorasDobles extends Empleado{
    private int horasExtras;

    public EmpleadoConHorasDobles(int horasTrabajadas, double sueldoPorHora, int horasExtras) {
        super(horasTrabajadas, sueldoPorHora);
        this.horasExtras = horasExtras;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }

    @Override
    public double CalcularSalario() {
        return (horasTrabajadas * sueldoPorHora) + (horasExtras * sueldoPorHora * 2);
    }
}