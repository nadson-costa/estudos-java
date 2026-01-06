package poo.sistemaPagamentos.entities;

public abstract class Pagamento {
    protected double valor;
    protected String descricao;
    protected String dataPagamento;
    protected boolean statusPago;

    public Pagamento(double valor, String descricao, String dataPagamento){
        this.valor = valor;
        this.descricao = descricao;
        this.dataPagamento = dataPagamento;
        this.statusPago = false;
    }

    public abstract double calcularTaxas();
    public abstract void processar();

    public void confirmarPagamento(){
        this.statusPago = true;
        System.out.println("-> Pagamento confirmado com sucesso!");
    }

    public double calcularValorFinal(){
        return valor + calcularTaxas();
    }

    public void exibirDetalhes(){
        System.out.println();
        System.out.println("==== INFORMAÇÕES DO PAGAMENTO ====");
        System.out.printf("Valor: R$ %.2f\n", valor);
        System.out.println("Descrição: " + descricao);
        System.out.println("Data: " + dataPagamento);
        System.out.println("Status: " + (statusPago ? "Pago" : "Pendente"));
        System.out.printf("Valor final: R$ %.2f\n", calcularValorFinal());
        System.out.println("===================================");
        System.out.println();
    }

    public double getValor(){
        return valor;
    }

    public String getDescricao(){
        return descricao;
    }

    public String getDataPagamento(){
        return dataPagamento;
    }

    public boolean isStatusPago(){
        return statusPago;
    }

    public void setStatusPago(boolean statusPago){
        this.statusPago = statusPago;
    }
}