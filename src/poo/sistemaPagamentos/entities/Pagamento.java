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

    public double getValor(){
        return valor;
    }

    public String getDescricao(){
        return descricao;
    }

    public String getDataPagamento(){
        return dataPagamento;
    }

    public boolean getStatusPago(){
        return statusPago;
    }

    public void isStatusPago(boolean statusPago){
        this.statusPago = statusPago;
    }

    public abstract double calcularTaxas();
    public abstract void processar();

    public void confirmarPagamento(){
        isStatusPago(true);
        System.out.println("---> Pagamento finalizado com sucesso!");
    }

    public double calcularValorFinal(){
        return valor + calcularTaxas();
    }

    public void exibirDetalhes(){
        System.out.println();
        System.out.println("==== INFORMAÇÕES DO PAGAMENTO ====");
        System.out.println("Valor do pagamento: " + valor);
        System.out.println("Descrição: " + descricao);
        System.out.println("Data do pagamento: " + dataPagamento);
        System.out.println("Status do pagamento: " + statusPago);
        System.out.println("================================");
    }

}
