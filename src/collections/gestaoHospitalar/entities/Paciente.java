package collections.gestaoHospitalar.entities;

import collections.sistemaKanban.entities.Usuario;

import java.time.LocalDateTime;

public class Paciente {
    private String cpf;
    private String nome;
    private int idade;
    private String telefone;
    private LocalDateTime dataCadastro;

    public Paciente(String cpf, String nome, int idade, String telefone){
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
        this.dataCadastro = LocalDateTime.now();
    }

    public void exibirInfo(){
        System.out.println("\n=== Informações do Paciente ===");
        System.out.println("CPF: " + cpf);
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Telefone: " + telefone);
        System.out.println("Data do Cadastro: " + dataCadastro);
        System.out.println("==========================");
    }

    public String getCpf(){
        return cpf;
    }

    public String getNome(){
        return nome;
    }

    public int getIdade(){
        return idade;
    }

    public String telefone(){
        return telefone;
    }

    public LocalDateTime getDataCadastro(){
        return dataCadastro;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Paciente paciente = (Paciente) obj;
        return cpf.equals(paciente.cpf);
    }

    @Override
    public int hashCode(){
        return cpf.hashCode();
    }
}
