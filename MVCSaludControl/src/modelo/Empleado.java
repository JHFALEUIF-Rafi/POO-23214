package modelo;

public class Empleado {
    private String nombre;
    private String provincia;
    private double peso;
    private double estatura;
    private int edad;

    public Empleado(String nombre, String provincia, double peso, double estatura, int edad) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.peso = peso;
        this.estatura = estatura;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}
