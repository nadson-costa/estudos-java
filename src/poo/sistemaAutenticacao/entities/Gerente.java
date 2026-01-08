package poo.sistemaAutenticacao.entities;

import poo.sistemaAutenticacao.interfaces.*;

import java.util.ArrayList;

public class Gerente extends Usuario implements Autenticavel, Administravel, Auditavel {
    private String departamento;
    private ArrayList<String> historico = new ArrayList<>();
    private ArrayList<Usuario> usuariosGerenciados = new ArrayList<>();

    public Gerente(String nome, String email, String senha, String departamento){
        super(nome, email, senha);
        this.departamento = departamento;
    }

    public boolean autenticar(String senha){
        return senha.equals(this.senha);
    }

    public void login(){
        if(logado){
            System.out.println("-> Gerente já está logado!");
            return;
        }
        setLogado(true);
        registrarAcao(">> Gerente fez o login com sucesso!");
        System.out.println("Login realizado com sucesso!");
    }

    public void logout(){
        if(!logado){
            System.out.println("-> Gerente não está logado");
            return;
        }

        this.logado = false;
        registrarAcao(">> Logout realizado");
        System.out.println("-> Logout realizado com sucesso!");
    }

    public void adicionarUsuario(Usuario usuario){
        usuariosGerenciados.add(usuario);
        registrarAcao(">> Usuário adicionado com sucesso pelo Gerente!");
        System.out.println("-> Usuário adicionado com sucesso!");
    }

    public void removerUsuario(String nome){
        for(Usuario usuario : usuariosGerenciados){
            if(usuario.getNome().equalsIgnoreCase(nome)){
                usuariosGerenciados.remove(usuario);
                registrarAcao("Removeu usuario: " + nome);
                System.out.println("✓ Usuario removido com sucesso!");
                return;
            }
        }
        System.out.println("Usuario nao encontrado!");
    }

    public void listarUsuarios(){
        System.out.println("=== LISTA DE USUÁRIOS ===");
        if(usuariosGerenciados.isEmpty()){
            System.out.println("-> Nenhum usuário registrado!");
        }
        for(Usuario usuario : usuariosGerenciados){
            usuario.exibirInfo();
        }
        System.out.println("====================");
    }

    public void registrarAcao(String acao){
        historico.add(acao);
    }

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


}
