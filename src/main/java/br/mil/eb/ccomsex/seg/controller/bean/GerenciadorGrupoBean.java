package br.mil.eb.ccomsex.seg.controller.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.mil.eb.ccomsex.seg.model.entity.Grupo;
import br.mil.eb.ccomsex.seg.model.service.GrupoService;
import br.mil.eb.ccomsex.seg.util.jsf.FacesUtil;
import br.mil.eb.ccomsex.seg.util.jsf.NegocioException;

@Named
@ViewScoped
public class GerenciadorGrupoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private GrupoService grupoService;

	private Grupo grupo;

	public GerenciadorGrupoBean() {
		limpar();
	}

	public void inicializar() {
		if (FacesUtil.isNotPostback()) {
			if (this.grupo == null) {
				limpar();
			}
		}
	}

	public void salvar() {
		try {
			this.grupo = grupoService.salvar(this.grupo);
			limpar();
			FacesUtil.addInfoMessage("Registro salvo com sucesso!");
		} catch (NegocioException ne) {
			FacesUtil.addErrorMessage(ne.getMessage());
		}
	}

	public void limpar() {
		this.grupo = new Grupo();
	}

	public boolean isEditando() {
		return this.grupo.getId() != null;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}
