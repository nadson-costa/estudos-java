package poo.sistemaConcessionaria.entities;

public class Carro extends Veiculo {
    private int numeroPortas;
    private String tipoCarroceria;
    private boolean arCondicionado;

    public Carro(String marca, String modelo, int ano, double preco, String cor,
                 int numeroPortas, String tipoCarroceria, boolean arCondicionado){
        super(marca, modelo, ano, preco, cor);
        this.numeroPortas = numeroPortas;
        this.tipoCarroceria = tipoCarroceria;
        this.arCondicionado = arCondicionado;
    }

    @Override
    public double calcularIPVA(){
        if(tipoCarroceria.equalsIgnoreCase("SUV")){
            return preco * 0.045;
        }
        return preco * 0.04;
    }

    @Override
    public void acelerar(){
        System.out.println("Carro acelerando suavemente...");
    }

    @Override
    public void exibirInfo(){
        super.exibirInfo();
        System.out.println("Número de portas: " + numeroPortas);
        System.out.println("Tipo: " + tipoCarroceria);
        System.out.println("Ar condicionado: " + (arCondicionado ? "Sim" : "Não"));
        System.out.println("==============================");
    }
}