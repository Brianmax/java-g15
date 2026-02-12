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
}
