package poo.sistemaAutenticacao.entities;

public class Usuario {
    protected String nome;
    protected String email;
    protected String senha;
    protected boolean logado;

    public Usuario(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.logado = false;
    }

    public void exibirInfo(){
        System.out.println("=== INFORMAÇÕES DO USUÁRIO ===");
        System.out.println("-> Nome: " + nome);
        System.out.println("-> E-mail: " + email);
        System.out.println("-> Login ativo: " + (logado ? "Sim" : "Não"));
        System.out.println("=============================");
    }

    public String getNome(){
        return nome;
    }

    public String getEmail(){
        return email;
    }

    public String getSenha(){
        return senha;
    }

    public boolean isLogado(){
        return logado;
    }

    public boolean setLogado(boolean logado){
        this.logado = logado;
    }
}
