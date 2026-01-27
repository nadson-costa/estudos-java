# Lambda Expressions e Streams API

> Programação funcional em Java com Lambda Expressions, Streams API, Optional e Collectors avançados

## Contexto

Módulo dedicado ao estudo e prática de **Programação Funcional** em Java 8+, abrangendo desde fundamentos de Lambda Expressions até operações avançadas com Streams, Collectors e Optional.

## Conceitos aplicados

### Lambda Expressions
- Sintaxe básica: `(parametros) -> expressão`
- Lambda com 0, 1 ou 2 parâmetros
- Lambda com bloco `{ }`
- Method References: `Classe::metodo`

### Interfaces Funcionais
- **Predicate<T>** - Recebe T, retorna boolean
- **Function<T,R>** - Recebe T, retorna R
- **Consumer<T>** - Recebe T, não retorna (void)
- **Supplier<T>** - Não recebe, retorna T
- **Comparator<T>** - Recebe 2 T, retorna int
- **BiFunction<T,U,R>** - Recebe 2 parâmetros, retorna R
- **BiPredicate<T,U>** - Recebe 2 parâmetros, retorna boolean

### Streams API
- Operações intermediárias (filter, map, sorted, distinct, limit)
- Operações terminais (forEach, collect, count, reduce)
- mapToDouble, mapToInt, mapToLong
- sum, average, max, min
- anyMatch, allMatch, noneMatch
- findFirst, findAny
- Stream aninhado (stream dentro de filter)

### Collectors Avançados
- `Collectors.toList()` - Coletar em lista
- `Collectors.toSet()` - Coletar em set
- `Collectors.groupingBy()` - Agrupar por chave
- `Collectors.counting()` - Contar elementos
- `Collectors.partitioningBy()` - Separar em 2 grupos (true/false)

### Optional
- `Optional<T>` - Wrapper para valores opcionais
- `OptionalDouble`, `OptionalInt`, `OptionalLong`
- `ifPresent()` - Executar se presente
- `orElse()` - Valor padrão
- `getAsDouble()` - Extrair valor

## Estrutura do módulo

```
lambda/
├── conceitos/
│   ├── ExercicioPredicate.java (7 lambdas)
│   ├── ExerciciosFunction.java (6 lambdas)
│   ├── ExercicioConsumer.java (5 lambdas)
│   ├── ExercicioSupplier.java (4 lambdas)
│   ├── ExercicioComparator.java (6 lambdas)
│   ├── ExercicioBiFunctions.java (8 lambdas)
│   ├── ExercicioStreamsBasico.java (10 operações)
│   └── ExercicioStreamsIntermediario.java (10 operações)
│
├── entities/
│   ├── Livro.java
│   ├── Funcionario.java
│   └── Produto.java
│
└── sistemaEcommerce/
    ├── entities/
    │   ├── Categoria.java (Enum)
    │   ├── Produto.java
    │   ├── Cliente.java
    │   └── Pedido.java
    └── application/
        └── Main.java (20 desafios)
```

## Exercícios de Lambda (36 lambdas)

### 1. Predicate (7 exercícios)
Filtros e verificações booleanas:
- Livro caro (preço > 50)
- Livro grande (páginas > 300)
- Categoria específica
- Salário alto (> 3000)
- Funcionário experiente (> 5 anos)
- Produto em promoção
- Produto sem estoque


---

### 2. Function (6 exercícios)
Transformações de dados:
- Extrair título do livro
- Extrair preço
- Nome em maiúsculas
- Salário com aumento (10%)
- Preço com desconto (20%)
- Tamanho de String


---

### 3. Consumer (5 exercícios)
Ações sem retorno:
- Imprimir livro
- Imprimir funcionário com cargo
- Imprimir em maiúsculas
- Imprimir se é par/ímpar
- Imprimir se em promoção

---

### 4. Supplier (4 exercícios)
Fornecedores de valores:
- Data/hora atual
- Número aleatório (1-100)
- Mensagem de boas-vindas
- Lista vazia



---

### 5. Comparator (6 exercícios)
Ordenação customizada:
- Livros por preço (crescente)
- Livros por título (alfabética)
- Livros por páginas (decrescente)
- Funcionários por salário (decrescente)
- Funcionários por tempo de empresa
- Produtos por estoque


---

### 6. BiFunction e BiPredicate (8 exercícios)
Funções com 2 parâmetros:
- Somar números
- Multiplicar números
- Concatenar Strings
- Nome completo (nome + sobrenome)
- Potência (Math.pow)
- Verificar maior que
- Verificar igualdade (ignoreCase)
- Verificar se soma é par


---

## Exercícios de Streams

### Streams Básico (10 operações)

**Operações praticadas:**
1. **filter** - Livros caros (> R$ 50)
2. **filter + forEach** - Livros técnicos
3. **filter + count** - Livros grandes (> 400 páginas)
4. **map + forEach** - Extrair títulos
5. **map + collect** - Coletar preços em lista
6. **filter + map** - Títulos de ficção
7. **sorted + forEach** - Ordenar por preço
8. **sorted + limit** - Top 3 mais baratos
9. **map + distinct** - Autores únicos
10. **anyMatch** - Existe livro > R$ 100?


