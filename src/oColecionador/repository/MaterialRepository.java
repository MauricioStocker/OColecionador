package oColecionador.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;


import oColecionador.entity.Material;

public class MaterialRepository {
	private static EntityManager em = Persistence.createEntityManagerFactory("o_colecionador").createEntityManager();

	public void inserir(Material materia) {
		try {
			em.getTransaction().begin();
			em.persist(materia);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao inserir os dados do fabricante.");
			System.out.println(e.getMessage());
		}
	}

	public void atualizar(Material material) {
		try {
			em.getTransaction().begin();
			em.merge(material);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao atualizar os dados do fabricante.");
			System.out.println(e.getMessage());
		}
	}

	public Material pesquisaPeloId(Long id) {
		Material material = null;
		try {
			material = em.find(Material.class, id);
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar o fabricante pelo id");
		}
		return material;
	}

	public void remover(Long id) {
		Material material = pesquisaPeloId(id);
		remover(material);
	}

	public void remover(Material material) {
		try {
			em.getTransaction().begin();
			em.remove(material);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao remover o fabricante");
		}
	}

	@SuppressWarnings("unchecked")
	public List<Material> listar() {
		List<Material> materials = null;
		Query query = em.createQuery("SELECT f FROM Material f");
		try {
			materials = query.getResultList();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao listar todos os fabricantes");
		}
		return materials;
	}

	// Implementar
	@SuppressWarnings("unchecked")
	public Material pesquisaPeloNome(String nome) {
		Material material = null;
		Query query = em.createQuery("SELECT f FROM Material f WHERE f.nome = :nome");
		query.setParameter("nome", nome);
		try {
			List<Material> materials = null;
			materials = query.getResultList();
			if (materials != null) {
				material = materials.get(0);
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar um fabricante pelo nome");
		}
		return material;
	}

}
