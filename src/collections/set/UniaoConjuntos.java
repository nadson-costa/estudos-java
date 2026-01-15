package collections.set;

import java.util.HashSet;
import java.util.Set;

public class UniaoConjuntos {
    public static void main(String args[]){
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        setA.add(1);
        setA.add(2);
        setA.add(3);
        setA.add(4);

        setB.add(3);
        setB.add(4);
        setB.add(5);
        setB.add(6);

        System.out.println("A: " + setA);
        System.out.println("B: " + setB);

        setA.addAll(setB);

        System.out.println("A + B: " + setA);






    }
}
