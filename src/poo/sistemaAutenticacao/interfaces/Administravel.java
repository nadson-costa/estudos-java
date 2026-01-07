package poo.sistemaAutenticacao.interfaces;

public interface Administravel {
    void adicionarUsuario(Usuario usuario);
    void removerUsuario(String nome);
    void listarUsuarios();
}
