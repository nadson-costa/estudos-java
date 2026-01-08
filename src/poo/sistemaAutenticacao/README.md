# Sistema de Autenticação utilizando Interfaces

> **Projeto de Estudo**: Sistema desenvolvido para praticar conceitos de **Interfaces** e **Polimorfismo** em Java

## Projeto

Sistema de autenticação e gerenciamento de usuários desenvolvido como exercício prático de Programação Orientada a Objetos (POO) em Java, com foco em **Interfaces**, **Múltiplas Implementações** e **Controle de Permissões**.

## Conceitos aplicados

- Interfaces (`interface`)
- Múltiplas implementações (`implements`)
- Polimorfismo avançado
- Herança (`extends`)
- Encapsulamento
- Controle de acesso e permissões
- Type checking (`instanceof`)
- Type casting
- Organização em pacotes

## Estrutura de Classes

```
Interfaces:
├── Autenticavel (capacidade de fazer login/logout)
├── Administravel (capacidade de gerenciar usuários)
└── Auditavel (capacidade de ter ações registradas)

Classes:
├── Usuario (classe base)
├── Funcionario (Autenticavel + Auditavel)
├── Gerente (Autenticavel + Administravel + Auditavel)
└── Admin (Autenticavel + Administravel)
```

## Controle de permissões dos usuários

### Funcionário
- Pode fazer login/logout
- Ações são auditadas (histórico)
- Não pode gerenciar outros usuários

### Gerente
- Pode fazer login/logout
- Pode gerenciar usuários
- Ações são auditadas (histórico)

### Admin
- Pode fazer login/logout
- Pode gerenciar usuários
- Ações NÃO são auditadas

## Funcionalidades

- Cadastro de diferentes tipos de usuários
- Sistema de login com autenticação por senha
- Logout de usuários
- Gerenciamento de usuários (adicionar/remover/listar)
- Histórico de ações (para usuários auditáveis)
- Listagem de usuários logados
- Filtro de usuários por tipo
- Controle de permissões por interface


## Estrutura

```
poo.sistemaAutenticacao
├── application
│   └── Main.java
├── entities
│   ├── Usuario.java
│   ├── Funcionario.java
│   ├── Gerente.java
│   ├── Admin.java
│   └── SistemaAutenticacao.java
└── interfaces
    ├── Autenticavel.java
    ├── Administravel.java
    └── Auditavel.java
```

