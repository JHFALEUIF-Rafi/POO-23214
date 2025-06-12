package figuraabstractaapp;

import static java.lang.Math.PI;

public class Circunferencia extends Figura{

    public Circunferencia(double lado) {
        super(lado);
    }

    @Override
    public double calcularArea() {
        return (lado*lado*PI)/2;
    }
    
}
