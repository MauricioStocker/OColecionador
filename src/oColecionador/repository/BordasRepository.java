package oColecionador.repository;

import java.util.List;

import javax.persistence.*;

import oColecionador.entity.BordasEntity;

public class BordasRepository {
	private static EntityManager em = Persistence.createEntityManagerFactory("o_colecionador").createEntityManager();

	public void inserir(BordasEntity bordasEntity) {
		try {
			em.getTransaction().begin();
			em.persist(bordasEntity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao inserir os dados da Borda.");
			System.out.println(e.getMessage());
		}
	}

	public void atualizar(BordasEntity bordasEntity) {
		try {
			em.getTransaction().begin();
			em.merge(bordasEntity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao atualizar os dados da Borda.");
			System.out.println(e.getMessage());
		}
	}

	public BordasEntity pesquisaPeloId(Long id) {
		BordasEntity bordasEntity = null;
		try {
			bordasEntity = em.find(BordasEntity.class, id);
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar a Borda pelo id");
		}
		return bordasEntity;
	}

	public void remover(Long id) {
		BordasEntity bordasEntity = pesquisaPeloId(id);
		remover(bordasEntity);
	}

	public void remover(BordasEntity bordasEntity) {
		try {
			em.getTransaction().begin();
			em.remove(bordasEntity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao remover a Borda");
		}
	}

	@SuppressWarnings("unchecked")
	public List<BordasEntity> listar() {
		List<BordasEntity> bordasEntity = null;
		Query query = em.createQuery("SELECT f FROM BordasEntity f");
		try {
			bordasEntity = query.getResultList();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao listar todas as Bordas");
		}
		return bordasEntity;
	}

	// Implementar
	@SuppressWarnings("unchecked")
	public BordasEntity pesquisaPeloNome(String nome) {
		BordasEntity bordasEntity = null;
		Query query = em.createQuery("SELECT f FROM BordasEntity f WHERE f.nome = :nome");
		query.setParameter("nome", nome);
		try {
			List<BordasEntity> bordass = null;
			bordass = query.getResultList();
			if (bordass != null) {
				bordasEntity = bordass.get(0);
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar uma Borda pelo nome");
		}
		return bordasEntity;
	}

}
