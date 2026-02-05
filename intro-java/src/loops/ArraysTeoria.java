package loops;

import java.util.ArrayList;

public class ArraysTeoria {
    public static void main(String[] args) {
        int[] numeros = {4,1,5,2,6}; // crear array con elementos
        int[] numeros2 = new int[5]; // crear array sin elementos

//        System.out.println(numeros[3]);
//        System.out.println(numeros[0]);
        int tam = numeros.length;
        for(int i = 0; i < tam; i++) {
            System.out.println(numeros[i] * 3);
        }
    }
}
