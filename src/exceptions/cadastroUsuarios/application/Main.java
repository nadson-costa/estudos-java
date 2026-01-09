package exceptions.cadastroUsuarios.application;

import exceptions.cadastroUsuarios.entities.Usuario;
import exceptions.cadastroUsuarios.exceptions.*;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("=== CADASTRO DE USUÁRIOS ===");
        try{
            System.out.println("-> Digite o nome do usuário: ");

            String nome = sc.nextLine();

            System.out.println("-> Digite o CPF do usuário: ");
            String cpf = sc.nextLine();

            System.out.println("-> Digite o e-mail do usuário: ");
            String email = sc.nextLine();

            System.out.println("-> Digite a idade do usuário: ");
            int idade = sc.nextInt();

            Usuario usuario = new Usuario(nome, cpf, idade, email);
            System.out.println(">> Cadastro realizado com sucesso!\n");
            usuario.exibirInfo();


        } catch(CPFInvalidoException e){
            System.out.println("\nErro no CPF: " + e.getMessage());
        } catch(EmailInvalidoException e){
            System.out.println("\nErro no E-mail: " + e.getMessage());
        } catch(IdadeInvalidaException e){
            System.out.println("\nErro na Idade: " + e.getMessage());
        } finally{
            sc.close();
        }
    }
}
