package loops;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ArrayListTeoria {
    public static void main( String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        ArrayList<Integer> numeros = new ArrayList<>();
        System.out.println("Ingrese el valor de n");
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            numeros.add(random.nextInt(0,100)); // agregamos un elemento al array con add
        }
        System.out.println("=============Array Inicial===================");
        System.out.println(numeros);

        System.out.println("Ingrese la cantidad de elementos que desea eliminar");
        int r = sc.nextInt();
        for(int i = 0; i < r; i++) {
            int indice = random.nextInt(0, numeros.size()-1);
            numeros.remove(indice); // eliminamos un elemento del array usando un indice
        }
        System.out.println("=============Array Final===================");
        System.out.println(numeros);

        // ejemplo: Obtener la posicion 1 de un arrayList
        numeros.get(1333); // array[1]
    }
}
