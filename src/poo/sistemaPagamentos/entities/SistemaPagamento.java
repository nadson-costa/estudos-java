package poo.sistemaPagamentos.entities;

import java.util.ArrayList;

public class SistemaPagamento {
    private ArrayList<Pagamento> pagamentos = new ArrayList<>();

    public void adicionarPagamento(Pagamento p){
        pagamentos.add(p);
        System.out.println("Pagamento adicionado com sucesso");
    }

    public void listarPagamentos(){
        if(pagamentos.isEmpty()){
            System.out.println("Nenhum pagamento foi adicionado");
            return;
        }
        for(Pagamento pagamento : pagamentos){
            pagamento.exibirDetalhes();
        }
    }

    public void listarPorTipo(String tipo){
        System.out.println("=== LISTA DO TIPO: " + tipo + " ===");
        boolean encontrou = false;

        for(Pagamento pagamento : pagamentos){
            if(tipo.equalsIgnoreCase("PIX") && pagamento instanceof PIX) {
                pagamento.exibirDetalhes();
                encontrou = true;
            } else if(tipo.equalsIgnoreCase("Cartão de Crédito") && pagamento instanceof CartaoCredito){
                pagamento.exibirDetalhes();
                encontrou = true;
            } else if(tipo.equalsIgnoreCase("Boleto") && pagamento instanceof Boleto){
                pagamento.exibirDetalhes();
                encontrou = true;
            }
        }
        if(!encontrou){
            System.out.println("-> Nenhum tipo de pagamento encontrado");
        }
    }

    public double calcularTotalArrecadado(){
        double total = 0;
        for(Pagamento pagamento : pagamentos){
            if(pagamento.isStatusPago()){
                total += pagamento.calcularValorFinal();
            }
        }
        return total;
    }

    public double calcularTotalTaxas(){
        double totalTaxas = 0;
        for(Pagamento pagamento : pagamentos){
            if(pagamento.isStatusPago()){
                totalTaxas += pagamento.calcularTaxas();
            }
        }
        return totalTaxas;
    }

    public Pagamento buscarPorDescricao(String descricao){
        for(Pagamento pagamento : pagamentos){
            if(pagamento.getDescricao().equalsIgnoreCase(descricao)){
                return pagamento;
            }
        }
        return null;
    }
}
