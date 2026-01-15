package collections.set;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetOrdenado {
    public static void main(String args[]){
        Set<Integer> numeros = new TreeSet<>();

        numeros.add(50);
        numeros.add(10);
        numeros.add(30);
        numeros.add(20);
        numeros.add(40);

        System.out.println("A: " + numeros);

        numeros.add(5);
        numeros.add(60);

        System.out.println("B: " + numeros);





    }

}
