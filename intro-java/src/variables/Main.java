package variables;

public class Main {
    public static void main(String[] args) {
        // Numéricos
        byte a = 127;          // 8 bits
        int age = 29;          // 32 bits
        float salario = 1599.99f;
        double precio = 129.999;

        // Carácter y texto
        char sexo = 'M';
        String nombre = "George";

        // Booleanos
        boolean activo = true;

        // Operadores: + - * / %
        int num1 = 10, num2 = 3;
        System.out.println(num1 + num2);  // 13
        System.out.println(10 % 3);       // 1 (residuo)

        // División: el resultado depende de los tipos
        // Si ambos son enteros, el resultado es entero (se trunca)
        System.out.println(10 / 3);       // 3 (int/int = int, pierde decimales)
        System.out.println(10 / 4);       // 2 (no redondea, trunca)

        // Si al menos uno es decimal, el resultado es decimal
        System.out.println(10.0 / 3);     // 3.333... (double/int = double)
        System.out.println(10 / 3.0);     // 3.333... (int/double = double)
        System.out.println(10.0f / 3);    // 3.333... (float/int = float)

        // Truco: convertir a decimal para obtener resultado exacto
        int a1 = 10, b1 = 3;
        System.out.println((double) a1 / b1);  // 3.333... (casting)
    }
}
