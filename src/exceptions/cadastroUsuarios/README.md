# Sistema de Cadastro de Usuários

> **Projeto de estudo**: Sistema desenvolvido para praticar **Exceções Personalizadas** em Java

## Projeto

Sistema de cadastro de usuários com validações utilizando exceções personalizadas. Desenvolvido como exercício prático para consolidar o entendimento de tratamento de exceções em Java.

## Conceitos aplicados

- Exceções personalizadas (`extends Exception`)
- `throws` - Declarar exceções em métodos
- `throw` - Lançar exceções
- Múltiplos `catch` - Tratamento específico por tipo
- `finally` - Garantir fechamento de recursos
- Validações de dados (CPF, Email, Idade)

## Estrutura

```
cadastroUsuarios/
├── exceptions/
│   ├── CPFInvalidoException.java
│   ├── IdadeInvalidaException.java
│   └── EmailInvalidoException.java
├── entities/
│   └── Usuario.java
└── application/
    └── Main.java
```

## Validações implementadas

### CPF
- Não pode ser vazio ou nulo
- Deve ter exatamente 11 dígitos
- Deve conter apenas números

### Idade
- Não pode ser negativa ou zero
- Idade mínima: 18 anos
- Idade máxima: 120 anos

### Email
- Não pode ser vazio ou nulo
- Deve conter "@"
- Deve conter "." depois do "@"

