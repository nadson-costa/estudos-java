# Gerenciamento de Concessionária

> **Projeto de estudo** - Sistema desenvolvido para praticar conceitos de **Herança** e **Polimorfismo** em Java

## Projeto

Sistema de gerenciamento de veículos para concessionária desenvolvido como exercício prático de Programação Orientada a Objetos (POO) em Java, com foco em **Herança**, **Polimorfismo** e **Encapsulamento**.

## Conceitos aplicados

- Herança (`extends`)
- Polimorfismo (ArrayList genérico)
- Sobrescrita de métodos (`@Override`)
- Encapsulamento (atributos `private` e `protected`)
- Construtores com `super()`
- Operador `instanceof`
- Organização em pacotes

## Estrutura de classes

```
Veiculo (classe base)
├── Carro
├── Moto
└── Caminhao

Concessionaria (gerenciamento)
Main (interface com usuário)
```

## Funcionalidades

- Cadastrar veículos (Carro, Moto, Caminhão)
- Listar todos os veículos
- Filtrar veículos por tipo
- Buscar veículo por modelo
- Exibir veículo mais caro/barato
- Calcular valor total do estoque
- Calcular IPVA total (com taxas diferenciadas por tipo)

## Executar localmente

1. Clone o repositório
2. Abra o projeto em sua IDE Java
3. Execute a classe `Main.java`
4. Navegue pelo menu interativo

## Estrutura

```
poo.sistemaConcessionaria
├── application
│   └── Main.java
└── entities
    ├── Veiculo.java
    ├── Carro.java
    ├── Moto.java
    ├── Caminhao.java
    └── Concessionaria.java
```


