package loops;

import java.util.Random;

public class ArraysBidimensionales {
    public static void main(String[] args) {
        int[][] arrayBidimensional1 = new int[3][4];

        int[][] arrayBidimensional2 = {{1,4,5,2,3}, {23,5,1}, {93,24,54,3}};

        int tam1 = arrayBidimensional2.length;

//        for(int i = 0; i < tam1; i++) {
//            int tam2 = arrayBidimensional2[i].length;
//            for(int e = 0; e < tam2; e++) {
//                System.out.println(arrayBidimensional2[i][e]);
//            }
//            System.out.println();
//        }

        Random random = new Random();
        int num = random.nextInt(100);
        // popular de valores aleatorios el array bidimensional 1
        // {{12,42,43,2}, {23,132,32,2}, {923,995,23,1}} ==> array
        // imprimir de la siguiente forma
        // 12 42 43 2
        // 23 132 32 2
        // 923 995 23 1

        for (int i = 0; i < 3; i++) {
            for (int e = 0; e < 4; e++) {
                arrayBidimensional1[i][e] = random.nextInt(100);
            }
        }

        // imprimir

        for(int i = 0; i < 3; i++) {
            for(int e = 0; e < 4; e++) {
                System.out.print(arrayBidimensional1[i][e] + " ");
            }
            System.out.println();
        }
    }
}
