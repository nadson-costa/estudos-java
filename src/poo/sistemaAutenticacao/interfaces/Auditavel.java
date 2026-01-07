package poo.sistemaAutenticacao.interfaces;

public interface Auditavel {
    void registrarAcao(String acao);
    void exibirHistorico();
}
