package exceptions.cadastroUsuarios.entities;

import exceptions.cadastroUsuarios.exceptions.*;

public class Usuario {
    private String nome;
    private String cpf;
    private int idade;
    private String email;

    public Usuario(String nome, String cpf, int idade, String email)
        throws EmailInvalidoException, CPFInvalidoException, IdadeInvalidaException{

        this.nome = nome;

        validarCPF(cpf);
        this.cpf = cpf;

        validarIdade(idade);
        this.idade = idade;

        validarEmail(email);
        this.email = email;

    }

    private void validarCPF(String cpf) throws CPFInvalidoException{
        if(cpf == null || cpf.isEmpty()){
            throw new CPFInvalidoException("-> ERRO: CPF Não pode ser nulo ou vazio");
        }
        if(cpf.length() != 11){
            throw new CPFInvalidoException("-> ERRO: CPF deve ter 11 dígitos");
        }
        for(char c : cpf.toCharArray()){
            if(!Character.isDigit(c)){
                throw new CPFInvalidoException("-> ERRO: CPF deve conter apenas dígitos");
            }
        }
    }

    private void validarIdade(int idade) throws IdadeInvalidaException{
        if(idade <= 0){
            throw new IdadeInvalidaException("-> ERRO: Idade deve ser maior que 0!");
        }
        if(idade < 18){
            throw new IdadeInvalidaException("-> ERRO: Idade deve ser maior ou igual 18");
        }
        if(idade > 120){
            throw new IdadeInvalidaException("-> ERRO: Insira uma idade real");
        }
    }

    private void validarEmail(String email) throws EmailInvalidoException{
        if(email == null || email.isEmpty()){
            throw new EmailInvalidoException("-> ERRO: E-mail não pode ser nulo!");
        }
        if(!email.contains("@")){
            throw new EmailInvalidoException("-> ERRO: Digite um e-mail válido");
        }
        int p1 = email.indexOf("@");
        int p2 = email.lastIndexOf(".");
        if(p2 <= p1){
            throw new EmailInvalidoException("-> ERRO: E-mail deve conter um '.' depois do '@'!");
        }
    }

    public void exibirInfo(){
        System.out.println("\n=== INFORMAÇÕES DO USUÁRIO ===");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("E-mail: " + email);
        System.out.println("Idade: " + idade);
        System.out.println("==============================\n");
    }

    public String getNome(){
        return nome;
    }

    public String getCPF(){
        return cpf;
    }

    public int getIdade(){
        return idade;
    }

    public String getEmail(){
        return email;
    }
}
