package oColecionador.repository;

import java.util.List;

import javax.persistence.*;

import oColecionador.entity.Bordas;

public class BordasRepository {
	private static EntityManager em = Persistence.createEntityManagerFactory("o_colecionador").createEntityManager();

	public void inserir(Bordas bordas) {
		try {
			em.getTransaction().begin();
			em.persist(bordas);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao inserir os dados do fabricante.");
			System.out.println(e.getMessage());
		}
	}

	public void atualizar(Bordas bordas) {
		try {
			em.getTransaction().begin();
			em.merge(bordas);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao atualizar os dados do fabricante.");
			System.out.println(e.getMessage());
		}
	}

	public Bordas pesquisaPeloId(Long id) {
		Bordas bordas = null;
		try {
			bordas = em.find(Bordas.class, id);
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar o fabricante pelo id");
		}
		return bordas;
	}

	public void remover(Long id) {
		Bordas bordas = pesquisaPeloId(id);
		remover(bordas);
	}

	public void remover(Bordas bordas) {
		try {
			em.getTransaction().begin();
			em.remove(bordas);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao remover o fabricante");
		}
	}

	@SuppressWarnings("unchecked")
	public List<Bordas> listar() {
		List<Bordas> bordas = null;
		Query query = em.createQuery("SELECT f FROM Bordas f");
		try {
			bordas = query.getResultList();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao listar todos os fabricantes");
		}
		return bordas;
	}

	// Implementar
	@SuppressWarnings("unchecked")
	public Bordas pesquisaPeloNome(String nome) {
		Bordas bordas = null;
		Query query = em.createQuery("SELECT f FROM Bordas f WHERE f.nome = :nome");
		query.setParameter("nome", nome);
		try {
			List<Bordas> bordass = null;
			bordass = query.getResultList();
			if (bordass != null) {
				bordas = bordass.get(0);
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar um fabricante pelo nome");
		}
		return bordas;
	}

}
