package oColecionador.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import oColecionador.entity.Pais;

public class PaisRepository {
	private static EntityManager em = Persistence.createEntityManagerFactory("o_colecionador").createEntityManager();

	public void inserir(Pais pais) {
		try {
			em.getTransaction().begin();
			em.persist(pais);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao inserir os dados do fabricante.");
			System.out.println(e.getMessage());
		}
	}

	public void atualizar(Pais pais) {
		try {
			em.getTransaction().begin();
			em.merge(pais);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao atualizar os dados do fabricante.");
			System.out.println(e.getMessage());
		}
	}

	public Pais pesquisaPeloId(Long id) {
		Pais pais = null;
		try {
			pais = em.find(Pais.class, id);
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar o fabricante pelo id");
		}
		return pais;
	}

	public void remover(Long id) {
		Pais pais = pesquisaPeloId(id);
		remover(pais);
	}

	public void remover(Pais pais) {
		try {
			em.getTransaction().begin();
			em.remove(pais);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao remover o fabricante");
		}
	}

	@SuppressWarnings("unchecked")
	public List<Pais> listar() {
		List<Pais> pais = null;
		Query query = em.createQuery("SELECT f FROM Pais f");
		try {
			pais = query.getResultList();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao listar todos os fabricantes");
		}
		return pais;
	}

	// Implementar
	@SuppressWarnings("unchecked")
	public Pais pesquisaPeloNome(String nome) {
		Pais pais = null;
		Query query = em.createQuery("SELECT f FROM Pais f WHERE f.nome = :nome");
		query.setParameter("nome", nome);
		try {
			List<Pais> pais2 = null;
			pais2 = query.getResultList();
			if (pais2 != null) {
				pais = pais2.get(0);
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar um fabricante pelo nome");
		}
		return pais;
	}

}
