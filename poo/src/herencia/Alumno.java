package herencia;

public class Alumno extends Persona {
    private double ponderado;

    public Alumno(String nombre, String apellido, int edad, String correo, double ponderado) {
        super(nombre, apellido, edad, correo);
        this.ponderado = ponderado;
    }

    public Alumno(double ponderado) {
        this.ponderado = ponderado;
    }

    public Alumno() {}

    public double getPonderado() {
        return ponderado;
    }

    public void setPonderado(double ponderado) {
        this.ponderado = ponderado;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Ponderado: " + ponderado);
    }
}
