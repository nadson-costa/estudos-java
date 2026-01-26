package lambda.sistemaEcommerce.entities;

public class Produto {
    private String nome;
    private double preco;
    private Categoria categoria;
    private int estoque;

    public Produto(String nome, double preco, Categoria categoria, int estoque){
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.estoque = estoque;
    }

    public String getNome(){
        return nome;
    }
    public double getPreco(){
        return preco;
    }
    public Categoria getCategoria(){
        return categoria;
    }
    public int getEstoque(){
        return estoque;
    }

    @Override
    public String toString(){
        return nome + ", " + preco + ", " + categoria;
    }
}
