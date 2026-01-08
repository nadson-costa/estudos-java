package poo.sistemaAutenticacao.interfaces;

import poo.sistemaAutenticacao.entities.Usuario;

public interface Administravel {
    void adicionarUsuario(Usuario usuario);
    void removerUsuario(String nome);
    void listarUsuarios();
}
