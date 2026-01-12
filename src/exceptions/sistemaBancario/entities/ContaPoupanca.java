package exceptions.sistemaBancario.entities;

public class ContaPoupanca extends Conta{
    private double taxaRendimento;

    public ContaPoupanca(String numeroConta, String titular, double taxaRendimento){
        super(numeroConta, titular);
        this.taxaRendimento = taxaRendimento;
    }

    public void renderJuros(){
        double rendimento = saldo * taxaRendimento;
        this.saldo = this.saldo + rendimento;
        System.out.println("Valor do rendimento: R$ " + rendimento);
    }

    @Override
    public void exibirExtrato(){
        super.exibirExtrato();
        System.out.println("Taxa de rendimento: " + taxaRendimento * 100 + "%");
        System.out.println("\n===============\n");
    }

    public double getTaxaRendimento(){
        return taxaRendimento;
    }



}
