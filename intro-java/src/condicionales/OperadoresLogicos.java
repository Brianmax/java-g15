package condicionales;

public class OperadoresLogicos {
    public static void main(String[] args) {
        // Lógicos: && (and), || (or), ! (not)
        System.out.println(true && false);  // false
        System.out.println(true || false);  // true
        System.out.println(!true);          // false

        // Comparación: < > <= >= == !=
        System.out.println(10 < 20);   // true
        System.out.println(10 <= 10);  // true
        System.out.println(10 == 10);  // true
        System.out.println(10 != 5);   // true
    }
}
