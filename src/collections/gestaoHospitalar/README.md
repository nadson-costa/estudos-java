# Sistema de Gestão Hospitalar

> **Projeto de consolidação de estudo:** Sistema completo de gestão hospitalar desenvolvido para consolidar e aprofundar conhecimentos em **Collections Avançadas**, **Enums**, **Comparators**, **Relacionamento entre Classes** e **Estado de Objetos** em Java

## Projeto

Sistema profissional de gestão hospitalar com cadastro de pacientes e médicos, agendamento de consultas, filas de atendimento por especialidade, priorização por urgência e relatórios estatísticos completos.

## Conceitos aplicados

### Collections avançadas
- HashSet: Pacientes, médicos e consultas únicos
- HashMap (CPF -> Paciente, CRM → Medico): Busca O(1)
- HashMap (Especialidade -> Set<Medico>): Índice por especialidade
- HashMap (Especialidade -> Queue<Paciente>): Múltiplas filas
- PriorityQueue com Comparator: Ordenação por urgência

### Java avançado
- 2 Enums (Especialidade, Urgencia)
- Comparator customizado
- LocalDateTime
- equals/hashCode
- Estado dinâmico (boolean disponivel)
- Relacionamento triplo entre classes

## Estrutura

```
gestaoHospitalar/
├── entities/
│   ├── Paciente.java
│   ├── Medico.java
│   ├── Consulta.java
│   ├── Especialidade.java (Enum)
│   └── Urgencia.java (Enum)
├── services/
│   └── Hospital.java (17 métodos)
└── application/
    └── Main.java (18 funcionalidades)
```

## Estruturas de dados

```java
1. Set<Paciente> pacientes
2. Set<Medico> medicos
3. Set<Consulta> consultas
4. Map<String, Paciente> pacientesPorCPF
5. Map<String, Medico> medicosPorCRM
6. Map<Especialidade, Set<Medico>> medicosPorEspecialidade
7. Map<Especialidade, Queue<Paciente>> filaPorEspecialidade
8. PriorityQueue<Consulta> filaPrioridade
```


## Complexidade

| Operação | Complexidade |
|----------|--------------|
| Buscar CPF/CRM | O(1) |
| Cadastrar | O(1) |
| Agendar | O(log n) |
| Atender fila | O(k) k=médicos |
| Relatório | O(n) |

