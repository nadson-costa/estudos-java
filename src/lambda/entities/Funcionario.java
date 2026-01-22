package lambda.entities;

public class Funcionario {
    private String nome;
    private String cargo;
    private double salario;
    private int anosEmpresa;

    public Funcionario(String nome, String cargo, double salario, int anosEmpresa){
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.anosEmpresa = anosEmpresa;
    }

    public String getNome(){ return nome; }
    public String getCargo(){ return cargo; }
    public double getSalario(){ return salario; }
    public int getAnosEmpresa(){ return anosEmpresa; }

    @Override
    public String toString(){
        return nome + " - " + cargo;
    }
}