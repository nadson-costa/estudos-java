package lambda.entities;

public class Livro {
    private String titulo;
    private String autor;
    private double preco;
    private String categoria;
    private int paginas;

    public Livro(String titulo, String autor, double preco, String categoria, int paginas){
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
        this.categoria = categoria;
        this.paginas = paginas;
    }

    public String getTitulo(){ return titulo; }
    public String getAutor(){ return autor; }
    public double getPreco(){ return preco; }
    public String getCategoria(){ return categoria; }
    public int getPaginas(){ return paginas; }

    @Override
    public String toString(){
        return titulo + " - " + autor + " (R$ " + preco + ")";
    }
}
