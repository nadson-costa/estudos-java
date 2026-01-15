package collections.map;

import java.util.HashMap;

public class NotasAlunos {
    public static void main(String args[]){
        HashMap<String, Double> notas = new HashMap<>();
        double somaNotas = 0;


        notas.put("João", 8.0);
        notas.put("Maria", 9.0);
        notas.put("Pedro", 6.0);
        notas.put("Ana", 7.0);
        notas.put("Carlos", 9.5);

        for(double nota : notas.values()){
            somaNotas = somaNotas + nota;
        }

        if(!notas.isEmpty()){
            double media = somaNotas / notas.size();
            System.out.println("Média geral: " + media);
            for(String nome : notas.keySet()){
                double nota = notas.get(nome);
                if(nota > media){
                    System.out.println("Acima da média: " + nome);
                }
            }

        }




    }
}
