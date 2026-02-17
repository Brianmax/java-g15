package clasesGenericas;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Tupla tupla = new Tupla(12,32);
        Tupla2 tupla2 = new Tupla2("George", 213);


        TuplaGenerica<Integer, Integer> tuplaGenerica1 = new TuplaGenerica<>(2, 12);
        TuplaGenerica<String, String> tuplaGenerica2  = new TuplaGenerica<>("George", "Maxi");
        TuplaGenerica<String, Integer> tuplaGenerica3 = new TuplaGenerica<>("Jose", 123);

    }
}
