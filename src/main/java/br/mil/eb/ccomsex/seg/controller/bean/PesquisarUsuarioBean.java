package br.mil.eb.ccomsex.seg.controller.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.mil.eb.ccomsex.seg.model.entity.Usuario;
import br.mil.eb.ccomsex.seg.model.service.UsuarioService;

@Named
@ViewScoped
public class PesquisarUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioService usuarioService;

	private Usuario usuarioSelecionado;
	private List<Usuario> usuarios;

	public void inicializar() {
		pesquisar();
	}

	public void pesquisar() {
		usuarios = usuarioService.listarTodos();
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	/*
	 * public void excluir() { usuarioService.excluir(usuarioSelecionado);
	 * usuarios.remove(usuarioSelecionado); FacesUtil.addInfoMessage("Usuario "
	 * + usuarioSelecionado.getNomeUsuario()() + " excluído com sucesso!"); }
	 */

}