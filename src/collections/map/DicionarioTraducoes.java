package collections.map;

import java.util.HashMap;
import java.util.Scanner;

public class DicionarioTraducoes {
    public static void main(String args[]){
        HashMap<String, String> traducoes =  new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String x;

        traducoes.put("Olá", "Hello");
        traducoes.put("Mundo", "World");
        traducoes.put("Java", "Java");

        System.out.println("Digite uma palavra: ");
        x = sc.nextLine();

        if(traducoes.containsKey(x)){
            System.out.println("Tradução: " + traducoes.get(x));
        }else{
            System.out.println("Tradução não encontrada!");
        }






    }
}
