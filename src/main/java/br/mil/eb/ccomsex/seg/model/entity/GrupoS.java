package br.mil.eb.ccomsex.seg.model.entity;

public enum GrupoS {
	
	ADMINISTRADOR("Administrador do Sistema"), MENSAGEM("Gerente das Mensagens");

	private String descricao;

	GrupoS(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
