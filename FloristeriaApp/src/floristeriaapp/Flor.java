
package floristeriaapp;
public class Flor {
    private String nombreFlor;
    private String procedencia;
    private double precio;

    public Flor(String nombreFlor, String procedencia, double precio) {
        this.nombreFlor = nombreFlor;
        this.procedencia = procedencia;
        this.precio = precio;
    }

    public String getNombreFlor() {
        return nombreFlor;
    }

    public void setNombreFlor(String nombreFlor) {
        this.nombreFlor = nombreFlor;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public void mostrarDatos(){
        System.out.println("Nombre de la flor: " + nombreFlor);
        System.out.println("Lugar de procedencia: " + procedencia);
        System.out.println("Precio: " + precio);
    }
}
