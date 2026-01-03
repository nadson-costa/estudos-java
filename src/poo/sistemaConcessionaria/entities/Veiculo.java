package poo.sistemaConcessionaria.entities;

public class Veiculo {
    protected String marca;
    protected String modelo;
    protected int ano;
    protected double preco;
    protected String cor;

    public Veiculo(String marca, String modelo, int ano, double preco, String cor){
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.preco = preco;
        this.cor = cor;
    }

    public double calcularIPVA(){
        return preco * 0.04;
    }

    public void exibirInfo(){
        System.out.println();
        System.out.println("=== INFORMAÇÕES DO VEÍCULO ===");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Preço: " + preco);
        System.out.println("Cor: " + cor);
        System.out.println("==============================");
        System.out.println();
    }

    public void acelerar(){
        System.out.println("Veículo acelerando");
    }

    public String getMarca(){
        return marca;
    }

    public String getModelo(){
        return modelo;
    }

    public int getAno(){
        return ano;
    }

    public double getPreco(){
        return preco;
    }

    public String getCor(){
        return cor;
    }
}


