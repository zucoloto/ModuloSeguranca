package br.mil.eb.ccomsex.seg.controller.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.mil.eb.ccomsex.seg.model.entity.Grupo;
import br.mil.eb.ccomsex.seg.model.service.GrupoService;
import br.mil.eb.ccomsex.seg.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisarGrupoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private GrupoService grupoService;

	private Grupo grupoSelecionado;
	private List<Grupo> grupos;

	public void inicializar() {
		pesquisar();
	}

	public void pesquisar() {
		grupos = grupoService.listarTodos();
	}

	public void excluir() {
		grupoService.excluir(grupoSelecionado);
		grupos.remove(grupoSelecionado);
		FacesUtil.addInfoMessage("Grupo " + grupoSelecionado.getNomeGrupo()
				+ " excluído com sucesso!");
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
