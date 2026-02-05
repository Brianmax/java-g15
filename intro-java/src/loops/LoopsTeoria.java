package loops;

public class LoopsTeoria {
    public static void main(String[] args) {
        // imprime los numeros del 1 al 10
        // for
        for(int i = 1; i < 11; i++) {
            System.out.println(i);
        }
        System.out.println("//////////////////////////////");
        for(int i = 10; i > 0; i--) {
            System.out.println(i);
        }
        System.out.println("//////////////////////////////");

        for(int i = 0; i <= 10; i = i + 2) {
            System.out.println(i);
        }
        System.out.println("/////////////// WHILE /////////////////");
        int a = 0;
        while (a <= 10) {
            System.out.println(a);
            a++;
        }

//        int a = 10;
//        a = 25;
//        a = a + 10;
//        a+=10;
    }
}
