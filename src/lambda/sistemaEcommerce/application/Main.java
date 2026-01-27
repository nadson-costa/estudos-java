package lambda.sistemaEcommerce.application;

import lambda.sistemaEcommerce.entities.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){

        Cliente c1 = new Cliente("João Silva", 25, "São Paulo");
        Cliente c2 = new Cliente("Maria Santos", 32, "Rio de Janeiro");
        Cliente c3 = new Cliente("Pedro Costa", 45, "São Paulo");
        Cliente c4 = new Cliente("Ana Oliveira", 28, "Belo Horizonte");
        Cliente c5 = new Cliente("Carlos Souza", 35, "São Paulo");

        List<Cliente> clientes = Arrays.asList(c1, c2, c3, c4, c5);


        Produto p1 = new Produto("Notebook Dell", 3500.00, Categoria.ELETRONICOS, 10);
        Produto p2 = new Produto("Mouse Logitech", 80.00, Categoria.ELETRONICOS, 50);
        Produto p3 = new Produto("Clean Code", 89.90, Categoria.LIVROS, 30);
        Produto p4 = new Produto("Camiseta Nike", 120.00, Categoria.ROUPAS, 100);
        Produto p5 = new Produto("Tênis Adidas", 350.00, Categoria.ROUPAS, 25);
        Produto p6 = new Produto("Arroz 5kg", 25.00, Categoria.ALIMENTOS, 200);
        Produto p7 = new Produto("Bola de Futebol", 80.00, Categoria.ESPORTES, 40);
        Produto p8 = new Produto("Java 8 Prático", 75.00, Categoria.LIVROS, 20);
        Produto p9 = new Produto("Smartphone Samsung", 2000.00, Categoria.ELETRONICOS, 15);
        Produto p10 = new Produto("Feijão 1kg", 8.00, Categoria.ALIMENTOS, 300);

        List<Produto> produtos = Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);


        Pedido ped1 = new Pedido(c1, Arrays.asList(p1, p2, p3), LocalDate.of(2026, 1, 15));
        Pedido ped2 = new Pedido(c2, Arrays.asList(p4, p5), LocalDate.of(2026, 1, 16));
        Pedido ped3 = new Pedido(c3, Arrays.asList(p6, p10), LocalDate.of(2026, 1, 17));
        Pedido ped4 = new Pedido(c1, Arrays.asList(p9), LocalDate.of(2026, 1, 18));
        Pedido ped5 = new Pedido(c4, Arrays.asList(p3, p8), LocalDate.of(2026, 1, 19));
        Pedido ped6 = new Pedido(c5, Arrays.asList(p1, p4, p7), LocalDate.of(2026, 1, 20));

        List<Pedido> pedidos = Arrays.asList(ped1, ped2, ped3, ped4, ped5, ped6);



        System.out.println("=== PROJETO E-COMMERCE ===\n");

        System.out.println("1. Produtos com estoque baixo(<30)");
        produtos.stream()
                .filter(p -> p.getEstoque() < 30)
                .forEach(p -> System.out.println(p));
        System.out.println();

        System.out.println("2. Top 3 produtos mais caros");
        produtos.stream()
                .sorted(Comparator.comparing(Produto::getPreco).reversed())
                .limit(3)
                .forEach(p -> System.out.println(p));
        System.out.println();

        System.out.println("3. Quantidade de produtos por categoria");
        Map<Categoria, Long> quantidadePorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria, Collectors.counting()));
        quantidadePorCategoria.forEach((cat, qtd) ->
                System.out.println(cat.getDescricao() + ": " + qtd));
        System.out.println();

        System.out.println("4. Preço médio dos produtos");
        System.out.println("R$ " + produtos.stream()
                .mapToDouble(Produto::getPreco)
                .average()
                .getAsDouble());
        System.out.println();

        System.out.println("5. Valor total em estoque (preço x estoque)");
        double valorTotal = produtos.stream()
                .mapToDouble(p -> p.getPreco() * p.getEstoque())
                .sum();
        System.out.println("R$ " + valorTotal);
        System.out.println();

        System.out.println("6. Existe algum produto sem estoque?");
        boolean semEstoque = produtos.stream()
                .anyMatch(p -> p.getEstoque() == 0);
        System.out.println(semEstoque);
        System.out.println();

        System.out.println("7. Todos os produtos custam menos de R$ 5000?");
        boolean todosMenos5k = produtos.stream()
                .allMatch(p -> p.getPreco() < 5000.0);
        System.out.println(todosMenos5k);
        System.out.println();

        System.out.println("8. Categorias únicas que têm produtos");
        produtos.stream()
                .map(Produto::getCategoria)
                .distinct()
                .forEach(c -> System.out.println(c.getDescricao()));
        System.out.println();

        System.out.println("9. Produtos caros (>100) X produtos baratos (<100)");
        Map<Boolean, List<Produto>> carosVsBaratos = produtos.stream()
                .collect(Collectors.partitioningBy(p -> p.getPreco() > 100));
        System.out.println("Produtos caros: " + carosVsBaratos.get(true).size());
        System.out.println("Produtos baratos " + carosVsBaratos.get(false).size());
        System.out.println();

        System.out.println("10. Todos os nomes dos produtos");
        produtos.stream()
                .map(Produto::getNome)
                .forEach(nome -> System.out.println(nome));

        System.out.println("\n======================\n");

        System.out.println("11. Clientes de São Paulo");
        clientes.stream()
                .filter(c -> c.getCidade().equalsIgnoreCase("São Paulo"))
                .forEach(c -> System.out.println(c));
        System.out.println();

        System.out.println("12. Cliente mais jovem");
        Optional<Cliente> maisJovem = clientes.stream()
                .min(Comparator.comparing(Cliente::getIdade));
        maisJovem.ifPresent(System.out::println);
        System.out.println();

        System.out.println("13. Clientes por cidade");
        Map<String, Long> clientesPorCidade = clientes.stream()
                .collect(Collectors.groupingBy(Cliente::getCidade, Collectors.counting()));
        clientesPorCidade.forEach((cidade, qtd) -> {
            System.out.println(cidade + ": " + qtd);
        });
        System.out.println();

        System.out.println("14. Idade média dos clientes");
        System.out.println("-> Idade média: " + clientes.stream()
                .mapToDouble(Cliente::getIdade)
                .average()
                .getAsDouble());
        System.out.println();

        System.out.println("15. Cidades únicas");
        clientes.stream()
                .map(Cliente::getCidade)
                .distinct()
                .forEach(cidade -> System.out.println(cidade));

        System.out.println("\n======================\n");

        System.out.println("16. Total de vendas");
        System.out.println("-> Total: R$ " + pedidos.stream()
                .mapToDouble(Pedido::getValorTotal)
                .sum()
        );
        System.out.println();

        System.out.println("17. Pedido mais caro");
        Optional<Pedido> pedidoMaisCaro = pedidos.stream()
                .max(Comparator.comparing(Pedido::getValorTotal));
        pedidoMaisCaro.ifPresent(System.out::println);
        System.out.println();

        System.out.println("18. Pedidos por cliente");
        Map<String, Long> pedidosPorCliente = pedidos.stream()
                .collect(Collectors.groupingBy(ped -> ped.getCliente().getNome(), Collectors.counting()));
        pedidosPorCliente.forEach((cliente, qtd) -> {
            System.out.println(cliente + ": " + qtd);
        });
        System.out.println();

        System.out.println("19. Pedidos de Janeiro/2026");
        pedidos.stream()
                .filter(ped -> ped.getData().getYear() == 2026 &&
                        ped.getData().getMonthValue() == 1)
                .forEach(ped -> System.out.println(ped));
        System.out.println();

        System.out.println("20. Produtos que foram vendidos");
        produtos.stream()
                .filter(p -> pedidos.stream()
                        .anyMatch(ped -> ped.getProdutos().contains(p)))
                .forEach(System.out::println);

    }
}