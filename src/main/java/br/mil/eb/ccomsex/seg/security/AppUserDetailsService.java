package br.mil.eb.ccomsex.seg.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.mil.eb.ccomsex.seg.model.entity.Grupo;
import br.mil.eb.ccomsex.seg.model.entity.Usuario;
import br.mil.eb.ccomsex.seg.model.repository.UsuarioRepository;
import br.mil.eb.ccomsex.seg.util.cdi.CDIServiceLocator;

public class AppUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String nomeUsuario)
			throws UsernameNotFoundException {
		UsuarioRepository usuarioRepository = CDIServiceLocator
				.getBean(UsuarioRepository.class);
		Usuario usuario = usuarioRepository.buscarPorNome(nomeUsuario);

		UsuarioSistemaSecurity user = null;

		if (usuario != null) {
			user = new UsuarioSistemaSecurity(usuario, getGrupos(usuario));
		}

		return user;
	}

	private Collection<? extends GrantedAuthority> getGrupos(Usuario usuario) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();

		for (Grupo grupo : usuario.getGrupos()) {
			authorities.add(new SimpleGrantedAuthority(grupo.getNomeGrupo()
					.toUpperCase()));
		}

		return authorities;
	}

}
