package collections.gestaoHospitalar.entities;

public class Medico {
    private String crm;
    private String nome;
    private Especialidade especialidade;
    private boolean disponivel;

    public Medico(String crm, String nome, Especialidade especialidade){
        this.crm = crm;
        this.nome = nome;
        this.especialidade = especialidade;
        this.disponivel = true;
    }

    public void atender(){
        this.disponivel = false;
    }

    public void liberar(){
        this.disponivel = true;
    }

    public void exibirInfo(){
        System.out.println("\n=== Informações do Médico ===");
        System.out.println("CRM: " + crm);
        System.out.println("Nome: " + nome);
        System.out.println("Especialidade: " + especialidade);
        System.out.println("Disponível: " + (disponivel ? "Sim" : "Não"));
        System.out.println("============================");
    }

    public String getCrm(){
        return crm;
    }

    public String getNome(){
        return nome;
    }

    public Especialidade getEspecialidade(){
        return especialidade;
    }

    public boolean isDisponivel(){
        return disponivel;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Medico medico = (Medico) obj;
        return crm.equals(medico.crm);
    }

    @Override
    public int hashCode(){
        return crm.hashCode();
    }



}
