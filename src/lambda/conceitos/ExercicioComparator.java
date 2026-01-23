package lambda.conceitos;

import lambda.entities.*;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ExercicioComparator {
    public static void main(String[] args){

        Comparator<Livro> porPreco = (l1, l2) -> Double.compare(l1.getPreco(), l2.getPreco());

        Comparator<Livro> porTitulo = (l1, l2) -> l1.getTitulo().compareTo(l2.getTitulo());

        Comparator<Livro> porPaginasDesc = (l1, l2) -> l2.getPaginas() - l1.getPaginas();

        Comparator<Funcionario> porSalarioDesc = (f1, f2) -> Double.compare(f2.getSalario(), f1.getSalario());

        Comparator<Funcionario> porTempoEmpresa = (f1, f2) -> f1.getAnosEmpresa() - f2.getAnosEmpresa();

        Comparator<Produto> porEstoque = (p1, p2) -> p1.getEstoque() - p2.getEstoque();


        System.out.println("=== TESTES COMPARATOR ===\n");

        List<Livro> livros = Arrays.asList(
                new Livro("Clean Code", "Robert Martin", 89.90, "Técnico", 464),
                new Livro("Java 8", "Oracle", 45.00, "Técnico", 320),
                new Livro("1984", "George Orwell", 30.00, "Ficção", 416),
                new Livro("O Hobbit", "Tolkien", 55.00, "Fantasia", 310)
        );

        System.out.println("=== Livros por Preço (crescente) ===");
        Collections.sort(livros, porPreco);
        livros.forEach(System.out::println);

        System.out.println();

        System.out.println("=== Livros por Título (alfabética) ===");
        Collections.sort(livros, porTitulo);
        livros.forEach(System.out::println);

        System.out.println();

        System.out.println("=== Livros por Páginas (decrescente) ===");
        Collections.sort(livros, porPaginasDesc);
        livros.forEach(System.out::println);

        System.out.println();

        List<Funcionario> funcionarios = Arrays.asList(
                new Funcionario("João Silva", "Gerente", 5000.00, 8),
                new Funcionario("Maria Santos", "Analista", 3500.00, 3),
                new Funcionario("Pedro Costa", "Diretor", 10000.00, 15),
                new Funcionario("Ana Oliveira", "Assistente", 2500.00, 1)
        );

        System.out.println("=== Funcionários por Salário (decrescente) ===");
        Collections.sort(funcionarios, porSalarioDesc);
        funcionarios.forEach(System.out::println);

        System.out.println();

        System.out.println("=== Funcionários por Tempo de Empresa (crescente) ===");
        Collections.sort(funcionarios, porTempoEmpresa);
        funcionarios.forEach(System.out::println);

        System.out.println();

        List<Produto> produtos = Arrays.asList(
                new Produto("Notebook", 3500.00, 5, true),
                new Produto("Mouse", 25.00, 0, false),
                new Produto("Teclado", 150.00, 10, true),
                new Produto("Monitor", 800.00, 2, false)
        );

        System.out.println("=== Produtos por Estoque (crescente) ===");
        Collections.sort(produtos, porEstoque);
        produtos.forEach(System.out::println);
    }
}