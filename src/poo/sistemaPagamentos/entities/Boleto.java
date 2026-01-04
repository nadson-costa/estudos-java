package poo.sistemaPagamentos.entities;

import java.util.UUID;

public class Boleto extends Pagamento{
    private String codigoBoleto;
    private String dataVencimento;
    private double jurosAtraso;

    public Boleto(double valor, String descricao, String dataPagamento, String dataVencimento){
        super(valor, descricao, dataPagamento);

        this.codigoBoleto = UUID.randomUUID().toString();
        this.jurosAtraso = 0.02;
        this.dataVencimento = dataVencimento;
    }

    @Override
    public double calcularTaxas(){
        return 3.50;
    }

    @Override
    public void processar(){
        System.out.println("Um momento. Estamos gerando o seu boleto...");
        System.out.println("-> Código do boleto: " + codigoBoleto);
        System.out.println("-> Data de vencimento: " + dataVencimento);
        System.out.printf("-> Valor final(já incluso taxas): R$ %.2f\n", calcularValorFinal());
        System.out.println("BOLETO GERADO COM SUCESSO!");

        confirmarPagamento();
    }

    @Override
    public void exibirDetalhes(){
        super.exibirDetalhes();
        System.out.println("Código do boleto: " + codigoBoleto);
        System.out.println("Data de vencimento: " + dataVencimento);
        System.out.println("===================================");
        System.out.println();
    }
}
