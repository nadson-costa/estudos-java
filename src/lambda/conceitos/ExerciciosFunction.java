package lambda.conceitos;

import lambda.entities.*;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.function.Function;

public class ExerciciosFunction {
    public static void main(String args[]){
        Function<Livro, String> obterTitulo = l -> l.getTitulo();
        Function<Livro, Double> obterPreco = l -> l.getPreco();
        Function<Funcionario, String> nomeEmMaiusculas = f -> f.getNome().toUpperCase();
        Function<Funcionario, Double> salarioComAumento = f -> (f.getSalario() + (f.getSalario() * 0.10));
        Function<Produto, Double> precoComDesconto = p -> (p.getPreco() - (p.getPreco() * 0.20));
        Function<String, Integer> tamanhoNome = n -> n.length();

        Livro l = new Livro("Clean Code", "Robert Martin", 89.90, "Técnico", 464);
        Funcionario f = new Funcionario("Nadson Costa", "Tech Lead", 10000, 2);
        Produto p = new Produto("Tênis Olympikus Corre 4", 499.9, 2, false);

        Locale ptBr = new Locale("pt", "BR");
        NumberFormat nf = NumberFormat.getCurrencyInstance(ptBr);

        System.out.println("=== Livro ===");
        String titulo = obterTitulo.apply(l);
        Double preco = obterPreco.apply(l);
        System.out.println(titulo);
        System.out.println(nf.format(preco));

        System.out.println("\n=== Funcionário ===");
        String nomeMaiusculo = nomeEmMaiusculas.apply(f);
        double salarioAumento = salarioComAumento.apply(f);
        System.out.println(nomeMaiusculo);
        System.out.println(nf.format(salarioAumento));

        System.out.println("\n=== Produto ===");
        double precoDesconto = precoComDesconto.apply(p);
        System.out.println(nf.format(precoDesconto));

        System.out.println("\n=== String ===");
        System.out.println(tamanhoNome.apply("nome"));


    }
}
