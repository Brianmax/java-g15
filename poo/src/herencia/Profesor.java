package herencia;

public class Profesor extends Persona {
    private double salario;

    public Profesor(String nombre, String apellido, int edad, String correo, double salario) {
        super(nombre, apellido, edad, correo);
        this.salario = salario;
    }

    public Profesor(double salario) {
        this.salario = salario;
    }

    public Profesor() {

    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public void printInfo() {
        System.out.println("Nombre Profesor: " + nombre);
        System.out.println("Apellido Profesor: " + apellido);
        System.out.println("Edad Profesor: " + edad);
        System.out.println("Correo Profesor: " + correo);
        System.out.println("Salario Profesor: " + salario);
    }

}
