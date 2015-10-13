package br.mil.eb.ccomsex.seg.model.repository.infra;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.mil.eb.ccomsex.seg.model.entity.Usuario;
import br.mil.eb.ccomsex.seg.model.repository.UsuarioRepository;

public class UsuarioRepositoryJPA implements UsuarioRepository {

	@Inject
	private EntityManager em;

	@Override
	public Usuario salvar(Usuario usuario) {
		return em.merge(usuario);
	}

	@Override
	public void excluir(Usuario usuario) {
		em.remove(usuario);
	}

	@Override
	public List<Usuario> listarTodos() {
		return em.createQuery("from Usuario order by nomeUsuario",
				Usuario.class).getResultList();
	}

	@Override
	public Usuario buscarPorId(Long id) {
		return em.find(Usuario.class, id);
	}

	@Override
	public Usuario buscarPorNome(String nome) {
		Usuario usuario = null;

		try {
			usuario = em
					.createQuery(
							"from Usuario where upper(nomeUsuario) = :pNome",
							Usuario.class)
					.setParameter("pNome", nome.toUpperCase())
					.getSingleResult();
		} catch (NoResultException e) {
			// nenhum usuário encontrado
		}

		return usuario;
	}

	@Override
	public Usuario buscarPorNomeSenha(String nome, String senha) {
		try {
			Query query = em
					.createQuery(
							"from Usuario where upper(nomeUsuario) = :pNome and senha = :pSenha",
							Usuario.class);
			query.setParameter("pNome", nome.toUpperCase());
			query.setParameter("pSenha", senha);
			return (Usuario) query.getSingleResult();
		} catch (NullPointerException e) {
			return null;
		}
	}

}
