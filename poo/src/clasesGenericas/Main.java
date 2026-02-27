package clasesGenericas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
//        Tupla tupla = new Tupla(12,32);
//        Tupla2 tupla2 = new Tupla2("George", 213);


//        TuplaGenerica<Integer, Integer> tuplaGenerica1 = new TuplaGenerica<>(2, 12);
//        TuplaGenerica<String, String> tuplaGenerica2  = new TuplaGenerica<>("George", "Maxi");
//        TuplaGenerica<String, Integer> tuplaGenerica3 = new TuplaGenerica<>("Jose", 123);

        ListaGenerica<Integer> listaGenerica1 = new ListaGenerica<>();
        // ListaGenerica<Producto> ===> almacena productos
        listaGenerica1.agregarElemento(10);
        listaGenerica1.agregarElemento(29);
        listaGenerica1.agregarElemento(29);
        listaGenerica1.agregarElemento(29);
        listaGenerica1.agregarElemento(29);
        listaGenerica1.agregarElemento(390);
        // new Persona("Jorge) // 020320
        // new Persona("Jorge) // 9239023
        System.out.println(listaGenerica1);

    }
}
