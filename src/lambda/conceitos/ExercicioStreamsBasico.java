package lambda.conceitos;

import lambda.entities.*;

import java.util.Comparator;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ExercicioStreamsBasico {
    public static void main(String[] args){

        List<Livro> livros = Arrays.asList(
                new Livro("Clean Code", "Robert Martin", 89.90, "Técnico", 464),
                new Livro("Java 8", "Oracle", 45.00, "Técnico", 320),
                new Livro("1984", "George Orwell", 30.00, "Ficção", 416),
                new Livro("O Hobbit", "Tolkien", 55.00, "Fantasia", 310),
                new Livro("Código Limpo", "Robert Martin", 95.00, "Técnico", 400)
        );

        System.out.println("=== EXERCÍCIOS STREAMS BÁSICO ===\n");

        System.out.println("1. Livros caros (> R$ 50):");
        livros.stream()
                .filter(l -> l.getPreco() > 50)
                .forEach(l -> System.out.println(l));

        System.out.println("\n=======================\n");


        System.out.println("2. Livros Técnicos:");
        livros.stream()
                .filter(l -> l.getCategoria().equals("Técnico"))
                .forEach(l -> System.out.println(l));


        System.out.println("\n=======================\n");


        System.out.println("3. Quantidade de livros grandes (> 400 páginas):");
        long quantidade = livros.stream()
                .filter(l -> l.getPaginas() > 400)
                .count();
        System.out.println(quantidade);

        System.out.println("\n=======================\n");


        System.out.println("4. Todos os títulos:");
        livros.stream()
                .map(l -> l.getTitulo())
                .forEach(titulo -> System.out.println(titulo));


        System.out.println("\n=======================\n");

        System.out.println("5. Todos os preços:");
        List<Double> precos = livros.stream()
                .map(l -> l.getPreco())
                .collect(Collectors.toList());
        System.out.println(precos);

        System.out.println("\n=======================\n");

        System.out.println("6. Títulos de Ficção:");
        livros.stream()
                .filter(l -> l.getCategoria().equalsIgnoreCase("Ficção"))
                .forEach(l -> System.out.println(l));
        System.out.println("\n=======================\n");


        System.out.println("7. Livros ordenados por preço:");
        livros.stream()
                .sorted(Comparator.comparing(Livro::getPreco))
                .forEach(l -> System.out.println(l));

        System.out.println("\n=======================\n");

        System.out.println("8. 3 livros mais baratos:");
        livros.stream()
                .sorted(Comparator.comparing(Livro::getPreco))
                .limit(3)
                .forEach(l -> System.out.println(l));
        System.out.println("\n=======================\n");


        System.out.println("9. Autores únicos:");
        livros.stream()
                .map(Livro::getAutor)
                .distinct()
                .forEach(autor -> System.out.println(autor));

        System.out.println("\n=======================\n");

        System.out.println("10. Existe livro de mais de R$ 100?");
        boolean existe = livros.stream()
                .anyMatch(l -> l.getPreco() > 100);
        System.out.println(existe);
    }
}