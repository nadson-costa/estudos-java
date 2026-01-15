package collections.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RemoverDuplicatas {
    public static void main(String args[]){
        ArrayList<String> nomes = new ArrayList<>();
        nomes.add("Nadson");
        nomes.add("Maria");
        nomes.add("José");
        nomes.add("Nadson");

        System.out.println("Lista de nomes: " + nomes);

        Set<String> nomesFormatados = new HashSet<>(nomes);

        System.out.println("Lista de nomes(duplicados removidos): " + nomesFormatados);
        System.out.println(nomesFormatados.size());


    }
}
