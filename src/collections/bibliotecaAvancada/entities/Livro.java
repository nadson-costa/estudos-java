package collections.bibliotecaAvancada.entities;

public class Livro {
    private String isbn;
    private String titulo;
    private String autor;
    private String categoria;
    private boolean disponivel;

    public Livro(String isbn, String titulo, String autor, String categoria){
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.disponivel = true;
    }

    public void emprestar(){
        disponivel = false;
    }

    public void devolver(){
        disponivel = true;
    }

    public void exibirInfo(){
        System.out.println("\n===Informações do livro ===");
        System.out.println("ISBN: " + isbn);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Categoria: " + categoria);
        System.out.println("Disponibilidade: " + (disponivel ? "Disponível" : "Indisponível"));
        System.out.println("=============================");
    }

    public String getISBN(){
        return isbn;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getAutor(){
        return autor;
    }

    public String getCategoria(){
        return categoria;
    }

    public boolean isDisponivel(){
        return disponivel;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Livro livro = (Livro) obj;
        return isbn.equals(livro.isbn);
    }

    @Override
    public int hashCode(){
        return isbn.hashCode();
    }
}
