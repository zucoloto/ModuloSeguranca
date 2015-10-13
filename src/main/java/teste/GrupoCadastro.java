package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.mil.eb.ccomsex.seg.model.entity.Grupo;

public class GrupoCadastro {

	public static void main(String[] args) {
		EntityManagerFactory managerFactory = Persistence
				.createEntityManagerFactory("BDCCOMSEXPU");
		EntityManager manager = managerFactory.createEntityManager();

		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		Grupo grupo = new Grupo();
		grupo.setNomeGrupo("USUARIO");
		grupo.setDescricao("Usuário do Sistema");
		
		manager.persist(grupo);

		trx.commit();
		manager.close();
	}
}
