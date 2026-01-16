package collections.queue;

import java.util.LinkedList;
import java.util.Queue;

public class FilaBanco {
    public static void main(String args[]){
        Queue<String> fila = new LinkedList<>();

        fila.offer("Cliente 1");
        fila.offer("Cliente 2");
        fila.offer("Cliente 3");
        fila.offer("Cliente 4");
        fila.offer("Cliente 5");


        System.out.println("\nFila de espera: " + fila);

        System.out.println("-> Atendendo: " + fila.poll());
        System.out.println("-> Atendendo: " + fila.poll());
        System.out.println("-> Atendendo: " + fila.poll());


        System.out.println("Ainda na fila: " + fila);
    }
}
