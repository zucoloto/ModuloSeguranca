package br.mil.eb.ccomsex.seg.security;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Named
@RequestScoped
public class SegurancaBean {

	public String getNomeUsuario() {
		String nome = null;

		UsuarioSistemaSecurity usuarioLogado = getUsuarioLogado();

		if (usuarioLogado != null) {
			nome = usuarioLogado.getUsuario().getNomeUsuario();
		}

		return nome;
	}

	private UsuarioSistemaSecurity getUsuarioLogado() {
		UsuarioSistemaSecurity usuario = null;

		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) FacesContext
				.getCurrentInstance().getExternalContext().getUserPrincipal();

		if (auth != null && auth.getPrincipal() != null) {
			usuario = (UsuarioSistemaSecurity) auth.getPrincipal();
		}

		return usuario;
	}
}
