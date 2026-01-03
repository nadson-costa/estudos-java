package poo.sistemaConcessionaria.entities;

public class Moto extends Veiculo{
    private int cilindradas;
    private String tipoPartida;
    private boolean temCarenagem;

    public Moto(String marca, String modelo, int ano, double preco, String cor,
                int cilindradas, String tipoPartida, boolean temCarenagem){

        super(marca, modelo, ano, preco, cor);

        this.cilindradas = cilindradas;
        this.tipoPartida = tipoPartida;
        this.temCarenagem = temCarenagem;
    }
    @Override
    public double calcularIPVA(){
        return preco * 0.02;
    }

    @Override
    public void acelerar(){
        System.out.println("Moto acelerando... RanDanDanDanDannnn");
    }

    @Override
    public void exibirInfo(){
        super.exibirInfo();
        System.out.println("Cilindradas: " + cilindradas);
        System.out.println("Tipo da partida: " + tipoPartida);
        System.out.println("Carenagem: " + (temCarenagem ? "Sim" : "Não"));
        System.out.println("==============================");
    }

}
