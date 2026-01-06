# Sistema de Processamento de Pagamentos

> **Projeto de estudo** - Sistema desenvolvido para praticar conceitos de **Abstração** e **Classes Abstratas** em Java

## Projeto

Sistema de processamento de pagamentos desenvolvido como exercício prático de Programação Orientada a Objetos (POO) em Java, com foco em **Classes Abstratas**, **Métodos Abstratos** e **Template Method Pattern**.

## Conceitos aplicados

- Classes Abstratas (`abstract class`)
- Métodos Abstratos (sem implementação)
- Template Method Pattern
- Polimorfismo avançado
- Encapsulamento
- Herança
- Sobrescrita de métodos (`@Override`)
- Organização em pacotes

## Estrutura de classes

```
Pagamento (classe abstrata)
├── CartaoCredito
├── PIX
└── Boleto

SistemaPagamento (gerenciamento)
Main (interface com usuário)
```

## Funcionalidades

- Processar pagamentos (Cartão, PIX, Boleto)
- Listar todos os pagamentos
- Filtrar pagamentos por tipo
- Buscar pagamento por descrição
- Calcular total arrecadado
- Calcular total de taxas cobradas
- Confirmação automática de pagamentos

## Executar localmente

1. Clone o repositório
2. Abra o projeto em sua IDE Java
3. Execute a classe `Main.java`
4. Navegue pelo menu interativo

## Estrutura

```
poo.sistemaPagamentos
├── application
│   └── Main.java
└── entities
    ├── Pagamento.java (abstrata)
    ├── CartaoCredito.java
    ├── PIX.java
    ├── Boleto.java
    └── SistemaPagamento.java
```
