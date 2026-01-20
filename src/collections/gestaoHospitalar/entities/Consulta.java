package collections.gestaoHospitalar.entities;

import java.time.LocalDateTime;

public class Consulta {
    private Long id;
    private Paciente paciente;
    private Medico medico;
    private Especialidade especialidade;
    private Urgencia urgencia;
    private LocalDateTime dataHora;
    private String observacoes;

    public Consulta(Long id, Paciente paciente, Medico medico,
                    Especialidade especialidade, Urgencia urgencia, String observacoes){
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.especialidade = especialidade;
        this.urgencia = urgencia;
        this.dataHora = LocalDateTime.now();
        this.observacoes = observacoes;
    }

    public void exibirInfo(){
        System.out.println("\n=== Informações da Consulta ===");
        System.out.println("ID: " + id);
        System.out.println("Paciente: " + paciente.getNome());
        System.out.println("Medico: " + medico.getNome());
        System.out.println("Especialidade: " + especialidade.getDescricao());
        System.out.println("Urgência: " + urgencia.getDescricao());
        System.out.println("Data e Hora: " + dataHora);
        System.out.println("Observações: " + observacoes);
        System.out.println("===============================");
    }

    public void exibirResumo(){
        System.out.println("\n=== Resumo da Consulta ===");
        System.out.println("ID: " + id);
        System.out.println("Paciente: " + paciente.getNome());
        System.out.println("Medico: " + medico.getNome());
        System.out.println("Urgência: " + urgencia.getDescricao());
        System.out.println("==========================");
    }


    public Long getId(){
        return id;
    }
    public Paciente getPaciente(){
        return paciente;
    }
    public Medico getMedico(){
        return medico;
    }
    public Especialidade getEspecialidade(){
        return especialidade;
    }
    public Urgencia getUrgencia(){
        return urgencia;
    }
    public LocalDateTime getDataHora(){
        return dataHora;
    }
    public String getObservacoes(){
        return observacoes;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Consulta consulta = (Consulta) obj;
        return id.equals(consulta.id);
    }

    @Override
    public int hashCode(){
        return id.hashCode();
    }


}
