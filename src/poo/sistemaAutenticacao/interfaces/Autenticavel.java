package poo.sistemaAutenticacao.interfaces;

public interface Autenticavel {
    boolean autenticar(String senha);
    void login();
    void logout();
}
