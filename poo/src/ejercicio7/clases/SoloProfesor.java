package ejercicio7.clases;

import ejercicio7.interfaces.Profesor;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class SoloProfesor extends Persona implements Profesor {
    private ArrayList<String> cursosImpartidos;

    public SoloProfesor(String nombre, ArrayList<String> cursosImpartidos) {
        super(nombre);
        this.cursosImpartidos = cursosImpartidos;
    }

    @Override
    public void iniciarSesion() {
        System.out.println("Iniciando sesion... ");
    }

    @Override
    public void cerrarSesion() {
        System.out.println("Cerrando Sesion .... ");
    }

    @Override
    public void calificarExamen() {
        System.out.println("Calificando examen. ... ");
    }

    @Override
    public void asignarTarea() {
        System.out.println("Asignando tarea ... ");
    }
}
