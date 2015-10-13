package teste;

import br.mil.eb.ccomsex.seg.model.entity.Usuario;
import br.mil.eb.ccomsex.seg.model.repository.UsuarioRepository;
import br.mil.eb.ccomsex.seg.util.cdi.CDIServiceLocator;

public class UsuarioSenhaPesquisa {

	public static void main(String[] args) {
		
		/*EntityManagerFactory managerFactory = Persistence
				.createEntityManagerFactory("BDCCOMSEXPU");
		EntityManager manager = managerFactory.createEntityManager();
*/
//		EntityTransaction trx = manager.getTransaction();
//		trx.begin();
		
		/*Query query = manager.createQuery("from Usuario where upper(nomeUsuario) = :pNome and senha = :pSenha",
				Usuario.class);
		query.setParameter("pNome", "Zucoloto");
		query.setParameter("pSenha", "123");
		
		Usuario u = (Usuario) query.getSingleResult();*/
		
		UsuarioRepository rep = CDIServiceLocator.getBean(UsuarioRepository.class);
		Usuario u = rep.buscarPorId(1L);
		
		System.out.println(u.getIdentidade());
		
//		trx.commit();
//		manager.close();
	}
}
