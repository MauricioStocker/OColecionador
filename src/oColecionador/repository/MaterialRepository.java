package oColecionador.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;


import oColecionador.entity.MaterialEntity;

public class MaterialRepository {
	private static EntityManager em = Persistence.createEntityManagerFactory("o_colecionador").createEntityManager();

	public void inserir(MaterialEntity materia) {
		try {
			em.getTransaction().begin();
			em.persist(materia);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao inserir os dados do Material.");
			System.out.println(e.getMessage());
		}
	}

	public void atualizar(MaterialEntity materialEntity) {
		try {
			em.getTransaction().begin();
			em.merge(materialEntity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao atualizar os dados do Material.");
			System.out.println(e.getMessage());
		}
	}

	public MaterialEntity pesquisaPeloId(Long id) {
		MaterialEntity materialEntity = null;
		try {
			materialEntity = em.find(MaterialEntity.class, id);
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar o Material pelo id");
		}
		return materialEntity;
	}

	public void remover(Long id) {
		MaterialEntity materialEntity = pesquisaPeloId(id);
		remover(materialEntity);
	}

	public void remover(MaterialEntity materialEntity) {
		try {
			em.getTransaction().begin();
			em.remove(materialEntity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao remover o Material");
		}
	}

	@SuppressWarnings("unchecked")
	public List<MaterialEntity> listar() {
		List<MaterialEntity> materialEntities = null;
		Query query = em.createQuery("SELECT f FROM MaterialEntity f");
		try {
			materialEntities = query.getResultList();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao listar todos os Materiais");
		}
		return materialEntities;
	}

	// Implementar
	@SuppressWarnings("unchecked")
	public MaterialEntity pesquisaPeloNome(String nome) {
		MaterialEntity materialEntity = null;
		Query query = em.createQuery("SELECT f FROM MaterialEntity f WHERE f.nome = :nome");
		query.setParameter("nome", nome);
		try {
			List<MaterialEntity> materialEntities = null;
			materialEntities = query.getResultList();
			if (materialEntities != null) {
				materialEntity = materialEntities.get(0);
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar um Material pelo nome");
		}
		return materialEntity;
	}

}
