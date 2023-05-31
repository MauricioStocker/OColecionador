package oColecionador.repository;

import java.util.List;

import javax.persistence.*;

import oColecionador.entity.MoedaEntity;

public class MoedaRepository {
	private static EntityManager em = Persistence.createEntityManagerFactory("o_colecionador").createEntityManager();

	public void inserir(MoedaEntity moedaEntity) {
		try {
			em.getTransaction().begin();
			em.persist(moedaEntity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao inserir os dados da Moeda.");
			System.out.println(e.getMessage());
		}
	}

	public void atualizar(MoedaEntity moedaEntity) {
		try {
			em.getTransaction().begin();
			em.merge(moedaEntity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao atualizar os dados da Moeda.");
			System.out.println(e.getMessage());
		}
	}

	public MoedaEntity pesquisaPeloId(Long id) {
		MoedaEntity moedaEntity = null;
		try {
			moedaEntity = em.find(MoedaEntity.class, id);
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar a Moeda pelo id");
		}
		return moedaEntity;
	}

	public void remover(Long id) {
		MoedaEntity moedaEntity = pesquisaPeloId(id);
		remover(moedaEntity);
	}

	public void remover(MoedaEntity moedaEntity) {
		try {
			em.getTransaction().begin();
			em.remove(moedaEntity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao remover a Moeda");
		}
	}

	@SuppressWarnings("unchecked")
	public List<MoedaEntity> listar() {
		List<MoedaEntity> moedaEntities = null;
		Query query = em.createQuery("SELECT f FROM MoedaEntity f");
		try {
			moedaEntities = query.getResultList();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao listar todas as moedas");
		}
		return moedaEntities;
	}

	// Implementar
	@SuppressWarnings("unchecked")
	public MoedaEntity pesquisaPeloNome(String titulo) {
		MoedaEntity moedaEntity = null;
		Query query = em.createQuery("SELECT f FROM MoedaEntity f WHERE f.titulo = :titulo");
		query.setParameter("titulo", titulo);
		try {
			List<MoedaEntity> moedaEntities = null;
			moedaEntities = query.getResultList();
			if (moedaEntities != null) {
				moedaEntity = moedaEntities.get(0);
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar uma moeda pelo titutlo");
		}
		return moedaEntity;
	}

}
