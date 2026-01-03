package poo.sistemaConcessionaria.entities;

public class Caminhao extends Veiculo{
    private double capacidadeCarga;
    private int numeroEixos;
    private String tipoCarroceria;

    public Caminhao(String marca, String modelo, int ano, double preco, String cor,
                     double capacidadeCarga, int numeroEixos, String tipoCarroceria){

        super(marca, modelo, ano, preco, cor);

        this.capacidadeCarga = capacidadeCarga;
        this.numeroEixos = numeroEixos;
        this.tipoCarroceria = tipoCarroceria;
    }

    public double calcularIPVA(){
        return preco * 0.015;
    }

    public void acelerar(){
        System.out.println("Caminhão acelerando...");
    }

    public void exibirInfo(){
        super.exibirInfo();
        System.out.println("Capacidade de carga " + capacidadeCarga);
        System.out.println("Número de eixos: " + numeroEixos);
        System.out.println("Tipo da carroceria: " + tipoCarroceria);
        System.out.println("==============================");
    }

}
