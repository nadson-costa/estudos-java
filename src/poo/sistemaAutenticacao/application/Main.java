package poo.sistemaAutenticacao.application;

import poo.sistemaAutenticacao.entities.*;
import poo.sistemaAutenticacao.interfaces.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        SistemaAutenticacao sistema = new SistemaAutenticacao();
        Usuario usuarioAtual = null;
        int opcao;

        while(true){
            System.out.println("=== SISTEMA DE AUTENTICACAO ===");
            System.out.println("1 - Cadastrar Funcionario");
            System.out.println("2 - Cadastrar Gerente");
            System.out.println("3 - Cadastrar Admin");
            System.out.println("4 - Fazer Login");
            System.out.println("5 - Fazer Logout");
            System.out.println("6 - Listar usuarios logados");
            System.out.println("7 - Listar usuarios por tipo");
            System.out.println("8 - Gerenciar usuarios (Gerente/Admin)");
            System.out.println("9 - Exibir historico (Funcionario/Gerente)");
            System.out.println("10 - Sair");
            System.out.println("================================");
            System.out.print("-> Escolha uma opcao: ");
            opcao = sc.nextInt();

            if(opcao == 10){
                System.out.println("Ate mais!");
                sc.close();
                break;
            }
            switch(opcao){
                case 1:
                    sc.nextLine();
                    System.out.println("=== CADASTRAR FUNCIONARIO ===");
                    System.out.print("Digite o nome do funcionário: ");
                    String nomeFuncionario = sc.nextLine();

                    System.out.print("Digite o e-mail: ");
                    String emailFuncionario = sc.nextLine();

                    System.out.print("Digite a senha: ");
                    String senhaFuncionario = sc.nextLine();

                    System.out.print("Cargo do funcionário: ");
                    String cargo = sc.nextLine();

                    Funcionario funcionario = new Funcionario(nomeFuncionario, emailFuncionario,
                            senhaFuncionario, cargo);
                    sistema.cadastrarUsuario(funcionario);
                    break;

                case 2:
                    sc.nextLine();
                    System.out.println("=== CADASTRAR GERENTE ===");
                    System.out.print("Digite o nome do gerente: ");
                    String nomeGerente = sc.nextLine();

                    System.out.print("Digite o e-mail: ");
                    String emailGerente = sc.nextLine();

                    System.out.print("Digite a senha: ");
                    String senhaGerente = sc.nextLine();

                    System.out.print("Departamento do gerente: ");
                    String departamento = sc.nextLine();

                    Gerente gerente = new Gerente(nomeGerente, emailGerente,
                            senhaGerente, departamento);
                    sistema.cadastrarUsuario(gerente);
                    break;

                case 3:
                    sc.nextLine();
                    System.out.println("=== CADASTRAR ADMIN ===");
                    System.out.print("Digite o nome do admin: ");
                    String nomeAdmin = sc.nextLine();

                    System.out.print("Digite o e-mail: ");
                    String emailAdmin = sc.nextLine();

                    System.out.print("Digite a senha: ");
                    String senhaAdmin = sc.nextLine();

                    System.out.print("Nivel (1-5): ");
                    int nivel = sc.nextInt();

                    Admin admin = new Admin(nomeAdmin, emailAdmin, senhaAdmin, nivel);
                    sistema.cadastrarUsuario(admin);
                    break;

                case 4:
                    sc.nextLine();
                    System.out.println("=== FAZER LOGIN ===");
                    System.out.print("Email: ");
                    String emailLogin = sc.nextLine();

                    System.out.print("Senha: ");
                    String senhaLogin = sc.nextLine();

                    usuarioAtual = sistema.tentarLogin(emailLogin, senhaLogin);

                    if(usuarioAtual != null){
                        System.out.println("-> Bem-vindo, " + usuarioAtual.getNome() + "!");
                    }
                    break;

                case 5:
                    if(usuarioAtual == null){
                        System.out.println("-> Nenhum usuario logado!");
                        break;
                    }

                    if(usuarioAtual instanceof Autenticavel){
                        Autenticavel auth = (Autenticavel) usuarioAtual;
                        auth.logout();
                        usuarioAtual = null;
                    }
                    break;

                case 6:
                    sistema.listarUsuariosLogados();
                    break;

                case 7:
                    sc.nextLine();
                    System.out.println("=== TIPOS DISPONÍVEIS ===");
                    System.out.println("1 - Funcionario");
                    System.out.println("2 - Gerente");
                    System.out.println("3 - Admin");
                    System.out.print("-> Escolha o tipo: ");
                    int tipoOpcao = sc.nextInt();

                    String tipo = "";
                    if(tipoOpcao == 1) tipo = "Funcionario";
                    else if(tipoOpcao == 2) tipo = "Gerente";
                    else if(tipoOpcao == 3) tipo = "Admin";
                    else {
                        System.out.println("Opcão inválida!");
                        break;
                    }

                    sistema.listarPorTipo(tipo);
                    break;

                case 8:
                    if(usuarioAtual == null){
                        System.out.println("Você precisa estar logado!");
                        break;
                    }

                    if(!(usuarioAtual instanceof Administravel)){
                        System.out.println("Voce nao tem permissão para gerenciar usuarios!");
                        break;
                    }

                    Administravel admin2 = (Administravel) usuarioAtual;

                    System.out.println("=== GERENCIAR USUARIOS ===");
                    System.out.println("1 - Adicionar usuario");
                    System.out.println("2 - Remover usuario");
                    System.out.println("3 - Listar usuarios gerenciados");
                    System.out.print("-> Escolha: ");
                    int opcaoAdmin = sc.nextInt();
                    sc.nextLine();

                    if(opcaoAdmin == 1){
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        System.out.print("Senha: ");
                        String senha = sc.nextLine();

                        Usuario novoUsuario = new Usuario(nome, email, senha);
                        admin2.adicionarUsuario(novoUsuario);

                    } else if(opcaoAdmin == 2){
                        System.out.print("Nome do usuário para remover: ");
                        String nomeRemover = sc.nextLine();
                        admin2.removerUsuario(nomeRemover);

                    } else if(opcaoAdmin == 3){
                        admin2.listarUsuarios();
                    }
                    break;

                case 9:
                    if(usuarioAtual == null){
                        System.out.println("Você precisa estar logado!");
                        break;
                    }

                    if(!(usuarioAtual instanceof Auditavel)){
                        System.out.println("Seu usuário não possui histórico de ações!");
                        break;
                    }

                    Auditavel auditavel = (Auditavel) usuarioAtual;
                    auditavel.exibirHistorico();
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}