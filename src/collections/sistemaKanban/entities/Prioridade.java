package collections.sistemaKanban.entities;

public enum Prioridade {
    BAIXA(1, "Baixa"),
    MEDIA(2, "Média"),
    ALTA(3, "Alta");

    private int nivel;
    private String descricao;

    Prioridade(int nivel, String descricao){
        this.nivel = nivel;
        this.descricao = descricao;
    }

    public int getNivel(){
        return nivel;
    }

    public String getDescricao(){
        return descricao;
    }
}
