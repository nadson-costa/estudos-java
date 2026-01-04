package poo.sistemaPagamentos.entities;

public class CartaoCredito extends Pagamento {
    private String numeroCartao;
    private int numeroParcelas;
    private String bandeira;

    public CartaoCredito(double valor, String descricao, String dataPagamento,
                         String numeroCartao, int numeroParcelas, String bandeira){
        super(valor, descricao, dataPagamento);

        this.numeroCartao = numeroCartao;
        this.numeroParcelas = numeroParcelas;
        this.bandeira = bandeira;
    }

    @Override
    public double calcularTaxas(){
        if(numeroParcelas == 1) return 0;
        if(numeroParcelas <= 6) return valor * 0.02;
        if(numeroParcelas <= 12) return valor * 0.05;
        return valor * 0.10;
    }

    @Override
    public void processar(){
        if(numeroParcelas < 0 || numeroParcelas > 24) {
            System.out.println("Erro: Número de parcelas inválido(1-24)!");
            return;
        }

        System.out.println("Processando pagamento no cartão " + bandeira + "...");

        double taxas = calcularTaxas();
        if(taxas > 0){
            System.out.printf("Taxa aplicada: R$ %.2f (%.0f%%)\n", taxas, (taxas/valor)*100);
        }

        double valorFinal = calcularValorFinal();
        double valorParcela = valorFinal / numeroParcelas;

        System.out.printf("Valor final: R$ %.2f\n", valorFinal);
        System.out.printf("Pagamento aprovado! %d parcelas de R$ %.2f\n",
                numeroParcelas, valorParcela);

        confirmarPagamento();
    }

    @Override
    public void exibirDetalhes(){
        super.exibirDetalhes();
        System.out.println("Últimos dígitos do cartão: " + numeroCartao);
        System.out.println("Número de parcelas: " + numeroParcelas);
        System.out.println("Bandeira: " + bandeira);
        System.out.println("================================");
        System.out.println();
    }
}
