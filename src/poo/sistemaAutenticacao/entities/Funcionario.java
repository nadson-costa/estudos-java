package poo.sistemaAutenticacao.entities;

import poo.sistemaAutenticacao.interfaces.Auditavel;
import poo.sistemaAutenticacao.interfaces.Autenticavel;

import java.util.ArrayList;

public class Funcionario extends Usuario implements Autenticavel, Auditavel {
    private String cargo;
    private ArrayList<String> historico = new ArrayList<>();

    public Funcionario(String nome, String email, String senha, String cargo){
        super(nome, email, senha);
        this.cargo = cargo;
    }

    @Override
    public boolean autenticar(String senha){
        return senha.equals(this.senha);
    }


    public void login(){
        if(logado){
            System.out.println("-> Usuário já está logado");
            return;
        }

        setLogado(true);
        registrarAcao(">> Login realizado");
        System.out.println("-> Login realizado com sucesso!");
    }

    @Override
    public void logout(){
        if(!logado){
            System.out.println("-> Usuário não está logado");
            return;
        }

        this.logado = false;
        registrarAcao(">> Logout realizdo");
        System.out.println("-> Logout realizado com sucesso!");
    }

    @Override
    public void registrarAcao(String acao){
        historico.add(acao);
    }

    @Override
    public void exibirHistorico(){
        if(historico.isEmpty()){
            System.out.println("-> Nenhuma ação realizada");
            return;
        }

        System.out.println("=== HISTÓRICO DE AÇÕES ===");
        for(String acao : historico){
            System.out.println("- " + acao);
        }
        System.out.println("========================");
    }

    public String getCargo(){
        return cargo;
    }

}
