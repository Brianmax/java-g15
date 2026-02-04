package variables;

import java.util.Scanner;

public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de dolares");
        double dolares = sc.nextDouble();
        System.out.println("Ingrese el tipo de cambio");
        double tipoCambio = sc.nextDouble();
        double soles = dolares * tipoCambio;
        System.out.println("El valor es: " + soles);
    }
}
