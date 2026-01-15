package exceptions.sistemaBancario.application;

import exceptions.sistemaBancario.entities.Conta;
import exceptions.sistemaBancario.entities.ContaCorrente;
import exceptions.sistemaBancario.entities.ContaPoupanca;
import exceptions.sistemaBancario.exceptions.*;
import exceptions.sistemaBancario.services.Banco;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Banco banco = new Banco();
        Scanner sc = new Scanner(System.in);
        int opcao;

        while(true){
            System.out.println("\n==== SISTEMA BANCÁRIO ====");
            System.out.println("1. Criar conta corrente");
            System.out.println("2. Criar conta poupança");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Transferir");
            System.out.println("6. Consultar saldo");
            System.out.println("7. Exibir extrato");
            System.out.println("8. Render juros(Poupança)");
            System.out.println("9. Listar todas as contas");
            System.out.println("10. Sair");
            System.out.println("==========================");
            System.out.print("-> Digite uma opção: ");
            opcao = sc.nextInt();

            if(opcao==10){
                System.out.println("Até logo!");
                sc.close();
                break;
            }

            switch(opcao){
                case 1:
                    try{
                        sc.nextLine();

                        System.out.print("-> Digite o número da conta: ");
                        String numeroConta = sc.nextLine();

                        System.out.print("-> Digite o nome do títular: ");
                        String titular = sc.nextLine();

                        System.out.print("-> Digite o limite do cheque especial: R$ ");
                        double limite = sc.nextDouble();

                        ContaCorrente cc = new ContaCorrente(numeroConta, titular, limite);
                        banco.adicionarConta(cc);

                    } catch(IllegalArgumentException e){
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 2:
                    try{
                        sc.nextLine();

                        System.out.print("-> Digite o número da conta: ");
                        String numeroConta = sc.nextLine();

                        System.out.print("-> Digite o nome do títular: ");
                        String titular = sc.nextLine();

                        System.out.print("-> Digite a taxa de rendimento (ex: 0.005): ");
                        double taxaRendimento = sc.nextDouble();

                        ContaPoupanca cp = new ContaPoupanca(numeroConta, titular, taxaRendimento);
                        banco.adicionarConta(cp);

                    } catch(IllegalArgumentException e){
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        sc.nextLine();

                        System.out.print("-> Digite o número da conta: ");
                        String numeroConta = sc.nextLine();

                        System.out.print("-> Digite o valor a depositar: R$ ");
                        double valor = sc.nextDouble();

                        Conta conta = banco.buscarConta(numeroConta);
                        conta.depositar(valor);

                    } catch(ContaNaoEncontradaException e) {
                        System.out.println("Erro: " + e.getMessage());
                    } catch(ValorInvalidoException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 4:
                    try{
                        sc.nextLine();

                        System.out.print("-> Digite o número da conta: ");
                        String numeroConta = sc.nextLine();

                        System.out.print("-> Digite o valor a sacar: R$ ");
                        double valor = sc.nextDouble();

                        Conta conta = banco.buscarConta(numeroConta);
                        conta.sacar(valor);

                    } catch(ContaNaoEncontradaException e) {
                        System.out.println("Erro: " + e.getMessage());
                    } catch(ValorInvalidoException e) {
                        System.out.println("Erro: " + e.getMessage());
                    } catch(SaldoInsuficienteException e){
                        System.out.println("Erro: " + e.getMessage());
                    } catch(LimiteExcedidoException e){
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 5:
                    try{
                        sc.nextLine();

                        System.out.print("-> Número da conta de origem: ");
                        String numeroOrigem = sc.nextLine();

                        System.out.print("-> Número da conta de destino: ");
                        String numeroDestino = sc.nextLine();

                        System.out.print("-> Digite o valor: R$ ");
                        double valor = sc.nextDouble();

                        banco.transferir(numeroOrigem, numeroDestino, valor);

                    } catch(ContaNaoEncontradaException e) {
                        System.out.println("Erro: " + e.getMessage());
                    } catch(ValorInvalidoException e) {
                        System.out.println("Erro: " + e.getMessage());
                    } catch(SaldoInsuficienteException e){
                        System.out.println("Erro: " + e.getMessage());
                    } catch(LimiteExcedidoException e){
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 6:
                    try{
                        sc.nextLine();

                        System.out.print("-> Número da conta: ");
                        String numeroConta = sc.nextLine();

                        Conta conta = banco.buscarConta(numeroConta);
                        conta.consultarSaldo();

                    } catch(ContaNaoEncontradaException e){
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 7:
                    try{
                        sc.nextLine();

                        System.out.print("-> Número da conta: ");
                        String numeroConta = sc.nextLine();

                        Conta conta = banco.buscarConta(numeroConta);
                        conta.exibirExtrato();

                    } catch(ContaNaoEncontradaException e){
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 8:
                    try{
                        sc.nextLine();

                        System.out.print("-> Número da conta: ");
                        String numeroConta = sc.nextLine();

                        Conta conta = banco.buscarConta(numeroConta);

                        if(conta instanceof ContaPoupanca){
                            ContaPoupanca poupanca = (ContaPoupanca) conta;
                            poupanca.renderJuros();
                        } else {
                            System.out.println("-> Erro: Esta conta não é poupanca!");
                        }

                    } catch(ContaNaoEncontradaException e){
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 9:
                    banco.listarContas();
                    break;

                default:
                    System.out.println("-> Opção inválida!");
            }
        }
    }
}