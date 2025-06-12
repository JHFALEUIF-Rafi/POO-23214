package deberquenopudeporestupido;

public abstract class Empleado {
    protected String numero_seguro_social;
    protected String nombre;

    public Empleado(String numero_seguro_social, String nombre) {
        this.numero_seguro_social = numero_seguro_social;
        this.nombre = nombre;
    }
    
    public abstract double ingresos();

    @Override
    public String toString() {
        return "Empleado{" + "numero_seguro_social=" + numero_seguro_social + ", nombre=" + nombre + '}';
    }
}
