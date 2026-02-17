package estaticos;

public class Main {
    public static void main(String[] args) {
        long factorialCalculado = Calculadora.factorial(5);
        System.out.println(factorialCalculado);
        double areaCirculo = Calculadora.PI * Math.pow(10,2);


        // USUARIO

        Usuario usuario1 = new Usuario("george1wew", "kjdkjdkj");
        Usuario usuario2 = new Usuario("jose1212", "kjdkjdkj");

        System.out.println(Usuario.numeroUsuarios);
        System.out.println(usuario1.numeroUsuarios);
        System.out.println(usuario2.numeroUsuarios);
    }
}
