package collections.set;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class VerificarPresenca {
    public static void main(String args[]){
        Set<String> nomes = new HashSet<>();
        Scanner sc = new Scanner(System.in);


        nomes.add("Nadson");
        nomes.add("Maria");
        nomes.add("José");
        nomes.add("Isaac");
        nomes.add("Jacó");

        String x;

        System.out.println("Digite um nome: ");
        x = sc.nextLine();

        if(nomes.contains(x)){
            System.out.println("Nome encontrado na lista!");
        } else{
            System.out.println("Nome não encontrado!");
        }
    }
}
