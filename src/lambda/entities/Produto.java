package lambda.entities;

public class Produto {
    private String nome;
    private double preco;
    private int estoque;
    private boolean promocao;

    public Produto(String nome, double preco, int estoque, boolean promocao){
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.promocao = promocao;
    }

    public String getNome(){ return nome; }
    public double getPreco(){ return preco; }
    public int getEstoque(){ return estoque; }
    public boolean isPromocao(){ return promocao; }
    @Override
    public String toString(){
        return nome + " - R$ " + preco + " - Estoque: " + estoque;
    }
}
