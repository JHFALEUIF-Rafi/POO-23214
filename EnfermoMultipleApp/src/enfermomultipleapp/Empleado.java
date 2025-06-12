
package enfermomultipleapp;

public class Empleado extends Persona implements Enfermo {
    private float sueldo;
    private String direccion;

    public Empleado(float sueldo, String direccion, String nombre, int edad) {
        super(nombre, edad);
        this.sueldo = sueldo;
        this.direccion = direccion;
    }
    
    @Override
    public void hablar() {
        System.out.println("Hablar");
    }

    @Override
    public void tomarTemperatura() {
        System.out.println("Alta Temperatura");
    }

    @Override
    public void tomarMedicamentos() {
        System.out.println("Paracetamol");
    }
    
}
