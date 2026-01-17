package collections.bibliotecaAvancada.entities;

public class Usuario {
    private String cpf;
    private String nome;

    public Usuario(String cpf, String nome){
        this.cpf = cpf;
        this.nome = nome;
    }

    public void exibirInfo(){
        System.out.println("\n=== Informações do Usuário ===");
        System.out.println("CPF: " + cpf);
        System.out.println("Nome: " + nome);
        System.out.println("======================");
    }

    public String getCPF(){
        return cpf;
    }

    public String getNome(){
        return nome;
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
