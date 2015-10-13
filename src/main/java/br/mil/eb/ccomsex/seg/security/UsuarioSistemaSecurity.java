package br.mil.eb.ccomsex.seg.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import br.mil.eb.ccomsex.seg.model.entity.Usuario;

public class UsuarioSistemaSecurity extends User {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	public UsuarioSistemaSecurity(Usuario usuario,
			Collection<? extends GrantedAuthority> authorities) {
		super(usuario.getNomeUsuario(), usuario.getSenha(), authorities);
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

}
