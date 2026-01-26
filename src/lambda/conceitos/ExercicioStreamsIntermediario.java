package lambda.conceitos;

import lambda.entities.*;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ExercicioStreamsIntermediario {
    public static void main(String[] args){

        List<Livro> livros = Arrays.asList(
                new Livro("Clean Code", "Robert Martin", 89.90, "Técnico", 464),
                new Livro("Java 8", "Oracle", 45.00, "Técnico", 320),
                new Livro("1984", "George Orwell", 30.00, "Ficção", 416),
                new Livro("O Hobbit", "Tolkien", 55.00, "Fantasia", 310),
                new Livro("Código Limpo", "Robert Martin", 95.00, "Técnico", 400),
                new Livro("O Senhor dos Anéis", "Tolkien", 120.00, "Fantasia", 1200)
        );

        List<Funcionario> funcionarios = Arrays.asList(
                new Funcionario("João Silva", "Gerente", 5000.00, 8),
                new Funcionario("Maria Santos", "Analista", 3500.00, 3),
                new Funcionario("Pedro Costa", "Diretor", 10000.00, 15),
                new Funcionario("Ana Oliveira", "Assistente", 2500.00, 1),
                new Funcionario("Carlos Souza", "Analista", 4000.00, 5)
        );


        System.out.println("1. Soma total dos preços:");
        double somaPrecos = livros.stream()
                .mapToDouble(Livro::getPreco)
                .sum();
        System.out.println("R$ " + somaPrecos);

        System.out.println();

        System.out.println("2. Preço médio:");
        OptionalDouble media = livros.stream()
                .mapToDouble(Livro::getPreco)
                .average();
        System.out.println("R$ " + media.getAsDouble());

        System.out.println();

        System.out.println("3. Livro mais caro:");
        Optional<Livro> maisCaro = livros.stream()
                .max(Comparator.comparing(Livro::getPreco));
        maisCaro.ifPresent(l -> System.out.println(l));

        System.out.println();

        System.out.println("4. Livro mais barato:");
        Optional<Livro> maisBarato = livros.stream()
                .min(Comparator.comparing(Livro::getPreco));
        maisBarato.ifPresent(System.out::println);

        System.out.println();

        System.out.println("5. Livros por categoria:");
        Map<String, List<Livro>> porCategoria = livros.stream()
                .collect(Collectors.groupingBy(Livro::getCategoria));
        porCategoria.forEach((cat, lista) -> {
            System.out.println(cat + ": " + lista.size() + " livro(s)");
        });

        System.out.println();

        System.out.println("6. Quantidade de livros por categoria:");
        Map<String, Long> quantidadePorCategoria = livros.stream()
                .collect(Collectors.groupingBy(Livro::getCategoria, Collectors.counting()));
        System.out.println(quantidadePorCategoria);

        System.out.println();

        System.out.println("7. Livros caros (>60) vs baratos:");
        Map<Boolean, List<Livro>> carosVsBaratos = livros.stream()
                .collect(Collectors.partitioningBy(l -> l.getPreco() > 60));
        System.out.println("Caros: " + carosVsBaratos.get(true).size());
        System.out.println("Baratos: " + carosVsBaratos.get(false).size());

        System.out.println();

        System.out.println("8. Folha de pagamento total:");
        double folhaPagamento = funcionarios.stream()
                .mapToDouble(Funcionario::getSalario)
                .sum();
        System.out.println("R$ " + folhaPagamento);

        System.out.println();

        System.out.println("9. Funcionários por cargo:");
        Map<String, List<Funcionario>> porCargo = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getCargo));
        porCargo.forEach((cargo, lista) -> {
            System.out.println(cargo + ": " + lista.size());
        });

        System.out.println();

        System.out.println("10. Todos ganham mais de R$ 2000?");
        boolean todosMais2k = funcionarios.stream().allMatch(f -> f.getSalario() > 2000);
        System.out.println(todosMais2k);
    }
}