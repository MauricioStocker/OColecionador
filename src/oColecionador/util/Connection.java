package oColecionador.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("o_colecionador");

	public EntityManager getConection() {
		return emf.createEntityManager();
	}

}
