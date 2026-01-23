package lambda.conceitos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Supplier;

public class ExercicioSupplier {
    public static void main(String[] args){

        Supplier<LocalDateTime> dataHoraAtual = () -> LocalDateTime.now();

        Supplier<Integer> numeroAleatorio = () -> (int)(Math.random() * 100) + 1;

        Supplier<String> mensagemBoasVindas = () -> "Bem-vindo";

        Supplier<List<String>> listaVazia = () -> new ArrayList<>();


        System.out.println("=== TESTES SUPPLIER ===\n");
        DateTimeFormatter formatarDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println("Data/Hora atual: " + dataHoraAtual.get().format(formatarDataHora));

        System.out.println("\nNúmeros aleatórios:");
        for(int i = 0; i < 5; i++){
            System.out.println(numeroAleatorio.get());
        }

        System.out.println("\n" + mensagemBoasVindas.get());

        List<String> lista = listaVazia.get();
        System.out.println("\nLista criada: " + lista);
        System.out.println("Tamanho: " + lista.size());
        lista.add("Java");
        lista.add("Lambda");
        System.out.println("Depois de adicionar: " + lista);
    }
}