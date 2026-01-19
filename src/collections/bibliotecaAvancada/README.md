# Sistema de Biblioteca Avançada

> **Projeto de estudo**: Sistema completo de gerenciamento de biblioteca desenvolvido para dominar **Collections Avançadas** (Set, Map, Queue) em Java

## Projeto

Sistema robusto de biblioteca com gerenciamento de livros, usuários, empréstimos e **fila de espera inteligente**. Desenvolvido como projeto prático para consolidar o uso avançado de estruturas de dados em Java.

## Conceitos aplicados

### Collections avançadas
- **HashSet** - Garantir livros únicos (sem duplicatas por ISBN)
- **HashMap (ISBN -> Livro)** - Busca rápida O(1)
- **HashMap (Categoria -> Set<Livro>)** - Índice múltiplo por categoria
- **HashMap (ISBN -> Queue<Usuario>)** - Filas de espera por livro
- **LinkedList como Queue** - FIFO para fila de espera

### Conceitos POO
- Encapsulamento adequado
- equals() e hashCode() personalizados
- Separação de responsabilidades
- Classes bem definidas (Livro, Usuario, Biblioteca)

### Arquitetura
- Organização em camadas (entities, services, application)
- Single Responsibility Principle
- Código limpo e manutenível

## Estrutura

```
bibliotecaAvancada/
├── entities/
│   ├── Livro.java
│   └── Usuario.java
├── services/
│   └── Biblioteca.java
└── application/
    └── Main.java
```

## Classe Livro

### Atributos:
- `isbn` (String) - Identificador único
- `titulo` (String)
- `autor` (String)
- `categoria` (String)
- `disponivel` (boolean)

### Métodos principais:
- `emprestar()` - Marca livro como indisponível
- `devolver()` - Marca livro como disponível
- `exibirInfo()` - Mostra informações completas
- `equals()` e `hashCode()` - Baseados no ISBN (essencial para Set/Map!)



## Classe Usuario

### Atributos:
- `cpf` (String) - Identificador único
- `nome` (String)

### Métodos:
- `exibirInfo()`
- `equals()` e `hashCode()` - Baseados no CPF

## Classe Biblioteca (Service)

### Estruturas de Dados:

```java
// 1. Set para garantir livros únicos
private Set<Livro> livros = new HashSet<>();

// 2. Map para busca rápida por ISBN (O(1))
private Map<String, Livro> livrosPorISBN = new HashMap<>();

// 3. Map para organizar por categoria (índice múltiplo)
private Map<String, Set<Livro>> livrosPorCategoria = new HashMap<>();

// 4. Map para gerenciar filas de espera por livro
private Map<String, Queue<Usuario>> filaEspera = new HashMap<>();
```

### Explicação da estrutura

**1. Set<Livro> livros:**
- Armazena todos os livros
- Evita duplicatas automaticamente (mesmo ISBN)
- Usa equals/hashCode para comparar

**2. Map<String, Livro> livrosPorISBN:**
- Chave: ISBN (String)
- Valor: Livro
- Busca O(1) - Instantânea!
- Alternativa seria percorrer Set (O(n)) - muito lento!

**3. Map<String, Set<Livro>> livrosPorCategoria:**
- Chave: Categoria (String)
- Valor: Set de Livros dessa categoria
- Índice múltiplo - Um livro pode estar em uma categoria
- Permite listar todos de uma categoria rapidamente


**4. Map<String, Queue<Usuario>> filaEspera:**
- Chave: ISBN do livro (String)
- Valor: Fila (Queue) de usuários esperando por AQUELE livro
- FIFO - Primeiro que entra, primeiro que pega
- Cada livro pode ter sua própria fila



### Métodos da Biblioteca:

#### **1. adicionarLivro(Livro livro)**
```java
// O que faz:
1. Adiciona ao Set (evita duplicatas)
2. Adiciona ao Map de ISBN (busca rápida)
3. Adiciona ao Map de categoria (organização)

// Complexidade: O(1)
```

#### **2. buscarPorISBN(String isbn)**
```java
// Busca direta no Map
return livrosPorISBN.get(isbn);

// Complexidade: O(1)
```

#### **3. buscarPorCategoria(String categoria)**
```java
// Retorna Set de livros da categoria
return livrosPorCategoria.getOrDefault(categoria, new HashSet<>());

// Complexidade: O(1) para buscar + O(n) para retornar Set
```

#### **4. emprestarLivro(String isbn, Usuario usuario)**
```java
// Lógica:
1. Buscar livro por ISBN
2. Se não existe → erro
3. Se indisponível → adicionar usuário na FILA
4. Se disponível → emprestar!

// Sistema de Fila:
Queue<Usuario> fila = filaEspera.get(isbn);
if(fila == null){
    fila = new LinkedList<>();
    filaEspera.put(isbn, fila);
}
fila.offer(usuario); // Adiciona no fim da fila
```

#### **5. devolverLivro(String isbn)**  **(Mais importante!)**
```java
// Lógica:
1. Buscar livro
2. Devolver (disponivel = true)
3. Verificar se tem FILA DE ESPERA
4. Se tem fila:
   - Pegar próximo (poll)
   - Emprestar AUTOMATICAMENTE para ele!
   - Livro fica indisponível novamente
5. Se não tem fila:
   - Livro fica disponível

// Código:
Queue<Usuario> fila = filaEspera.get(isbn);
if(fila != null && !fila.isEmpty()){
    Usuario proximo = fila.poll(); // Remove primeiro da fila
    livro.emprestar(); // Empresta para ele
    System.out.println("Emprestado para " + proximo.getNome());
}
```


#### **6-9. Métodos de listagem**
- `listarTodos()` - Percorre Set
- `listarDisponiveis()` - Filtra por `isDisponivel()`
- `listarPorCategoria()` - Usa Map de categorias
- `mostrarFilaEspera()` - Mostra Queue com posições

## Menu interativo (10 funcionalidades)

```
=== SISTEMA BIBLIOTECA ===
1 - Adicionar livro
2 - Busca por ISBN
3 - Busca por categoria
4 - Emprestar livro
5 - Devolver livro
6 - Listar todos os livros
7 - Listar livros disponíveis
8 - Listar por categoria
9 - Mostrar fila de espera
10 - Sair
========================
```



## Complexidade das operações

| Operação | Complexidade | Estrutura Usada |
|----------|--------------|-----------------|
| Adicionar livro | O(1) | HashSet + HashMap |
| Buscar por ISBN | O(1) | HashMap |
| Buscar por categoria | O(1) + O(k) | HashMap (k = livros na categoria) |
| Emprestar | O(1) | HashMap |
| Devolver | O(1) | HashMap + Queue |
| Listar todos | O(n) | HashSet |
| Adicionar na fila | O(1) | Queue (LinkedList) |
| Remover da fila | O(1) | Queue.poll() |



## Diferenciais do projeto

### 1. Sistema de fila inteligente
- Empréstimo automático ao devolver
- FIFO (justo para todos)
- Múltiplas filas (uma por livro)

### 2. Múltiplos índices
- Por ISBN (busca única)
- Por categoria (busca múltipla)
- Disponibilidade (filtro)

### 3. Estruturas combinadas
- Map + Set (índice de categorias)
- Map + Queue (filas por livro)
- Set principal (sem duplicatas)

### 4. equals/hashCode personalizados
- Livro comparado por ISBN
- Usuario comparado por CPF
- Essencial para Set/Map funcionar

