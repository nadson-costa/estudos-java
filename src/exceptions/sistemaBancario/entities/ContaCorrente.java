package exceptions.sistemaBancario.entities;

import exceptions.sistemaBancario.entities.Conta;
import exceptions.sistemaBancario.exceptions.*;

public class ContaCorrente extends Conta {
    private double limiteChequeEspecial;

    public ContaCorrente(String numeroConta, String titular, double limiteChequeEspecial){
        super(numeroConta, titular);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException, LimiteExcedidoException {
        if(valor<=0){
            throw new ValorInvalidoException("-> ERRO: O valor deve ser maior que zero!");
        }
        double valorDisponivelTotal = saldo + limiteChequeEspecial;
        if(valor > valorDisponivelTotal){
            throw new LimiteExcedidoException("-> ERRO: O valor excede o limite!");
        }
        if(saldo < 0){
            System.out.println(">> Saque de R$ " + valor + " realizado (usando cheque especial)");
        } else {
            System.out.println(">> Saque de R$ " + valor + " realizado!");
        }
    }

    @Override
    public void exibirExtrato(){
        super.exibirExtrato();
        System.out.println("Limite do cheque especial: R$ " + limiteChequeEspecial);
        System.out.println("Saldo disponível total: R$ " + getValorDisponivelTotal());
        System.out.println("\n===============\n");
    }

    public double getValorDisponivelTotal(){
        return saldo + limiteChequeEspecial;
    }

    public double getLimiteChequeEspecial(){
        return limiteChequeEspecial;
    }
}
