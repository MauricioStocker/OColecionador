package oColecionador.repository;

import java.util.List;

import javax.persistence.*;

import oColecionador.entity.Bordas;
import oColecionador.entity.Colecao;
import oColecionador.entity.TipoTransacao;

public class TipoRepository {
	private static EntityManager em = Persistence.createEntityManagerFactory("o_colecionador").createEntityManager();

	public void inserir(TipoTransacao tipo) {
		try {
			em.getTransaction().begin();
			em.persist(tipo);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao inserir os dados do fabricante.");
			System.out.println(e.getMessage());
		}
	}

	public void atualizar(TipoTransacao tipo) {
		try {
			em.getTransaction().begin();
			em.merge(tipo);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao atualizar os dados do fabricante.");
			System.out.println(e.getMessage());
		}
	}

	public TipoTransacao pesquisaPeloId(Long id) {
		TipoTransacao tipo = null;
		try {
			tipo = em.find(TipoTransacao.class, id);
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar o fabricante pelo id");
		}
		return tipo;
	}

	public void remover(Long id) {
		TipoTransacao tipo = pesquisaPeloId(id);
		remover(tipo);
	}

	public void remover(TipoTransacao tipo) {
		try {
			em.getTransaction().begin();
			em.remove(tipo);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao remover o fabricante");
		}
	}

	@SuppressWarnings("unchecked")
	public List<TipoTransacao> listar() {
		List<TipoTransacao> tipo = null;
		Query query = em.createQuery("SELECT f FROM TipoTransacao f");
		try {
			tipo = query.getResultList();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao listar todos os fabricantes");
		}
		return tipo;
	}

	// Implementar
	@SuppressWarnings("unchecked")
	public TipoTransacao pesquisaPeloNome(String nome) {
		TipoTransacao tipo = null;
		Query query = em.createQuery("SELECT f FROM TipoTransacao f WHERE f.nome = :nome");
		query.setParameter("nome", nome);
		try {
			List<TipoTransacao> tipos = null;
			tipos = query.getResultList();
			if (tipos != null) {
				tipo = tipos.get(0);
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar um fabricante pelo nome");
		}
		return tipo;
	}
	


}
