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
}
