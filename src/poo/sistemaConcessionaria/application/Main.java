package poo.sistemaConcessionaria.application;
import poo.sistemaConcessionaria.entities.*;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Concessionaria concessionaria = new Concessionaria("JavaCars");
        int opcao;

        while(true){
            System.out.println();
            System.out.println("===== CONCESSIONÁRIA JAVACARS =====");
            System.out.println("1 - Cadastrar carro");
            System.out.println("2 - Cadastrar moto");
            System.out.println("3 - Cadastrar caminhão");
            System.out.println("4 - Listar todos veículos");
            System.out.println("5 - Listar por tipo");
            System.out.println("6 - Buscar por modelo");
            System.out.println("7 - Mostrar veículo mais caro");
            System.out.println("8 - Mostrar veículo mais barato");
            System.out.println("9 - Calcular valor total do estoque");
            System.out.println("10 - Calcular IPVA total");
            System.out.println("11 - Sair");
            System.out.println();
            System.out.println("-> Escolha uma opção: ");
            opcao = sc.nextInt();
            System.out.println("==================================");

            if(opcao==11){
                System.out.println("Até mais!");
                return;
            }

            switch(opcao){
                case 1:
                    sc.nextLine();

                    System.out.println("-> Digite a marca: ");
                    String marcaCarro = sc.nextLine();

                    System.out.println("-> Digite o modelo: ");
                    String modeloCarro = sc.nextLine();

                    System.out.println("-> Digite o ano: ");
                    int anoCarro = sc.nextInt();

                    System.out.println("-> Digite o preço: ");
                    double precoCarro = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("-> Digite a cor: ");
                    String corCarro = sc.nextLine();

                    System.out.println("-> Digite o número de portas: ");
                    int numeroPortas = sc.nextInt();
                    sc.nextLine();;

                    System.out.println("-> Digite o tipo da carroceria: ");
                    String tipoCarroceria = sc.nextLine();

                    System.out.println("-> Contem Ar Condicionado? (S/N):  ");
                    String respostaArCondicionado = sc.nextLine();

                    boolean arCondicionado = respostaArCondicionado.equalsIgnoreCase("S");


                    Carro novoCarro = new Carro(marcaCarro, modeloCarro, anoCarro, precoCarro,
                            corCarro, numeroPortas, tipoCarroceria, arCondicionado);

                    concessionaria.adicionarVeiculo(novoCarro);
                    break;

                case 2:
                    sc.nextLine();

                    System.out.println("-> Digite a marca: ");
                    String marcaMoto = sc.nextLine();

                    System.out.println("-> Digite o modelo: ");
                    String modeloMoto = sc.nextLine();

                    System.out.println("-> Digite o ano: ");
                    int anoMoto = sc.nextInt();

                    System.out.println("-> Digite o preço: ");
                    double precoMoto = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("-> Digite a cor: ");
                    String corMoto = sc.nextLine();

                    System.out.println("-> Digite as cilindradas: ");
                    int cilindradas = sc.nextInt();
                    sc.nextLine();

                    System.out.println("-> Digite o tipo de partida: ");
                    String tipoPartida = sc.nextLine();

                    System.out.println("-> Carenagem?(S/N): ");
                    String respostaTemCarenagem = sc.nextLine();
                    boolean temCarenagem = respostaTemCarenagem.equalsIgnoreCase("S");
                    sc.nextLine();


                    Moto novaMoto = new Moto(marcaMoto, modeloMoto, anoMoto, precoMoto,
                            corMoto, cilindradas, tipoPartida, temCarenagem);

                    concessionaria.adicionarVeiculo(novaMoto);
                    break;

                case 3:
                    sc.nextLine();
                    System.out.println("-> Digite a marca: ");
                    String marcaCaminhao = sc.nextLine();

                    System.out.println("-> Digite o modelo: ");
                    String modeloCaminhao = sc.nextLine();

                    System.out.println("-> Digite o ano: ");
                    int anoCaminhao = sc.nextInt();

                    System.out.println("-> Digite o preço: ");
                    double precoCaminhao = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("-> Digite a cor: ");
                    String corCaminhao = sc.nextLine();

                    System.out.println("-> CapacidadeCarga: ");
                    double capacidadeCarga = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("-> Número de eixos: ");
                    int numeroEixos = sc.nextInt();
                    sc.nextLine();

                    System.out.println("-> Tipo da carroceria: ");
                    String tipoCarroceriaCaminhao = sc.nextLine();

                    Caminhao novoCaminhao = new Caminhao(marcaCaminhao, modeloCaminhao, anoCaminhao, precoCaminhao, corCaminhao,
                            capacidadeCarga, numeroEixos, tipoCarroceriaCaminhao);

                    concessionaria.adicionarVeiculo(novoCaminhao);
                    break;

                case 4:
                    concessionaria.listarVeiculos();
                    break;

                case 5:
                    sc.nextLine();
                    System.out.println("Digite o tipo de veículos: ");
                    String tipo = sc.nextLine();

                    concessionaria.listarPorTipo(tipo);
                    break;

                case 6:
                    sc.nextLine();
                    System.out.println("Digite o nome do módelo: ");
                    String modelo = sc.nextLine();

                    Veiculo encontrado = concessionaria.buscarPorModelo(modelo);

                    if(encontrado==null){
                        System.out.println("Nenhum veículo encontrado!");
                    } else{
                        encontrado.exibirInfo();
                    }
                    break;

                case 7:
                    Veiculo caro = concessionaria.veiculoMaisCaro();

                    if(caro==null){
                        System.out.println("Nenhum veículo encontrado!");
                    } else{
                        System.out.println("== VEÍCULO MAIS CARO ==");
                        caro.exibirInfo();
                    }
                    break;

                case 8:
                    Veiculo barato = concessionaria.veiculoMaisBarato();
                    if(barato==null){
                        System.out.println("Nenhum veículo encontrado!");
                    } else{
                        System.out.println("== VEÍCULO MAIS BARATO ==");
                        barato.exibirInfo();
                    }
                    break;

                case 9:
                    double valorTotal = concessionaria.calcularValorTotalEstoque();
                    System.out.printf("-> VALOR TOTAL NO ESTOQUE: R$ %.2f\n", valorTotal);
                    break;

                case 10:
                    double totalIPVA = concessionaria.calcularIPVATotal();
                    System.out.printf("-> VALOR TOTAL DO IPVA: R$ %.2f\n", totalIPVA);
                    break;
            }


        }
    }

}
