package poo.sistemaAutenticacao.entities;

import poo.sistemaAutenticacao.interfaces.Administravel;
import poo.sistemaAutenticacao.interfaces.Autenticavel;

import java.util.ArrayList;

public class Admin extends Usuario implements Autenticavel, Administravel {
    private int nivel;
    private ArrayList<Usuario> usuariosGerenciados = new ArrayList<>();

    public Admin(String nome, String email, String senha, int nivel){
        super(nome, email, senha);
        this.nivel = nivel;
    }

    public boolean autenticar(String senha){
        return senha.equals(this.senha);
    }

    public void login(){
        if(logado){
            System.out.println("-> Administrador já está logado!");
            return;
        }
        setLogado(true);
        System.out.println("Login realizado com sucesso!");
    }

    public void logout(){
        if(!logado){
            System.out.println("-> Administrador não está logado");
            return;
        }
        this.logado = false;
        System.out.println("-> Logout realizado com sucesso!");
    }

    public void adicionarUsuario(Usuario usuario){
        usuariosGerenciados.add(usuario);
        System.out.println("-> Usuário adicionado com sucesso!");
    }

    public void removerUsuario(String nome){
        for(Usuario usuario : usuariosGerenciados){
            if(usuario.getNome().equalsIgnoreCase(nome)){
                usuariosGerenciados.remove(usuario);
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
            return;
        }
        for(Usuario usuario : usuariosGerenciados){
            usuario.exibirInfo();
        }
        System.out.println("====================");
    }

}
