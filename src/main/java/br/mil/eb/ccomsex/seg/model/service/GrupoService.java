package br.mil.eb.ccomsex.seg.model.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.mil.eb.ccomsex.seg.model.entity.Grupo;
import br.mil.eb.ccomsex.seg.model.repository.GrupoRepository;
import br.mil.eb.ccomsex.seg.util.jpa.Transactional;

public class GrupoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private GrupoRepository grupoRepository;

	@Transactional
	public Grupo salvar(Grupo grupo) {
		return grupoRepository.salvar(grupo);
	}

	@Transactional
	public void excluir(Grupo grupo) {
		grupoRepository.excluir(grupo);
	}

	public List<Grupo> listarTodos() {
		return grupoRepository.listarTodos();
	}

	public Grupo buscarPorId(Long id) {
		return grupoRepository.buscarPorId(id);
	}
}
