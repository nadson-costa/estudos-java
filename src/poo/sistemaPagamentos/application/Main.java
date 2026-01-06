package poo.sistemaPagamentos.application;

import poo.sistemaPagamentos.entities.*;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        SistemaPagamento sistema = new SistemaPagamento();
        int opcao;

        while(true){
            System.out.println();
            System.out.println("=== SISTEMA DE PAGAMENTOS ===");
            System.out.println("1 - Processar pagamento com cartão de crédito");
            System.out.println("2 - Processar pagamento com PIX");
            System.out.println("3 - Processar pagamento com boleto");
            System.out.println("4 - Listar todos os pagamentos");
            System.out.println("5 - Listar por tipo de pagamento");
            System.out.println("6 - Calcular total arrecadado");
            System.out.println("7 - Calcular total de taxas cobradas");
            System.out.println("8 - Buscar pagamento por descrição");
            System.out.println("9 - Sair");
            System.out.println("========================================");
            System.out.println();
            System.out.println("-> Digite uma opção: ");
            opcao = sc.nextInt();


            if(opcao==9){
                System.out.println("Até mais!");
                break;
            }

            switch(opcao){
                case 1:
                    sc.nextLine();
                    System.out.println("Digite o valor do pagamento: ");
                    double valor = sc.nextDouble();

                    sc.nextLine();
                    System.out.println("Digite a descrição: ");
                    String descricao = sc.nextLine();

                    System.out.println("Digite a data do pagamento(DD/MM/AAAA): ");
                    String dataPagamento = sc.nextLine();

                    System.out.println("Digite os 4 últimos dígitos do cartão: ");
                    String numeroCartao = sc.nextLine();

                    System.out.println("Digite o número de parcelas: ");
                    int numeroParcelas = sc.nextInt();

                    sc.nextLine();
                    System.out.println("Digite a bandeira do cartão: ");
                    String bandeira = sc.nextLine();

                    CartaoCredito cartao = new CartaoCredito(valor, descricao, dataPagamento,
                            numeroCartao, numeroParcelas, bandeira);

                    cartao.processar();
                    sistema.adicionarPagamento(cartao);
                    break;


                case 2:
                    sc.nextLine();
                    System.out.println("Digite o valor: ");
                    valor = sc.nextDouble();

                    sc.nextLine();
                    System.out.println("Digite a descrição do pagamento: ");
                    descricao = sc.nextLine();

                    System.out.println("Digite a data do pagamento(DD/MM/AAAA: ");
                    dataPagamento = sc.nextLine();

                    System.out.println("Digite a chave PIX: ");
                    String chavePix = sc.nextLine();

                    PIX pix = new PIX(valor, descricao, dataPagamento, chavePix);

                    pix.processar();
                    sistema.adicionarPagamento(pix);

                    break;

                case 3:
                    sc.nextLine();

                    System.out.println("Digite o valor: ");
                    valor = sc.nextDouble();

                    sc.nextLine();
                    System.out.println("Digite a descrição do pagamento: ");
                    descricao = sc.nextLine();

                    System.out.println("Digite a data do pagamento: ");
                    dataPagamento = sc.nextLine();

                    System.out.println("Digite a data de vencimento do boleto: ");
                    String dataVencimento = sc.nextLine();

                    Boleto boleto = new Boleto(valor, descricao, dataPagamento, dataVencimento);

                    boleto.processar();
                    sistema.adicionarPagamento(boleto);

                    break;

                case 4:
                    sistema.listarPagamentos();
                    break;

                case 5:
                    sc.nextLine();

                    System.out.println("==== OPÇÕES DE PAGAMENTOS ====");
                    System.out.println("1 - PIX");
                    System.out.println("2 - Cartão de Crédito");
                    System.out.println("3 - Boleto");
                    System.out.println("==============================");
                    System.out.println("-> Digite uma opção: ");
                    int opcaoTipo = sc.nextInt();

                    if(opcaoTipo==1){
                        String tipo = "PIX";
                        sistema.listarPorTipo(tipo);
                    } else if(opcaoTipo==2){
                        String tipo = "Cartão de Crédito";
                        sistema.listarPorTipo(tipo);
                    } else if(opcaoTipo==3){
                        String tipo = "Boleto";
                        sistema.listarPorTipo(tipo);
                    }

                    break;

                case 6:
                    double totalArrecadado = sistema.calcularTotalArrecadado();
                    System.out.printf("Total arrecadado: R$ %.2f\n", totalArrecadado);
                    break;

                case 7:
                    double totalTaxas = sistema.calcularTotalTaxas();
                    System.out.printf("Total de taxas: R$ %.2f\n", totalTaxas);
                    break;

                case 8:
                    sc.nextLine();
                    System.out.println("Digite a descrição do pagamento: ");
                    descricao = sc.nextLine();

                    Pagamento encontrado = sistema.buscarPorDescricao(descricao);

                    if(encontrado == null){
                        System.out.println("Pagamento não encontrado!");
                    }else{
                        encontrado.exibirDetalhes();
                    }

                    break;
            }
        }
    }
}
