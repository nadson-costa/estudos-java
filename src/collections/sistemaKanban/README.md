# Sistema de Gerenciamento de Tarefas (Kanban)

> **Projeto de estudo:** - Sistema completo de gerenciamento de tarefas estilo Kanban/Trello desenvolvido para dominar **Collections Avançadas**, **Enums**, **Comparators** e **TreeSet/PriorityQueue** em Java

## Projeto

Sistema profissional de gerenciamento de tarefas com suporte a prioridades, deadlines, categorias, atribuição de usuários e ordenação automática. Implementa conceitos avançados de estruturas de dados e programação orientada a objetos.

## Conceitos aplicados

### Collections avançadas
- **HashSet** - Garantir tarefas únicas (sem duplicatas por ID)
- **HashMap (ID -> Tarefa)** - Busca ultrarrápida O(1)
- **HashMap (Categoria -> Set<Tarefa>)** - Índice múltiplo por categoria
- **HashMap (Status -> Set<Tarefa>)** - Índice por status (TODO, DOING, DONE)
- **HashMap (Usuario -> Set<Tarefa>)** - Índice por responsável
- **PriorityQueue com Comparator** - Fila ordenada por prioridade (ALTA primeiro)
- **TreeSet com Comparator** - Ordenação automática por deadline

### Conceitos Java avançados
- **Enum** - Status (TODO, DOING, DONE) e Prioridade (ALTA, MEDIA, BAIXA)
- **Comparator Customizado** - Ordenação por prioridade e deadline
- **LocalDate** - Gerenciamento de datas (deadline)
- **LocalDateTime** - Timestamp de criação
- **equals() e hashCode()** - Comparação por ID e CPF

### Conceitos POO
- Encapsulamento adequado
- Separação de responsabilidades
- Classes bem definidas (Tarefa, Usuario, GerenciadorTarefas)
- Métodos coesos

## Estrutura

```
sistemaKanban/
├── entities/
│   ├── Tarefa.java
│   ├── Usuario.java
│   ├── Status.java (Enum)
│   └── Prioridade.java (Enum)
├── services/
│   └── GerenciadorTarefas.java
└── application/
    └── Main.java
```



## Complexidade das operações

| Operação | Complexidade | Estrutura Usada |
|----------|--------------|-----------------|
| Adicionar tarefa | O(log n) | PriorityQueue + TreeSet |
| Buscar por ID | O(1) | HashMap |
| Buscar por categoria | O(1) + O(k) | HashMap (k = tarefas na categoria) |
| Buscar por status | O(1) + O(k) | HashMap (k = tarefas no status) |
| Atribuir tarefa | O(1) | HashMap |
| Mudar status | O(1) | HashMap |
| Próxima prioritária (peek) | O(1) | PriorityQueue |
| Processar próxima (poll) | O(log n) | PriorityQueue |
| Listar por deadline | O(n) | TreeSet |
| Listar todas | O(n) | HashSet |


