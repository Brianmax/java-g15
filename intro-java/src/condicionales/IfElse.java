package condicionales;

import java.util.Scanner;

public class IfElse {
    public static void main(String[] args) {
        // ingrese la edad de una persona
        // imprima mayor de edad si la persona tiene de 18 anios a mas
        // imprima menor de edad si la persona tiene menos de 18 anios
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la edad");
        int edad = sc.nextInt();
        if (edad >= 18) {
            System.out.println("Mayor de edad");
        } else {
            System.out.println("Menor de edad");
        }
    }
}
