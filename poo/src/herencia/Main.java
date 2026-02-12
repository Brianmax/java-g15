package herencia;

public class Main {
    public static void main(String[] args) {
        Profesor profesor1 = new Profesor("George", "Maxi", 19, "george@gmail.com", 3333);
        Profesor profesor2 = new Profesor();
        Profesor profesor3 = new Profesor(9999);
        Alumno alumno = new Alumno("Juan", "Martinez", 33, "j@gmail.com", 14);
//        alumno.printInfo();
//        profesor1.printInfo();

        // Una variable de la superclase, puede almacenar la referencia a un objeto de la subclase
        Persona profesor = new Profesor("George", "Maxi", 19, "george@gmail.com", 3333);
        Persona alumno1 = new Alumno("Rafael", "David", 33, "rafa@gmail.com", 18);
//        Profesor profesor = new Persona(); X (incorrecto)

        profesor.printInfo();
        System.out.println("============================");
        alumno1.printInfo();



    }
}
