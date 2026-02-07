package loops;

import java.util.Scanner;

public class Ejercicio12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String texto = "Java es un lenguaje de programacion   ";
        char[] textoChar = {'J', 'a', 'v', 'a', ' ', 'e', 's', ' '};
        System.out.println("Ingrese la palabra a evaluar");
        System.out.println(texto.charAt(2));
        char letra = texto.charAt(2);

        String sub = texto.substring(11, 15);
        System.out.println(sub);
        System.out.println(texto.toUpperCase());
        System.out.println(texto.toLowerCase());
        System.out.println(texto.trim());
        System.out.println(texto.contains("lenguae"));
    }
}
