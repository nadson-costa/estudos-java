package exceptions.sistemaBancario.services;

import exceptions.sistemaBancario.entities.Conta;
import exceptions.sistemaBancario.exceptions.*;
import java.util.ArrayList;

public class Banco {
    private ArrayList<Conta> contas = new ArrayList<>();


    public void adicionarConta(Conta conta){
        contas.add(conta);
        System.out.println(">> Conta adicionada com sucesso!");
    }

    public Conta buscarConta(String numeroConta) throws ContaNaoEncontradaException {
        for(Conta conta : contas){
            if(conta.getNumeroConta().equalsIgnoreCase(numeroConta)){
                return conta;
            }
        }
        throw new ContaNaoEncontradaException("-> ERRO: A conta não foi encontrada!");
    }

    public void listarContas(){
        if(contas.isEmpty()){
            System.out.println(">> Nenhuma conta registrada!");
            return;
        }
        System.out.println("**** LISTA DE CONTAS ****");
        for(Conta conta : contas){
            conta.exibirExtrato();
        }
    }

    public void transferir(String numeroOrigem, String numeroDestino, double valor)
            throws SaldoInsuficienteException, ValorInvalidoException, ContaNaoEncontradaException, LimiteExcedidoException{

        Conta origem = buscarConta(numeroOrigem);
        Conta destino = buscarConta(numeroDestino);

        if(valor <= 0){
            throw new ValorInvalidoException("-> ERRO: Valor deve ser maior que zero!");
        }

        origem.sacar(valor);
        destino.depositar(valor);

        System.out.println(">> Transferência realizada com sucesso!");

    }

}

