package deber1p2parte2;

public class GestorDeber1P2PARTE2 {

    public static void main(String[] args) {

        EmpleadoSinHorasExtras empleadoNormal = new EmpleadoSinHorasExtras(40, 10.0);
        EmpleadoConHorasDobles empleadoDoble = new EmpleadoConHorasDobles(40, 10.0, 3); 
        EmpleadoConHorasTriples empleadoTriple = new EmpleadoConHorasTriples(40, 10.0, 6); 

        System.out.println("Salario normal (40h): $" + empleadoNormal.CalcularSalario());
        System.out.println("Salario con 3h dobles (43h): $" + empleadoDoble.CalcularSalario());
        System.out.println("Salario con 6h triples (46h): $" + empleadoTriple.CalcularSalario());
    }

}
