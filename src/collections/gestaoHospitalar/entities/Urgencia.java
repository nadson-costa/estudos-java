package collections.gestaoHospitalar.entities;

public enum Urgencia {
    BAIXA(1, "Baixa"),
    MEDIA(2, "Média"),
    ALTA(3, "Alta"),
    EMERGENCIA(4, "Emergência");

    private int nivel;
    private String descricao;

    Urgencia(int nivel, String descricao){
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
