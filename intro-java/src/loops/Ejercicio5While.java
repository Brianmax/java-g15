package loops;

public class Ejercicio5While {
    public static void main(String[] args) {
        int a = 1;
        while(a <= 100) {
            if(a % 3 != 0) {
                System.out.println(a);
            }
            a++;
        }
    }
}
