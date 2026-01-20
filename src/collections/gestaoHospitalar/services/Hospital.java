package collections.gestaoHospitalar.services;

import collections.gestaoHospitalar.entities.*;

import java.util.*;

public class Hospital {
    private Set<Paciente> pacientes = new HashSet<>();
    private Set<Medico> medicos = new HashSet<>();
    private Set<Consulta> consultas = new HashSet<>();
    private Map<String, Paciente> pacientesPorCPF = new HashMap<>();
    private Map<String, Medico> medicosPorCRM = new HashMap<>();
    private Map<Especialidade, Set<Medico>> medicosPorEspecialidade = new HashMap<>();
    private Map<Especialidade, Queue<Paciente>> filaPorEspecialidade = new HashMap<>();
    private PriorityQueue<Consulta> filaPrioridade;

    public Hospital(){
        filaPrioridade = new PriorityQueue<>((c1, c2) ->
                c2.getUrgencia().getNivel() - c1.getUrgencia().getNivel()
        );
    }

    public void cadastrarPaciente(Paciente paciente){
        pacientes.add(paciente);
        pacientesPorCPF.put(paciente.getCpf(), paciente);
        System.out.println(">>> Paciente cadastrado com sucesso!");
    }

    public void cadastrarMedico(Medico medico){
        medicos.add(medico);
        medicosPorCRM.put(medico.getCrm(), medico);
        Set<Medico> medicoEspecialidade = medicosPorEspecialidade.get(medico.getEspecialidade());
        if(medicoEspecialidade == null){
            medicoEspecialidade = new HashSet<>();
            medicosPorEspecialidade.put(medico.getEspecialidade(), medicoEspecialidade);
        }
        medicoEspecialidade.add(medico);
        System.out.println(">>> Médico cadastrado com sucesso!");
    }

    public Paciente buscarPacientePorCPF(String cpf){
        Paciente paciente = pacientesPorCPF.get(cpf);
        if(paciente == null){
            System.out.println(">>> Nenhum paciente foi encontrado!");
            return null;
        }
        return paciente;
    }

    public Medico buscarMedicoPorCRM(String crm){
        Medico medico = medicosPorCRM.get(crm);
        if(medico == null){
            System.out.println(">>> Nenhum médico foi encontrado!");
            return null;
        }
        return medico;
    }

    public Set<Medico> buscarMedicosPorEspecialidade(Especialidade especialidade){
        Set<Medico> medicosEspecialidade = medicosPorEspecialidade.get(especialidade);
        if(medicosEspecialidade == null){
            return new HashSet<>();
        }
        return medicosEspecialidade;
    }

    public void adicionarNaFila(Paciente paciente, Especialidade especialidade){
        Queue<Paciente> fila = filaPorEspecialidade.get(especialidade);
        if(fila == null){
            fila = new LinkedList<>();
            filaPorEspecialidade.put(especialidade, fila);
        }
        fila.offer(paciente);
        System.out.println("Paciente adicionado na fila. Posição: " + fila.size());
    }

    public void agendarConsulta(String cpf, String crm, Urgencia urgencia, String observacoes){
        Paciente paciente = pacientesPorCPF.get(cpf);
        if(paciente == null){
            System.out.println(">>> Nenhum paciente foi encontrado!");
            return;
        }

        Medico medico = medicosPorCRM.get(crm);
        if(medico == null){
            System.out.println(">>> Nenhum médico foi encontrado!");
            return;
        }

        if(!medico.isDisponivel()){
            System.out.println(">>> O médico " + medico.getNome() + " não está disponível!");
            return;
        }
        Especialidade especialidadeMedico = medico.getEspecialidade();
        Long id = System.currentTimeMillis();

        Consulta novaConsulta = new Consulta(id, paciente, medico, especialidadeMedico, urgencia, observacoes);

        consultas.add(novaConsulta);
        filaPrioridade.add(novaConsulta);
        medico.atender();

        System.out.println(">>> Consulta marcada com sucesso!");
    }

    public void finalizarConsulta(String crm){
        Medico medico = medicosPorCRM.get(crm);
        if(medico == null){
            System.out.println(">>> Médico não encontrado!");
            return;
        }
        if(medico.isDisponivel()){
            System.out.println(">>> Médico não está em atendimento!");
            return;
        }
        medico.liberar();
        System.out.println(">>> Consulta finalizada com sucesso!");
    }

    public Consulta proximaConsultaUrgente(){
        if(filaPrioridade.isEmpty()){
            System.out.println(">>> Nenhuma consulta urgente!");
            return null;
        }
        Consulta proximaUrgente = filaPrioridade.peek();
        System.out.println(">>> Próxima consulta urgente:");
        proximaUrgente.exibirResumo();

        return proximaUrgente;
    }

    public Consulta atenderProximaUrgente(){
        if(filaPrioridade.isEmpty()){
            System.out.println(">>> Nenhuma consulta urgente!");
            return null;
        }
        Consulta proximaUrgente = filaPrioridade.poll();
        System.out.println(">>> Consulta atendida:");
        proximaUrgente.exibirResumo();

        return proximaUrgente;
    }

    public void listarPacientes(){
        if(pacientes.isEmpty()){
            System.out.println(">>> Nenhum paciente encontrado!");
            return;
        }
        System.out.println("\n=== Pacientes Cadastrados ===");
        for(Paciente paciente : pacientes){
            paciente.exibirInfo();
        }
    }

