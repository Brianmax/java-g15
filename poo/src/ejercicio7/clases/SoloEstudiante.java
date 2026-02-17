package ejercicio7.clases;

import ejercicio7.interfaces.Estudiante;

import java.util.ArrayList;

public class SoloEstudiante extends Persona implements Estudiante {
    private ArrayList<String> cursosMatriculados;

    public SoloEstudiante(String nombre, ArrayList<String> cursosMatriculados) {
        super(nombre);
        this.cursosMatriculados = cursosMatriculados;
    }

    @Override
    public void matricularCurso() {
        System.out.println("Matriculandose a curso .... ");
    }

    @Override
    public void entregarTarea() {
        System.out.println("Entregando Tarea ... ");
    }

    @Override
    public void iniciarSesion() {
        System.out.println("Iniciando sesion ...");
    }

    @Override
    public void cerrarSesion() {
        System.out.println("Cerrando sesion ... ");
    }
}
