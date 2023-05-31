package oColecionador.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import oColecionador.entity.PaisEntity;

public class PaisRepository {
	private static EntityManager em = Persistence.createEntityManagerFactory("o_colecionador").createEntityManager();

	public void inserir(PaisEntity paisEntity) {
		try {
			em.getTransaction().begin();
			em.persist(paisEntity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao inserir os dados do Pais.");
			System.out.println(e.getMessage());
		}
	}

	public void atualizar(PaisEntity paisEntity) {
		try {
			em.getTransaction().begin();
			em.merge(paisEntity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao atualizar os dados do Pais.");
			System.out.println(e.getMessage());
		}
	}

	public PaisEntity pesquisaPeloId(Long id) {
		PaisEntity paisEntity = null;
		try {
			paisEntity = em.find(PaisEntity.class, id);
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar o Pais pelo id");
		}
		return paisEntity;
	}

	public void remover(Long id) {
		PaisEntity paisEntity = pesquisaPeloId(id);
		remover(paisEntity);
	}

	public void remover(PaisEntity paisEntity) {
		try {
			em.getTransaction().begin();
			em.remove(paisEntity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao remover o Pais");
		}
	}

	@SuppressWarnings("unchecked")
	public List<PaisEntity> listar() {
		List<PaisEntity> paisEntity = null;
		Query query = em.createQuery("SELECT f FROM PaisEntity f");
		try {
			paisEntity = query.getResultList();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao listar todos os Pais");
		}
		return paisEntity;
	}

	// Implementar
	@SuppressWarnings("unchecked")
	public PaisEntity pesquisaPeloNome(String nome) {
		PaisEntity paisEntity = null;
		Query query = em.createQuery("SELECT f FROM PaisEntity f WHERE f.nome = :nome");
		query.setParameter("nome", nome);
		try {
			List<PaisEntity> pais2 = null;
			pais2 = query.getResultList();
			if (pais2 != null) {
				paisEntity = pais2.get(0);
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar um Pais pelo nome");
		}
		return paisEntity;
	}

}
