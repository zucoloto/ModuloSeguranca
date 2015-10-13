package br.mil.eb.ccomsex.seg.controller.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.mil.eb.ccomsex.seg.model.entity.Grupo;
import br.mil.eb.ccomsex.seg.model.entity.Usuario;
import br.mil.eb.ccomsex.seg.model.service.GrupoService;
import br.mil.eb.ccomsex.seg.model.service.UsuarioService;
import br.mil.eb.ccomsex.seg.util.jsf.FacesUtil;
import br.mil.eb.ccomsex.seg.util.jsf.NegocioException;

@Named
@ViewScoped
public class GerenciadorPerfilBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioService usuarioService;

	private Usuario usuario;

	private List<Usuario> usuarios;

	@Inject
	private GrupoService grupoService;

	private Grupo grupoSelecionado;

	private List<Grupo> grupos;

	public GerenciadorPerfilBean() {
		limpar();
	}

	public void inicializar() {
		if (FacesUtil.isNotPostback()) {
			carregarUsuario();
			carregarGrupo();
		}
	}

	public void salvar() {
		try {
			this.usuario = usuarioService.salvar(this.usuario);
			FacesUtil.addInfoMessage("Registro salvo com sucesso!");
		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());
		}
	}

	public void adicionarPerfil() {
		usuario.getGrupos().add(grupoSelecionado);
		grupos.remove(grupoSelecionado);
	}
	
	public void excluirPerfil() {
		usuario.getGrupos().remove(grupoSelecionado);
		grupos.add(grupoSelecionado);
	}

	public void limpar() {
		this.usuario = new Usuario();
	}

	public void carregarUsuario() {
		usuarios = usuarioService.listarTodos();
	}

	public void carregarGrupo() {
		grupos = grupoService.listarTodos();
		
		for(Grupo g : usuario.getGrupos()) {
			grupos.remove(g);
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public Grupo getGrupoSelecionado() {
		return grupoSelecionado;
	}

	public void setGrupoSelecionado(Grupo grupoSelecionado) {
		this.grupoSelecionado = grupoSelecionado;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

}
