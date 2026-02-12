package herencia;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Profesor profesor1 = new Profesor("George", "Maxi", 19, "george@gmail.com", 3333);
        Profesor profesor2 = new Profesor();
        profesor2.setNombre("Sheyla");
    }
}
