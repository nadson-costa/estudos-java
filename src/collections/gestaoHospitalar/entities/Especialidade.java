package collections.gestaoHospitalar.entities;

public enum Especialidade {
    CARDIOLOGIA("Cardiologia"),
    PEDIATRIA("Pediatria"),
    ORTOPEDIA("Ortopedia"),
    DERMATOLOGIA("Dermatologia"),
    NEUROLOGIA("Neurologia");

    private String descricao;

    Especialidade(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
