package loops;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el valor de n");
        int n = sc.nextInt();
        int[] array = new int[n];


        // generar numero aleatorio
        int num = random.nextInt(10, 100);
    }
}
