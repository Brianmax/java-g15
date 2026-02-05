package loops;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el valor de n");
        int n = sc.nextInt();
        int[] array = new int[n];

        for(int i = 0; i < n; i++) {
            System.out.println("Ingresa el valor para la posicion [" + i + "]");
            array[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(array));
        for(int i = n - 1; i >= 0; i--) {
            System.out.println(array[i]);
        }
    }
}
