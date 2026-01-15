package collections.map;

import java.util.HashMap;

public class ContadorPalavras {
    public static void main(String args[]){
        String frase = "java python java javascript python java";
        HashMap<String, Integer> contadorPalavras = new HashMap<>();

        String[] palavras = frase.toLowerCase().split("\\s+");

        for(String palavra : palavras){
            palavra = palavra.replaceAll("[^a-zA-Z0-9]", "");;
            if(!palavra.isEmpty()){
                contadorPalavras.put(palavra, contadorPalavras.getOrDefault(palavra, 0) + 1);
            }
        }

        System.out.println("\nContagem de palavras:");
        for (HashMap.Entry<String, Integer> entry : contadorPalavras.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
