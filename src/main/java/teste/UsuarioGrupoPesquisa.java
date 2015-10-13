package teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.mil.eb.ccomsex.seg.model.entity.Grupo;
import br.mil.eb.ccomsex.seg.model.entity.Usuario;

public class UsuarioGrupoPesquisa {

	public static void main(String[] args) {
		
		EntityManagerFactory managerFactory = Persistence
				.createEntityManagerFactory("BDCCOMSEXPU");
		EntityManager manager = managerFactory.createEntityManager();

		Usuario usuario = new Usuario();
		usuario = manager.find(Usuario.class, 1L);
		System.out.println(usuario.getNomeUsuario());
		
		
		List<Grupo> grupos = usuario.getGrupos();
		
		for(Grupo g : grupos) {
			System.out.println(g.getNomeGrupo());
		}
		
		manager.close();
	}
}
