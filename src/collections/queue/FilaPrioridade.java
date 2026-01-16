package collections.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class FilaPrioridade {
    public static void main(String args[]){
        Queue<Integer> prioridade = new PriorityQueue<>();

        prioridade.offer(50);
        prioridade.offer(10);
        prioridade.offer(30);
        prioridade.offer(20);
        prioridade.offer(40);

        System.out.println("\nFila: " + prioridade);

        while(!prioridade.isEmpty()){
            System.out.println("-> Atendendo: " + prioridade.poll());
        }
        System.out.println("Fila vazia!");


    }
}
