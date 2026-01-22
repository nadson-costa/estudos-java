package lambda.conceitos;


import lambda.entities.Funcionario;
import lambda.entities.Livro;
import lambda.entities.Produto;

import java.util.function.Predicate;

public class ExercicioPredicate {
    public static void main(String args[]){
        Predicate<Livro> livroCaro = l -> l.getPreco() > 50.0;
        Predicate<Livro> livroGrande = l -> l.getPaginas() > 300;
        Predicate<Livro> ficcao = l -> l.getCategoria().equalsIgnoreCase("Ficção");
        Predicate<Funcionario> salarioAlto = f -> f.getSalario() > 3000.0;
        Predicate<Funcionario> experiente = f -> f.getAnosEmpresa() > 5;
        Predicate<Produto> emPromocao = p -> p.isPromocao();
        Predicate<Produto> semEstoque = p -> p.getEstoque() <= 0;

        Livro l = new Livro("Clean Code", "Robert Martin", 89.90, "Técnico", 464);
        Funcionario f = new Funcionario("Nadson Costa", "Tech Lead", 10000, 2);
        Produto p = new Produto("Tênis Olympikus Corre 4", 499.9, 2, false);

        System.out.println("=== Livro ===");
        System.out.println(livroCaro.test(l));
        System.out.println(livroGrande.test(l));
        System.out.println(ficcao.test(l));

        System.out.println("\n=== Funcionário ===");
        System.out.println(salarioAlto.test(f));
        System.out.println(experiente.test(f));

        System.out.println("\n=== Produto ===");
        System.out.println(emPromocao.test(p));
        System.out.println(semEstoque.test(p));
    }
}