**Conceitos:**
- Pipeline de operações
- Method reference: `Livro::getPreco`
- Comparator.comparing()
- Collectors.toList()

---

### Streams Intermediário (10 operações)

**Operações avançadas:**
1. **reduce** - Soma de preços
2. **average** - Preço médio (OptionalDouble)
3. **max** - Livro mais caro (Optional)
4. **min** - Livro mais barato
5. **groupingBy** - Livros por categoria
6. **groupingBy + counting** - Quantidade por categoria
7. **partitioningBy** - Caros (>60) vs baratos
8. **mapToDouble + sum** - Folha de pagamento
9. **groupingBy** - Funcionários por cargo
10. **allMatch** - Todos ganham > R$ 2000?


**Conceitos:**
- mapToDouble para agregação
- OptionalDouble para médias
- groupingBy para agregação
- partitioningBy para separação binária

---

## Projeto final: Sistema E-commerce

Sistema completo de e-commerce com **20 desafios** usando apenas Streams

### Arquitetura

**4 classes:**
- `Categoria` (Enum) - 5 categorias
- `Produto` - nome, preço, categoria, estoque
- `Cliente` - nome, idade, cidade
- `Pedido` - cliente, produtos, data, getValorTotal()

**Dados de teste:**
- 5 Clientes
- 10 Produtos (3 eletrônicos, 2 livros, 2 roupas, 2 alimentos, 1 esporte)
- 6 Pedidos

---

### Desafios sobre Produtos

**1. Estoque baixo (<30)**
```java
produtos.stream()
    .filter(p -> p.getEstoque() < 30)
    .forEach(System.out::println);
```

**2. Top 3 mais caros**
```java
produtos.stream()
    .sorted(Comparator.comparing(Produto::getPreco).reversed())
    .limit(3)
    .forEach(System.out::println);
```

**3. Quantidade por categoria**
```java
Map<Categoria, Long> qtd = produtos.stream()
    .collect(Collectors.groupingBy(Produto::getCategoria, Collectors.counting()));
```

**4. Preço médio**
```java
OptionalDouble media = produtos.stream()
    .mapToDouble(Produto::getPreco)
    .average();
```

**5. Valor total em estoque (preço x estoque)**
```java
double total = produtos.stream()
    .mapToDouble(p -> p.getPreco() * p.getEstoque())
    .sum();
```

**6-10:** Verificações (anyMatch, allMatch), categorias únicas, particionamento, nomes

---

### Desafios sobre Clientes 

**11. Clientes de São Paulo**
```java
clientes.stream()
    .filter(c -> c.getCidade().equalsIgnoreCase("São Paulo"))
    .forEach(System.out::println);
```

**12. Cliente mais jovem**
```java
Optional<Cliente> maisJovem = clientes.stream()
    .min(Comparator.comparing(Cliente::getIdade));
```

**13. Clientes por cidade**
```java
Map<String, Long> porCidade = clientes.stream()
    .collect(Collectors.groupingBy(Cliente::getCidade, Collectors.counting()));
```

**14. Idade média**
```java
double media = clientes.stream()
    .mapToDouble(Cliente::getIdade)
    .average()
    .getAsDouble();
```

**15. Cidades únicas**
```java
clientes.stream()
    .map(Cliente::getCidade)
    .distinct()
    .forEach(System.out::println);
```

---

### Desafios sobre Pedidos

**16. Total de vendas**
```java
double totalVendas = pedidos.stream()
    .mapToDouble(Pedido::getValorTotal)
    .sum();
```

**17. Pedido mais caro**
```java
Optional<Pedido> maisCaro = pedidos.stream()
    .max(Comparator.comparing(Pedido::getValorTotal));
```

**18. Pedidos por cliente (relacionamento)**
```java
Map<String, Long> porCliente = pedidos.stream()
    .collect(Collectors.groupingBy(
        ped -> ped.getCliente().getNome(),
        Collectors.counting()
    ));
```

**19. Pedidos de Janeiro/2026**
```java
pedidos.stream()
    .filter(ped -> ped.getData().getYear() == 2026 && 
                   ped.getData().getMonthValue() == 1)
    .forEach(System.out::println);
```

**20. Produtos vendidos (Stream aninhado)**
```java
produtos.stream()
    .filter(p -> pedidos.stream()
        .anyMatch(ped -> ped.getProdutos().contains(p)))
    .forEach(System.out::println);
```
---

## Estatísticas do módulo

```
Exercícios:
   - 36 Lambdas criados
   - 10 Operações básicas de Stream
   - 10 Operações intermediárias de Stream
   - 20 Desafios do projeto final
   
Total: 76 exercícios de programação funcional

Classes criadas:
   - 7 classes de entidades
   - 14 arquivos de exercícios
   - 1 projeto final completo

Complexidade:
   - O(1) para operações diretas
   - O(n) para filter, map, forEach
   - O(n log n) para sorted
   - O(n²) para stream aninhado (desafio 20)
```

