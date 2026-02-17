package ejercicio7.clases;

import ejercicio7.interfaces.Estudiante;
import ejercicio7.interfaces.Profesor;

import java.util.ArrayList;

public class EstudianteProfesor extends Persona implements Estudiante, Profesor {
    private ArrayList<String> cursosMatriculados;
    private ArrayList<String> cursosImpartidos;

    public EstudianteProfesor(String nombre, ArrayList<String> cursosMatriculados, ArrayList<String> cursosImpartidos) {
        super(nombre);
        this.cursosMatriculados = cursosMatriculados;
        this.cursosImpartidos = cursosImpartidos;
    }

    // estudiante
    @Override
    public void matricularCurso() {

    }

    @Override
    public void entregarTarea() {

    }

    // profesor
    @Override
    public void calificarExamen() {

    }

    @Override
    public void asignarTarea() {

    }

    // usuario
    @Override
    public void iniciarSesion() {

    }

    @Override
    public void cerrarSesion() {

    }
}
