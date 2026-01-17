package collections.bibliotecaAvancada.services;

import collections.bibliotecaAvancada.entities.Livro;
import collections.bibliotecaAvancada.entities.Usuario;

import java.util.*;

public class Biblioteca {
    private Set<Livro> livros = new HashSet<>();
    private Map<String, Livro> livrosPorISBN = new HashMap<>();
    private Map<String, Set<Livro>> livrosPorCategoria = new HashMap<>();
    private Map<String, Queue<Usuario>> filaEspera = new HashMap<>();

    public void adicionarLivro(Livro livro){
        livros.add(livro);
        livrosPorISBN.put(livro.getISBN(), livro);

        String categoria = livro.getCategoria();
        Set<Livro> livrosCategoria = livrosPorCategoria.get(categoria);
        if(livrosCategoria == null){
            livrosCategoria = new HashSet<>();
            livrosPorCategoria.put(categoria, livrosCategoria);
        }

        livrosCategoria.add(livro);
        System.out.println(">>> Livro adicionado com sucesso!");
    }

    public Livro buscarPorISBN(String isbn){
        return livrosPorISBN.get(isbn);
    }

    public Set<Livro> buscarPorCategoria(String categoria){
        Set<Livro> resultado = livrosPorCategoria.get(categoria);
        if(resultado==null){
            return new HashSet<>();
        }
        return resultado;
    }

    public Livro emprestarLivro(String isbn, Usuario usuario){
        Livro livro =  livrosPorISBN.get(isbn);
        if(livro==null){
            System.out.println(">>> Nenhum livro foi encontrado!");
            return null;
        }
        if(!livro.isDisponivel()){
            Queue<Usuario> fila = filaEspera.get(isbn);
            if(fila == null){
                fila = new LinkedList<>();
                filaEspera.put(isbn, fila);
            }
            fila.offer(usuario);
            System.out.println(">>> Livro indisponível! O usuário " + usuario.getNome() + " foi colocado na lista de espera");
            return null;
        }

        livro.emprestar();
        System.out.println(">>> Livro emprestado com sucesso para " + usuario.getNome());
        return livro;
    }

    public Livro devolverLivro(String isbn){
        Livro livro = livrosPorISBN.get(isbn);
        if(livro == null){
            System.out.println(">>> Nenhum livro foi encontrado!");
            return null;
        }

        livro.devolver();
        System.out.println(">>> Livro devolvido com sucesso!");

        Queue<Usuario> fila = filaEspera.get(isbn);
        if(fila != null && !fila.isEmpty()){
            System.out.println(">>> Verificando fila de espera...");
            Usuario proximo = fila.poll();
            livro.emprestar();
            System.out.println(">>> Livro " + livro.getTitulo() + " emprestado para o próximo da fila: " + proximo.getNome());
        }
        return livro;
    }
}
