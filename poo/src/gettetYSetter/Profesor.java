package gettetYSetter;

public class Profesor {
    private String nombre;
    private String apellido;
    private int edad;
    private double salario;
    private double bono;
    private int aniosServicio;
    private String tipo;

    public Profesor(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Profesor() {
    }

    public Profesor(String apellido, String nombre, int edad, double salario, int aniosServicio, String tipo) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
        this.aniosServicio = aniosServicio;
        this.tipo = tipo;
    }

    // metodos getter

    String getNombre() { // retorna el valor del atributo nombre
        return nombre;
    }

    String getApellido() {
        return apellido;
    }

    int getEdad() {
        return edad;
    }

    double getSalario() {
        return salario;
    }

    double getBono() {
        return bono;
    }

    int getAniosServicio() {
        return aniosServicio;
    }

    public String getTipo() {
        return tipo;
    }

    // metodos setter

    void setNombre(String nombre) {
        this.nombre = nombre;
    }

    void setApellido(String apellido) {
        this.apellido = apellido;
    }

    void setEdad(int edadNueva) {
        this.edad = edadNueva;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setBono(double bono) {
        this.bono = bono;
    }

    public void setAniosServicio(int aniosServicio) {
        this.aniosServicio = aniosServicio;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double calcularBono() {
        double bonoCalculo = (salario * 12) / aniosServicio;
        if (tipo.equals("TIEMPO_COMPLETO")) {
            bonoCalculo += salario * 0.25 * aniosServicio;
        }
        return bonoCalculo;
    }
}
