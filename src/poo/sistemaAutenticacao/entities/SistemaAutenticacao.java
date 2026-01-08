package poo.sistemaAutenticacao.entities;

import poo.sistemaAutenticacao.interfaces.Autenticavel;

import java.util.ArrayList;

public class SistemaAutenticacao {
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public void cadastrarUsuario(Usuario usuario){
        usuarios.add(usuario);
        System.out.println("-> Usuário cadastrado com sucesso!");
    }

    public Usuario tentarLogin(String email, String senha){
        Usuario usuario = null;
        for(Usuario u : usuarios){
            if(u.getEmail().equalsIgnoreCase(email)){
                usuario = u;
                break;
            }
        }

        if(usuario == null){
            System.out.println("-> Usuário não encontrado!");
            return null;
        }

        if(!(usuario instanceof Autenticavel)){
            System.out.println("-> Usuário não pode fazer login!");
            return null;
        }

        Autenticavel auth = (Autenticavel) usuario;

        if(!auth.autenticar(senha)){
            System.out.println("-> Senha incorreta!");
            return null;
        }

        auth.login();
        return usuario;
    }

    public void listarUsuariosLogados(){
        boolean encontrou = false;

        System.out.println("=== USUARIOS LOGADOS ===");
        for(Usuario usuario : usuarios){
            if(usuario.isLogado()){
                usuario.exibirInfo();
                encontrou = true;
            }
        }
        if(!encontrou){
            System.out.println("Nenhum usuario logado no momento.");
        }
        System.out.println("========================");
    }

    public void listarPorTipo(String tipo){
        System.out.println("=== LISTA DO TIPO: " + tipo + " ===");
        boolean encontrou = false;

        for(Usuario usuario: usuarios){
            if(tipo.equalsIgnoreCase("Funcionarios") && usuario instanceof Funcionario){
                usuario.exibirInfo();
                encontrou = true;
            } else if(
                    tipo.equalsIgnoreCase("Gerentes") && usuario instanceof Gerente){
                usuario.exibirInfo();
                encontrou = true;
            } else if(
                    tipo.equalsIgnoreCase("Admin") && usuario instanceof Admin){
                usuario.exibirInfo();
                encontrou = true;
            }
        }
        if(!encontrou){
            System.out.println("Nenhum usuário desse tipo foi encontrado!");
        }
    }
}
