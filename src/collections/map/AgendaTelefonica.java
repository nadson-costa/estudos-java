package collections.map;

import java.util.HashMap;
import java.util.Scanner;

public class AgendaTelefonica {
    public static void main(String args[]){
        HashMap<String, String> agenda = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String nome;

        agenda.put("Nadson", "82 99999-9999");
        agenda.put("Maria", "82 88888-8888");
        agenda.put("João", "82 77777-7777");

        System.out.println("Digite o nome de um contato: ");
        nome = sc.nextLine();

        if(agenda.containsKey(nome)){
            System.out.println(agenda.get(nome));
        } else{
            System.out.println("Contato não encontrado!");
        }




    }
}
