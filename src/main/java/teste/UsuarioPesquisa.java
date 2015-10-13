package teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.mil.eb.ccomsex.seg.model.entity.Usuario;

public class UsuarioPesquisa {

	public static void main(String[] args) {
		
		EntityManagerFactory managerFactory = Persistence
				.createEntityManagerFactory("BDCCOMSEXPU");
		EntityManager manager = managerFactory.createEntityManager();

//		EntityTransaction trx = manager.getTransaction();
//		trx.begin();
		
		List<Usuario> usuarios = manager.createQuery("from Usuario order by nomeUsuario",
				Usuario.class).getResultList();
		
		for(Usuario u : usuarios) {
			System.out.println(u.getNomeUsuario());
		}
		
//		trx.commit();
		manager.close();
	}
}
