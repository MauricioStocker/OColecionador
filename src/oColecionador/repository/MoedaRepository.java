package oColecionador.repository;

import java.util.List;

import javax.persistence.*;

import oColecionador.entity.Moeda;

public class MoedaRepository {
	private static EntityManager em = Persistence.createEntityManagerFactory("o_colecionador").createEntityManager();

	public void inserir(Moeda moeda) {
		try {
			em.getTransaction().begin();
			em.persist(moeda);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao inserir os dados do fabricante.");
			System.out.println(e.getMessage());
		}
	}

	public void atualizar(Moeda moeda) {
		try {
			em.getTransaction().begin();
			em.merge(moeda);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao atualizar os dados do fabricante.");
			System.out.println(e.getMessage());
		}
	}

	public Moeda pesquisaPeloId(Long id) {
		Moeda moeda = null;
		try {
			moeda = em.find(Moeda.class, id);
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar o fabricante pelo id");
		}
		return moeda;
	}

	public void remover(Long id) {
		Moeda moeda = pesquisaPeloId(id);
		remover(moeda);
	}

	public void remover(Moeda moeda) {
		try {
			em.getTransaction().begin();
			em.remove(moeda);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao remover o fabricante");
		}
	}

	@SuppressWarnings("unchecked")
	public List<Moeda> listar() {
		List<Moeda> moedas = null;
		Query query = em.createQuery("SELECT f FROM Moeda f");
		try {
			moedas = query.getResultList();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao listar todos os fabricantes");
		}
		return moedas;
	}

	// Implementar
	@SuppressWarnings("unchecked")
	public Moeda pesquisaPeloNome(String titulo) {
		Moeda moeda = null;
		Query query = em.createQuery("SELECT f FROM Moeda f WHERE f.titulo = :titulo");
		query.setParameter("titulo", titulo);
		try {
			List<Moeda> moedas = null;
			moedas = query.getResultList();
			if (moedas != null) {
				moeda = moedas.get(0);
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar um fabricante pelo nome");
		}
		return moeda;
	}

}
