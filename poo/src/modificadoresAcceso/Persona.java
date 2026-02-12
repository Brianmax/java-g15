package modificadoresAcceso;

public class Persona {
//    public String nombre; // Accesible en todo el proyecto
    private String nombre; // accesible solo en la clase Persona
    int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre; // funciona ya que estamos llamandolo dentro de la misma clase
        this.edad = edad;
    }

    public Persona() {
    }
}
