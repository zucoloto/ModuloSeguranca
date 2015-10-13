package br.mil.eb.ccomsex.seg.model.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.mil.eb.ccomsex.seg.model.entity.Usuario;
import br.mil.eb.ccomsex.seg.model.repository.UsuarioRepository;
import br.mil.eb.ccomsex.seg.util.jpa.Transactional;

public class UsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioRepository usuarioRepository;

	@Transactional
	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.salvar(usuario);
	}

//	@Transactional
//	public void excluir(Usuario usuario) {
//		usuarioRepository.excluir(usuario);
//	}

	public List<Usuario> listarTodos() {
		return usuarioRepository.listarTodos();
	}

	public Usuario buscarPorId(Long id) {
		return usuarioRepository.buscarPorId(id);
	}
}