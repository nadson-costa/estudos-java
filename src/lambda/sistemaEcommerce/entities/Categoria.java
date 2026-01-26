package lambda.sistemaEcommerce.entities;

public enum Categoria {
    ELETRONICOS("Eletrônicos"),
    LIVROS("Livros"),
    ROUPAS("Roupas"),
    ALIMENTOS("Alimentos"),
    ESPORTES("Esportes");

    private String descricao;

    Categoria(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
