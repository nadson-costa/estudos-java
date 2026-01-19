package collections.sistemaKanban.entities;

public enum Status {
    TODO("A fazer"),
    DOING("Em andamento"),
    DONE("Concluído");

    private String descricao;

    Status(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
