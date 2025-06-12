
package enfermomultipleapp;

public class EnfermoMultipleApp {

    public static void main(String[] args) {
        Empleado e1 = new Empleado(123, "Solanda", "Tilin", 14);
        e1.hablar();
        e1.tomarTemperatura();
        e1.tomarMedicamentos();
    }
    
}
