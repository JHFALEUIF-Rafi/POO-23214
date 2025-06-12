package figuraabstractaapp;

public class Triangulo extends Figura {

    private double altura;

    public Triangulo(double altura, double lado) {
        super(lado);
        this.altura = altura;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public double calcularArea() {
        return (lado * altura) / 2;
    }

}
