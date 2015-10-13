package br.mil.eb.ccomsex.seg.controller.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.mil.eb.ccomsex.seg.model.entity.StatusUsuario;
import br.mil.eb.ccomsex.seg.model.entity.Usuario;
import br.mil.eb.ccomsex.seg.model.service.UsuarioService;
import br.mil.eb.ccomsex.seg.util.jsf.FacesUtil;
import br.mil.eb.ccomsex.seg.util.jsf.NegocioException;

@Named
@ViewScoped
public class GerenciadorUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioService usuarioService;

	private Usuario usuario;

	public GerenciadorUsuarioBean() {
		limpar();
	}

	public void inicializar() {
		if (FacesUtil.isNotPostback()) {
			if (this.usuario == null) {
				limpar();
			}
		}
	}

	public void salvar() {
		try {
			this.usuario = usuarioService.salvar(this.usuario);
			limpar();
			FacesUtil.addInfoMessage("Registro salvo com sucesso!");
		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());
		}
	}

	public void limpar() {
		this.usuario = new Usuario();
	}

	public boolean isEditando() {
		return this.usuario.getId() != null;
	}

	public StatusUsuario[] getStatusUsuario() {
		return StatusUsuario.values();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
