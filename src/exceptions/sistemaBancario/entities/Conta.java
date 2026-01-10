package exceptions.sistemaBancario.entities;

import exceptions.sistemaBancario.exceptions.*;

public class Conta {
    protected String numeroConta;
    protected String titular;
    protected double saldo;

    public Conta(String numeroConta, String titular) throws ContaNaoEncontradaException, ValorInvalidoException, SaldoInsuficienteException{

        validarNumeroConta(numeroConta);
        this.numeroConta = numeroConta;

        validarTitular(titular);
        this.titular = titular;

        this.saldo = 0;
    }

    private void validarNumeroConta(String numeroConta) {
        if(numeroConta == null || numeroConta.isEmpty()){
            throw new IllegalArgumentException("-> ERRO: Número da conta não pode ser vazio!");
        }
    }

    private void validarTitular(String titular){
        if(titular == null || titular.isEmpty()){
            throw new IllegalArgumentException("-> ERRO: O nome do títular não pode ser vazio");
        }
    }

    public void depositar(double valor){
        if(valor<=0){
            throw new ValorInvalidoException("-> ERRO: O valor deve ser maior que zero!");
        }
        this.saldo = this.saldo + valor;
        System.out.println(">> O valor de: R$ " + valor + " foi depositado com sucesso!");
    }

    public void sacar(double valor) throws SaldoInsuficienteException{
        if(valor<=0){
            throw new ValorInvalidoException("-> ERRO: O valor deve ser maior que zero!");
        }
        if(saldo < valor){
            throw new SaldoInsuficienteException("-> ERRO: Saldo insuficiente para realizar o saque!");
        }

        this.saldo = this.saldo - valor;
        System.out.println(">> Saque no valor R$ " + valor + " realizado com sucesso!");
    }

    public void consultarSaldo(){
        System.out.println(">> Saldo atual da conta: R$ " + saldo);
    }

    public void exibirExtrato(){
        System.out.println("\n===== EXTRATO =====");
        System.out.println("Número da conta: " + numeroConta);
        System.out.println("Títular: " + titular);
        System.out.println("Saldo: " + saldo);
        System.out.println("===============\n");
    }

    public String getNumeroConta(){
        return numeroConta;
    }

    public String getTitular(){
        return titular;
    }

    public double getSaldo(){
        return saldo;
    }

}
