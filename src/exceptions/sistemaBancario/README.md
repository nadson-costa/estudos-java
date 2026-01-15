# Sistema Bancário com Exceções

> **Projeto de estudo**: Sistema bancário completo desenvolvido para praticar **Exceções Personalizadas**, **Herança** e **Polimorfismo** em Java

## Projeto

Sistema bancário robusto com gerenciamento de contas correntes e poupança, desenvolvido como exercício prático para consolidar conceitos avançados de Programação Orientada a Objetos e tratamento de exceções em Java.

## Conceitos aplicados

### Exceções
- Exceções personalizadas (checked e unchecked)
- `throws` - Declarar exceções em métodos
- `throw` - Lançar exceções
- Múltiplos `catch` - Tratamento específico por tipo
- Hierarquia de exceções

### POO avançado
- Herança com múltiplos níveis
- Polimorfismo (ArrayList<Conta>)
- Sobrescrita de métodos (@Override)
- `instanceof` e type casting
- Encapsulamento com validações

### Arquitetura
- Separação em camadas (entities, services, exceptions, application)
- Padrão de organização profissional
- Responsabilidade única (Single Responsibility)

## Estrutura

```
sistemaBancario/
├── application/
│   └── Main.java
├── entities/
│   ├── Conta.java (classe base)
│   ├── ContaCorrente.java
│   └── ContaPoupanca.java
├── exceptions/
│   ├── ContaNaoEncontradaException.java
│   ├── LimiteExcedidoException.java
│   ├── SaldoInsuficienteException.java
│   └── ValorInvalidoException.java
└── services/
    └── Banco.java
```

## Funcionalidades

### Menu interativo
1. **Criar conta corrente** - Com limite de cheque especial
2. **Criar conta poupança** - Com taxa de rendimento
3. **Depositar** - Em qualquer conta
4. **Sacar** - Com validações de saldo e limite
5. **Transferir** - Entre contas
6. **Consultar saldo** - Exibe saldo atual
7. **Exibir extrato** - Completo com informações específicas
8. **Render juros** - Exclusivo para poupança
9. **Listar todas as contas** - Visão geral do banco
10. **Sair** - Encerra o sistema

### Validações implementadas

#### Criação de conta
- Número da conta vazio → IllegalArgumentException
- Titular vazio → IllegalArgumentException

#### Depósito
- Valor <= 0 → ValorInvalidoException
- Conta não existe → ContaNaoEncontradaException

#### Saque
- Valor <= 0 → ValorInvalidoException
- Saldo insuficiente → SaldoInsuficienteException
- Ultrapassa limite (Corrente) → LimiteExcedidoException
- Conta não existe → ContaNaoEncontradaException

#### Transferência
- Conta origem não existe → ContaNaoEncontradaException
- Conta destino não existe → ContaNaoEncontradaException
- Valor inválido → ValorInvalidoException
- Saldo insuficiente → SaldoInsuficienteException
- Ultrapassa limite → LimiteExcedidoException

#### Render juros
- Conta não é poupança → Mensagem de erro
- Conta não existe → ContaNaoEncontradaException
