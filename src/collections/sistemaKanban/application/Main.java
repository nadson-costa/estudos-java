package collections.sistemaKanban.application;

import collections.sistemaKanban.entities.*;
import collections.sistemaKanban.services.GerenciadorTarefas;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();

        while(true){
            System.out.println("\n=== GERENCIADOR DE TAREFAS ===");
            System.out.println("1 - Criar tarefa");
            System.out.println("2 - Buscar por ID");
            System.out.println("3 - Buscar por categoria");
            System.out.println("4 - Buscar por status");
            System.out.println("5 - Atribuir tarefa a usuário");
            System.out.println("6 - Mudar status da tarefa");
            System.out.println("7 - Ver próxima tarefa prioritária");
            System.out.println("8 - Processar próxima tarefa");
            System.out.println("9 - Listar por deadline");
            System.out.println("10 - Listar por status");
            System.out.println("11 - Listar por categoria");
            System.out.println("12 - Listar tarefas de usuário");
            System.out.println("13 - Listar todas as tarefas");
            System.out.println("14 - Relatório geral");
            System.out.println("15 - Sair");
            System.out.println("======================");
            System.out.print("-> Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            if(opcao == 15){
                System.out.println(">>> Até mais!");
                sc.close();
                break;
            }

            switch(opcao){
                case 1:
                    try {
                        System.out.print("-> ID: ");
                        Long id = sc.nextLong();
                        sc.nextLine();

                        System.out.print("-> Título: ");
                        String titulo = sc.nextLine();

                        System.out.print("-> Descrição: ");
                        String descricao = sc.nextLine();

                        System.out.print("-> Categoria: ");
                        String categoria = sc.nextLine();

                        System.out.print("-> Prioridade (ALTA/MEDIA/BAIXA): ");
                        String prioridadeStr = sc.nextLine().toUpperCase();
                        Prioridade prioridade = Prioridade.valueOf(prioridadeStr);

                        System.out.print("-> Deadline (YYYY-MM-DD): ");
                        String deadlineStr = sc.nextLine();
                        LocalDate deadline = LocalDate.parse(deadlineStr);

                        Tarefa tarefa = new Tarefa(id, titulo, descricao, categoria, prioridade, deadline);
                        gerenciador.adicionarTarefa(tarefa);
                    } catch(IllegalArgumentException e){
                        System.out.println(">>> Prioridade inválida! Use: ALTA, MEDIA ou BAIXA");
                    } catch(DateTimeParseException e){
                        System.out.println(">>> Formato de data inválido! Use: YYYY-MM-DD");
                    }
                    break;

                case 2:
                    System.out.print("-> ID da tarefa: ");
                    Long idBusca = sc.nextLong();
                    sc.nextLine();

                    Tarefa tarefaEncontrada = gerenciador.buscarPorId(idBusca);
                    if(tarefaEncontrada != null){
                        tarefaEncontrada.exibirInfo();
                    } else {
                        System.out.println(">>> Tarefa não encontrada!");
                    }
                    break;

                case 3:
                    System.out.print("-> Categoria: ");
                    String categoriaBusca = sc.nextLine();

                    Set<Tarefa> tarefasCategoria = gerenciador.buscarPorCategoria(categoriaBusca);
                    if(tarefasCategoria.isEmpty()){
                        System.out.println(">>> Nenhuma tarefa encontrada na categoria: " + categoriaBusca);
                    } else {
                        System.out.println("\n=== Tarefas da Categoria: " + categoriaBusca + " ===");
                        for(Tarefa t : tarefasCategoria){
                            t.exibirResumo();
                        }
                    }
                    break;

                case 4:
                    try {
                        System.out.print("-> Status (TODO/DOING/DONE): ");
                        String statusStr = sc.nextLine().toUpperCase();
                        Status status = Status.valueOf(statusStr);

                        Set<Tarefa> tarefasStatus = gerenciador.buscarPorStatus(status);
                        if(tarefasStatus.isEmpty()){
                            System.out.println(">>> Nenhuma tarefa com status: " + status.getDescricao());
                        } else {
                            System.out.println("\n=== Tarefas - Status: " + status.getDescricao() + " ===");
                            for(Tarefa t : tarefasStatus){
                                t.exibirResumo();
                            }
                        }
                    } catch(IllegalArgumentException e){
                        System.out.println(">>> Status inválido! Use: TODO, DOING ou DONE");
                    }
                    break;

                case 5:
                    System.out.print("-> ID da tarefa: ");
                    Long idAtribuir = sc.nextLong();
                    sc.nextLine();

                    System.out.print("-> CPF do usuário: ");
                    String cpf = sc.nextLine();

                    System.out.print("-> Nome do usuário: ");
                    String nome = sc.nextLine();

                    System.out.print("-> Email do usuário: ");
                    String email = sc.nextLine();

                    Usuario usuario = new Usuario(cpf, nome, email);
                    gerenciador.atribuirTarefa(idAtribuir, usuario);
                    break;

                case 6:
                    try {
                        System.out.print("-> ID da tarefa: ");
                        Long idStatus = sc.nextLong();
                        sc.nextLine();

                        System.out.print("-> Novo status (TODO/DOING/DONE): ");
                        String novoStatusStr = sc.nextLine().toUpperCase();
                        Status novoStatus = Status.valueOf(novoStatusStr);

                        gerenciador.mudarStatus(idStatus, novoStatus);
                    } catch(IllegalArgumentException e){
                        System.out.println(">>> Status inválido! Use: TODO, DOING ou DONE");
                    }
                    break;

                case 7:
                    gerenciador.proximaTarefaPrioritaria();
                    break;

                case 8:
                    gerenciador.processarProximaTarefa();
                    break;

                case 9:
                    gerenciador.listarPorDeadline();
                    break;

                case 10:
                    try {
                        System.out.print("-> Status (TODO/DOING/DONE): ");
                        String statusListar = sc.nextLine().toUpperCase();
                        Status statusL = Status.valueOf(statusListar);

                        gerenciador.listarPorStatus(statusL);
                    } catch(IllegalArgumentException e){
                        System.out.println(">>> Status inválido! Use: TODO, DOING ou DONE");
                    }
                    break;

                case 11:
                    System.out.print("-> Categoria: ");
                    String categoriaListar = sc.nextLine();

                    gerenciador.listarPorCategoria(categoriaListar);
                    break;

                case 12:
                    System.out.print("-> CPF do usuário: ");
                    String cpfUsuario = sc.nextLine();

                    System.out.print("-> Nome do usuário: ");
                    String nomeUsuario = sc.nextLine();

                    System.out.print("-> Email do usuário: ");
                    String emailUsuario = sc.nextLine();

                    Usuario usuarioListar = new Usuario(cpfUsuario, nomeUsuario, emailUsuario);
                    gerenciador.listarTarefasUsuario(usuarioListar);
                    break;

                case 13:
                    gerenciador.listarTodasTarefas();
                    break;

                case 14:
                    gerenciador.relatorioGeral();
                    break;

                default:
                    System.out.println(">>> Opção inválida!");
                    break;
            }
        }
    }
}