package br.mil.eb.ccomsex.seg.model.entity;

public enum StatusUsuario {

	ATIVO("Ativo"), INATIVO("Inativo");

	private String descricao;

	StatusUsuario(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
