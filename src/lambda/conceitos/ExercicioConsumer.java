package lambda.conceitos;

import lambda.entities.*;
import java.util.function.Consumer;

public class ExercicioConsumer {
    public static void main(String[] args){

        Consumer<Livro> imprimirLivro = l -> System.out.println("Livro: " + l.getTitulo());

        Consumer<Funcionario> imprimirFuncionario = f -> System.out.println("Funcionário: " + f.getNome() + " que trabalha como: " + f.getCargo());

        Consumer<String> imprimirMaiusculo = n -> System.out.println(n.toUpperCase());

        Consumer<Integer> imprimirParImpar = i -> {
            if(i % 2 == 0){
                System.out.println(i + " é par");
            }else{
                System.out.println(i + " é impar");
            }
        };

        Consumer<Produto> imprimirSePromocao = p -> {
            if(p.isPromocao()){
                System.out.println("PROMOÇÃO: " + p.getNome());
            }else{
                return;
            }
        };


        System.out.println("=== TESTES CONSUMER ===\n");

        Livro livro = new Livro("Clean Code", "Robert Martin", 89.90, "Técnico", 464);
        imprimirLivro.accept(livro);

        Funcionario func = new Funcionario("João Silva", "Gerente", 5000.00, 8);
        imprimirFuncionario.accept(func);

        imprimirMaiusculo.accept("java é incrível");

        imprimirParImpar.accept(10);
        imprimirParImpar.accept(7);

        Produto prod1 = new Produto("Notebook", 3500.00, 10, true);
        Produto prod2 = new Produto("Mouse", 25.00, 5, false);
        imprimirSePromocao.accept(prod1);
        imprimirSePromocao.accept(prod2);
    }
}