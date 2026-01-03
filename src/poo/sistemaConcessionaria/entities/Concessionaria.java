package poo.sistemaConcessionaria.entities;

import java.util.ArrayList;

public class Concessionaria {
    private String nome;
    private ArrayList<Veiculo> veiculos = new ArrayList<>();

    public Concessionaria(String nome){
        this.nome = nome;
    }

    public void adicionarVeiculo(Veiculo v){
        veiculos.add(v);

    }

    public void listarVeiculos(){
        if(veiculos.isEmpty()){
            System.out.println("=== NENHUM VEÍCULO ENCONTRADO ===");
            return;
        }else{
            System.out.println("=== LISTA DE VEÍCULOS ===");
            for(Veiculo veiculo : veiculos){
                veiculo.exibirInfo();
            }

        }
    }

    public void listarPorTipo(String tipo){
        System.out.println("=== LISTA DO TIPO: " + tipo + " ===");
        boolean encontrou = false;

        for(Veiculo veiculo : veiculos){
            if(tipo.equals("Carro") && veiculo instanceof Carro){
                veiculo.exibirInfo();
                encontrou = true;
            }else if(
                    tipo.equals("Moto") && veiculo instanceof Moto){
                veiculo.exibirInfo();
                encontrou = true;
            }else if(
                    tipo.equals("Caminhao") && veiculo instanceof Caminhao){
                veiculo.exibirInfo();
                encontrou = true;
            }
        }
        if(!encontrou){
            System.out.println("Nenhum veículo desse tipo foi encontrado!");
        }
    }

    public Veiculo buscarPorModelo(String modelo){
        for(Veiculo veiculo : veiculos){
            if(veiculo.getModelo().equalsIgnoreCase(modelo)){
                return veiculo;
            }
        }
        return null;
    }

    public double calcularValorTotalEstoque(){
        double valorTotal = 0.00;
        for(Veiculo veiculo : veiculos){
            valorTotal += veiculo.getPreco();
        }
        return valorTotal;
    }

    public double calcularIPVATotal(){
        double valorIPVATotal = 0.00;
        for(Veiculo veiculo : veiculos){
            valorIPVATotal += veiculo.calcularIPVA();

        }
        return valorIPVATotal;
    }

    public Veiculo veiculoMaisCaro(){
        if(veiculos.isEmpty()) {
            return null;
        }
        Veiculo maisCaro = veiculos.get(0);
        for(Veiculo veiculo : veiculos){
            if(veiculo.getPreco() > maisCaro.getPreco()){
                maisCaro = veiculo;
            }
        }
        return maisCaro;
    }

    public Veiculo veiculoMaisBarato(){
        Veiculo maisBarato = veiculos.get(0);
        for(Veiculo veiculo : veiculos){
            if(veiculo.getPreco() < maisBarato.getPreco()){
                maisBarato = veiculo;
            }
        }
        return maisBarato;
    }
}

