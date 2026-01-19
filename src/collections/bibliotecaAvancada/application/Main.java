package collections.bibliotecaAvancada.application;

import collections.bibliotecaAvancada.entities.Livro;
import collections.bibliotecaAvancada.entities.Usuario;
import collections.bibliotecaAvancada.services.Biblioteca;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        while(true){
            System.out.println("\n=== SISTEMA BIBLIOTECA ===");
            System.out.println("1 - Adicionar livro");
            System.out.println("2 - Busca por ISBN");
            System.out.println("3 - Busca por categoria");
            System.out.println("4 - Emprestar livro");
            System.out.println("5 - Devolver livro");
            System.out.println("6 - Listar todos os livros");
            System.out.println("7 - Listar livros disponíveis");
            System.out.println("8 - Listar por categoria");
            System.out.println("9 - Mostrar fila de espera");
            System.out.println("10 - Sair");
            System.out.println("========================");
            System.out.print("-> Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            if(opcao==10){
                System.out.println(">>> Até mais!");
                break;
            }

            switch(opcao){
                case 1:
                    System.out.println("-> Digite o ISBN: ");
                    String isbn = sc.nextLine();

                    System.out.println("-> Digite o título: ");
                    String titulo = sc.nextLine();

                    System.out.println("-> Digite o nome do autor: ");
                    String autor = sc.nextLine();

                    System.out.println("-> Digite a categoria: ");
                    String categoria = sc.nextLine();

                    Livro novoLivro = new Livro(isbn, titulo, autor, categoria);
                    biblioteca.adicionarLivro(novoLivro);
                    break;

                case 2:
                    System.out.println("-> Digite o ISBN: ");
                    String isbnLivro = sc.nextLine();

                    Livro livro = biblioteca.buscarPorISBN(isbnLivro);

                    if(livro != null){
                        livro.exibirInfo();
                    } else {
                        System.out.println(">>> Livro não encontrado!");
                    }

                    break;

                case 3:
                    System.out.println("-> Digite o nome da categoria");
                    String categoriaLivros = sc.nextLine();

                    biblioteca.buscarPorCategoria(categoriaLivros);
                    break;

                case 4:
                    System.out.println("-> Digite o ISBN do livro: ");
                    String isbnEmprestarLivro = sc.nextLine();

                    System.out.println("-> Digite o nome do usuário: ");
                    String nome = sc.nextLine();

                    System.out.println("-> Digite o CPF do usuário: ");
                    String cpf = sc.nextLine();

                    Usuario novoUsuario = new Usuario(cpf, nome);
                    biblioteca.emprestarLivro(isbnEmprestarLivro, novoUsuario);
                    break;

                case 5:
                    System.out.println("-> Digite o ISBN do livro: ");
                    String isbnDevolverLivro = sc.nextLine();

                    biblioteca.devolverLivro(isbnDevolverLivro);
                    break;

                case 6:
                    biblioteca.listarTodos();
                    break;

                case 7:
                    biblioteca.listarDisponiveis();
                    break;

                case 8:
                    System.out.println("-> Digite o nome da categoria: ");
                    String livrosPorCategoria = sc.nextLine();

                    biblioteca.listarPorCategoria(livrosPorCategoria);
                    break;

                case 9:
                    System.out.println("-> Digite o ISBN do livro: ");
                    String isbnFilaEspera = sc.nextLine();

                    biblioteca.mostrarFilaEspera(isbnFilaEspera);
                    break;

                default:
                    System.out.println(">>> Opção inválida!");
                    break;

            }
        }
    }
}
