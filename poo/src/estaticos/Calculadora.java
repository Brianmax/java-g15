package estaticos;

public class Calculadora {
    final static double PI = 3.141592653589793;

    static double suma(int a, int b) {
        return a + b;
    }

    static long factorial(int a) {
        long factorial = 1;
        for(int i = a; i >= 1; i--) {
            factorial = factorial * i;
        }
        return factorial;
    }
}
