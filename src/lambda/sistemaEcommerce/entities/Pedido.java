package lambda.sistemaEcommerce.entities;

import java.time.LocalDate;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<Produto> produtos;
    private LocalDate data;

    public Pedido(Cliente cliente, List<Produto> produtos, LocalDate data){
        this.cliente = cliente;
        this.produtos = produtos;
        this.data = data;
    }

    public Cliente getCliente(){
        return cliente;
    }
    public List<Produto> getProdutos(){
        return produtos;
    }
    public LocalDate getData(){
        return data;
    }
    public double getValorTotal(){
        return produtos.stream()
                .mapToDouble(Produto::getPreco)
                .sum();
    }
    @Override
    public String toString(){
        return "Pedido de " + cliente.getNome() +
                " - R$ " + getValorTotal() +
                " (" + produtos.size() + " produto(s))";
    }
}