    public void listarMedicos(){
        if(medicos.isEmpty()){
            System.out.println(">>> Nenhum médico encontrado!");
            return;
        }
        System.out.println("\n=== Médicos Cadastrados ===");
        for(Medico medico : medicos){
            medico.exibirInfo();
        }
    }

    public void listarMedicosPorEspecialidade(Especialidade especialidade){
        Set<Medico> medicos = buscarMedicosPorEspecialidade(especialidade);
        if(medicos.isEmpty()){
            System.out.println(">>> Nenhum médico nessa especialidade!");
            return;
        }
        System.out.println("\n=== Médicos da Especialidade " + especialidade.getDescricao());
        for(Medico medico : medicos){
            medico.exibirInfo();
        }

    }

    public void listarConsultas() {
        if (consultas.isEmpty()) {
            System.out.println(">>> Nenhuma consultada encontrada!");
            return;
        }
        System.out.println("\n=== Consultas Cadastrados ===");
        for (Consulta consulta : consultas) {
            consulta.exibirInfo();
        }
    }

    public void mostrarFilaEspecialidade(Especialidade especialidade){
        Queue<Paciente> fila = filaPorEspecialidade.get(especialidade);
        if(fila == null || fila.isEmpty()){
            System.out.println(">>> Fila vazia!");
            return;
        }
        System.out.println("\n=== Fila da Especialidade " + especialidade.getDescricao());
        int posicao = 1;
        for(Paciente paciente : fila){
            System.out.println(posicao + ". " + paciente.getNome());
            posicao++;
        }
    }

    public void atenderProximoDaFila(Especialidade especialidade){
        Queue<Paciente> fila = filaPorEspecialidade.get(especialidade);

        if(fila == null || fila.isEmpty()){
            System.out.println(">>> Nenhum paciente na fila de " + especialidade.getDescricao());
            return;
        }

        Set<Medico> medicosEspecialidade = buscarMedicosPorEspecialidade(especialidade);

        Medico medicoDisponivel = null;

        for(Medico medico : medicosEspecialidade){
            if(medico.isDisponivel()){
                medicoDisponivel = medico;
                break;
            }
        }

        if(medicoDisponivel == null){
            System.out.println(">>> Nenhum médico disponível para " + especialidade.getDescricao());
            return;
        }

        Paciente paciente = fila.poll();

        Long id = System.currentTimeMillis();
        Consulta consulta = new Consulta(id, paciente, medicoDisponivel, especialidade,
                Urgencia.MEDIA, "Atendimento da fila");

        consultas.add(consulta);

        medicoDisponivel.atender();

        System.out.println(">>> Paciente " + paciente.getNome() + " atendido pelo Dr(a). " + medicoDisponivel.getNome());
    }

    public void relatorioGeral(){
        if(pacientes.isEmpty() && medicos.isEmpty() && consultas.isEmpty()){
            System.out.println(">>> Sistema sem dados!");
            return;
        }

        System.out.println("\n=== Relatório Geral do Hospital ===");

        System.out.println("\nTotal de pacientes: " + pacientes.size());
        System.out.println("Total de médicos: " + medicos.size());
        System.out.println("Total de consultas: " + consultas.size());

        int disponiveis = 0;
        int ocupados = 0;

        for(Medico medico : medicos){
            if(medico.isDisponivel()){
                disponiveis++;
            } else {
                ocupados++;
            }
        }

        System.out.println("\nMédicos:");
        System.out.println("  Disponíveis: " + disponiveis);
        System.out.println("  Em atendimento: " + ocupados);

        int emergencia = 0;
        int alta = 0;
        int media = 0;
        int baixa = 0;

        for(Consulta consulta : consultas){
            switch(consulta.getUrgencia()){
                case EMERGENCIA:
                    emergencia++;
                    break;
                case ALTA:
                    alta++;
                    break;
                case MEDIA:
                    media++;
                    break;
                case BAIXA:
                    baixa++;
                    break;
            }
        }

        System.out.println("\nConsultas por Urgência:");
        System.out.println("  Emergência: " + emergencia);
        System.out.println("  Alta: " + alta);
        System.out.println("  Média: " + media);
        System.out.println("  Baixa: " + baixa);

        System.out.println("\nFilas de Espera:");
        for(Especialidade esp : Especialidade.values()){
            Queue<Paciente> fila = filaPorEspecialidade.get(esp);
            int tamanho = (fila == null) ? 0 : fila.size();
            System.out.println("  " + esp.getDescricao() + ": " + tamanho + " paciente(s)");
        }

        Map<Especialidade, Integer> consultasPorEsp = new HashMap<>();

        for(Consulta consulta : consultas){
            Especialidade esp = consulta.getEspecialidade();
            int contador = consultasPorEsp.getOrDefault(esp, 0);
            consultasPorEsp.put(esp, contador + 1);
        }

        System.out.println("\nConsultas por Especialidade:");
        for(Especialidade esp : Especialidade.values()){
            int total = consultasPorEsp.getOrDefault(esp, 0);
            System.out.println("  " + esp.getDescricao() + ": " + total);
        }

        System.out.println("\n====================================");
    }



}
