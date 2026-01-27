# Estudos Java

Repositório dedicado ao estudo e prática de conceitos fundamentais e avançados da linguagem Java e Programação Orientada a Objetos.

## Contexto

Este repositório contém projetos práticos desenvolvidos para consolidar conhecimentos em Java, abrangendo desde fundamentos até conceitos avançados de POO, estruturas de dados e padrões de projeto.

## Projetos

### Programação Orientada a Objetos

#### Encapsulamento, Herança e Polimorfismo
- **[Sistema de Concessionária](src/poo/sistemaConcessionaria/)** - Hierarquia de classes, sobrescrita de métodos, `instanceof`

#### Abstração
- **[Sistema de Pagamentos](src/poo/sistemaPagamentos/)** - Classes abstratas, métodos abstratos, Template Method Pattern, processamento de pagamentos (Cartão/PIX/Boleto)

#### Interfaces
- **[Sistema de Autenticação](src/poo/sistemaAutenticacao/)** -  Interfaces, múltiplas implementações, controle de permissões, polimorfismo avançado

### Tratamento de Exceções
- **[Cadastro de Usuários](src/exceptions/cadastroUsuarios/)** -  Exceções personalizadas, throws/throw, múltiplos catch, finally, validações de dados 
- **[Sistema Bancário](src/exceptions/sistemaBancario/)** -  Sistema bancário completo com Conta Corrente (cheque especial), Conta Poupança (rendimento), exceções checked/unchecked, herança, polimorfismo, arquitetura em camadas

### Collections avançadas
- **[Biblioteca Avançada](src/collections/bibliotecaAvancada/)** -  Sistema completo com HashSet (livros únicos), HashMap (busca O(1)), Map<Set> (índice de categorias), Map<Queue> (filas de espera), empréstimo automático, 10 funcionalidades
- **[Sistema Kanban](src/collections/sistemaKanban/)** -  Gerenciador de tarefas completo com Enums (Status, Prioridade), PriorityQueue (ordenação por prioridade), TreeSet (ordenação por deadline), Comparators customizados, board Kanban (TODO/DOING/DONE)
- **[Sistema Hospital](src/collections/gestaoHospitalar/)** -  Gestão completa de hospital com filas por especialidade, priorização por urgência, estado dinâmico de médicos

### Lambda Expressions e Streams API
- **[Sistema E-commerce](src/lambda/)** -  Sistema completo com 20 desafios usando apenas Streams




## Conceitos praticados

- Sintaxe Java e tipos de dados
- Estruturas de controle (if/else, switch, loops)
- Arrays e Collections (ArrayList, Set, Map)
- Programação Orientada a Objetos
    - Encapsulamento
    - Herança
    - Polimorfismo
    - Abstração
    - Interfaces
- Exceções
  - Try-catch-finally 
  - Exceções personalizadas (checked e unchecked)
  - throws e throw
  - Hierarquia de exceções
- Collections avançadas
    - Set (HashSet, TreeSet, LinkedHashSet)
    - Map (HashMap, TreeMap, LinkedHashMap)
    - Queue (LinkedList, PriorityQueue)
    - Map com Set como valor 
    - Map com Queue como valor
    - TreeSet com Comparator customizado
    - PriorityQueue com Comparator customizado
    - equals() e hashCode()
- Java avançado
    - Enums type-safe com atributos 
    - Comparators e Lambda Expressions 
    - java.time (LocalDate, LocalDateTime)
    - Estado dinâmico de objetos 
    - Relacionamento entre classes
- Programação funcional
    -  Lambda Expressions 
    - Interfaces Funcionais (Predicate, Function, Consumer, Supplier)
    - Method References
    - Streams API 
    - Operações intermediárias e terminais 
    - Collectors (groupingBy, partitioningBy, counting)
    - Optional 
    - Stream aninhado
- Tratamento de exceções
- Manipulação de arquivos
- Padrões de projeto

## Próximos aprendizados

- [x] Fundamentos de Java
- [x] Encapsulamento
- [x] Herança e Polimorfismo
- [x] Abstração
- [x] Interfaces
- [x] Collections Framework avançado
- [x] Tratamento de Exceções
- [x] Enums e Comparators
- [x] Java Streams e Lambda Expressions
- [x] Programação Funcional
- [ ] JDBC e persistência de dados
- [ ] Design Patterns (Factory, Singleton, Observer, etc.)

## Notas

Repositório mantido para fins educacionais e referência de aprendizado contínuo em Java.

---

**Em constante atualização** - Novos projetos e conceitos são adicionados regularmente.
