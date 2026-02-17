package interfaces;

public class Auto implements Vehiculo{
    @Override
    public void acelerar() {
        System.out.println("Acelerando desde un auto...");
    }

    @Override
    public void frenar() {
        System.out.println("Frenando desde un auto...");
    }
}
