package br.mil.eb.ccomsex.seg.model.repository;

import java.util.List;

import br.mil.eb.ccomsex.seg.model.entity.Usuario;

public interface UsuarioRepository {

	public Usuario salvar(Usuario usuario);

	public void excluir(Usuario usuario);

	public List<Usuario> listarTodos();

	public Usuario buscarPorId(Long id);
	
	public Usuario buscarPorNome(String nome);
	
	public Usuario buscarPorNomeSenha(String nome, String senha);
}
