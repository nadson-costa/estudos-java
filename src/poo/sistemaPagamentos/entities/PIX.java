package poo.sistemaPagamentos.entities;

import java.util.UUID;

public class PIX extends Pagamento{
    private String chavePix;
    private String codigoTransacao;

    public PIX(double valor, String descricao, String dataPagamento, String chavePix){
        super(valor, descricao, dataPagamento);

        this.chavePix = chavePix;
        this.codigoTransacao = gerarCodigoTransacao();
    }

    public String gerarCodigoTransacao(){
        return "PIX" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

    }

    @Override
    public double calcularTaxas(){
        return 0;
    }

    @Override
    public void processar(){
        System.out.println("Gerando QR Code para pagamento PIX...");
        System.out.println("-> Chave PIX: " + chavePix);
        System.out.println("-> Código da transação: " + codigoTransacao + gerarCodigoTransacao());
        System.out.println("Aguardando confirmação...");
        System.out.println("PAGAMENTO PIX CONFIRMADO!");
        System.out.println();

        confirmarPagamento();
    }

    @Override
    public void exibirDetalhes(){
        super.exibirDetalhes();
        System.out.println("Chave PIX: " + chavePix);
        System.out.println("Código da transação: " + codigoTransacao);
        System.out.println("===================================");
        System.out.println();
    }

}
