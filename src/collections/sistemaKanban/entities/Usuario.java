package collections.sistemaKanban.entities;

public class Usuario {
    private String cpf;
    private String nome;
    private String email;

    public Usuario(String cpf, String nome, String email){
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public void exibirInfo(){
        System.out.println("=== Informações do Usuário ===");
        System.out.println("CPF: " + cpf);
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("=================");
    }

    public String getCpf(){
        return cpf;
    }

    public String getNome(){
        return nome;
    }

    public String getEmail(){
        return email;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Usuario usuario = (Usuario) obj;
        return cpf.equals(usuario.cpf);
    }

    @Override
    public int hashCode(){
        return cpf.hashCode();
    }
}
