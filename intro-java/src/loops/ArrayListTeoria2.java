package loops;

import com.sun.source.tree.ArrayAccessTree;

import java.util.*;

public class ArrayListTeoria2 {
    public static void main(String[] args) {
        ArrayList<Integer> array1 = new ArrayList<>();
//        List<Integer> array2 = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        array1.add(10);
        linkedList.add(10);
        // for each
        for(int i = 0; i < array1.size(); i++) { // lectura y escritura
            System.out.println(array1.get(i));
            array1.set(i,10);
        }
        for(int elemento: array1) { // solo para lectura
            System.out.println(elemento);
        }
    }
}
