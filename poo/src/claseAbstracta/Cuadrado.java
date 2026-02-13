package claseAbstracta;

import herencia.Main;

public class Cuadrado extends Figura {
    private double lado;

    public Cuadrado(String color, double lado) {
        super(color);
        this.lado = lado;
    }

    @Override
    public double area() {
        return Math.pow(lado, 2);
    }
}
