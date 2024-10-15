package br.com.techchallenge.flanelinha.Flanelinha.services;

import br.com.techchallenge.flanelinha.Flanelinha.model.Usuario;

import java.util.List;

public interface UsuarioService {
    public List<Usuario> buscarTodosUsuarios();
    public Usuario criarUsuario(Usuario usuario);
    public Usuario buscarUsuario(String idUsuario);
    public void atualizarUsuario(Usuario usuario);
    public void deletarUsuario(String idUsuario);
}
