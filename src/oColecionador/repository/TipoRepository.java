package oColecionador.repository;

import java.util.List;

import javax.persistence.*;

import oColecionador.entity.BordasEntity;
import oColecionador.entity.ColecaoEntity;
import oColecionador.entity.TipoTransacaoEntity;

public class TipoRepository {
	private static EntityManager em = Persistence.createEntityManagerFactory("o_colecionador").createEntityManager();

	public void inserir(TipoTransacaoEntity tipo) {
		try {
			em.getTransaction().begin();
			em.persist(tipo);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao inserir os dados do Tipo.");
			System.out.println(e.getMessage());
		}
	}

	public void atualizar(TipoTransacaoEntity tipo) {
		try {
			em.getTransaction().begin();
			em.merge(tipo);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao atualizar os dados do Tipo.");
			System.out.println(e.getMessage());
		}
	}

	public TipoTransacaoEntity pesquisaPeloId(Long id) {
		TipoTransacaoEntity tipo = null;
		try {
			tipo = em.find(TipoTransacaoEntity.class, id);
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar o Tipo pelo id");
		}
		return tipo;
	}

	public void remover(Long id) {
		TipoTransacaoEntity tipo = pesquisaPeloId(id);
		remover(tipo);
	}

	public void remover(TipoTransacaoEntity tipo) {
		try {
			em.getTransaction().begin();
			em.remove(tipo);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao remover o Tipo");
		}
	}

	@SuppressWarnings("unchecked")
	public List<TipoTransacaoEntity> listar() {
		List<TipoTransacaoEntity> tipo = null;
		Query query = em.createQuery("SELECT f FROM TipoTransacaoEntity f");
		try {
			tipo = query.getResultList();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao listar todos os Tipo");
		}
		return tipo;
	}

	// Implementar
	@SuppressWarnings("unchecked")
	public TipoTransacaoEntity pesquisaPeloNome(String nome) {
		TipoTransacaoEntity tipo = null;
		Query query = em.createQuery("SELECT f FROM TipoTransacaoEntity f WHERE f.nome = :nome");
		query.setParameter("nome", nome);
		try {
			List<TipoTransacaoEntity> tipos = null;
			tipos = query.getResultList();
			if (tipos != null) {
				tipo = tipos.get(0);
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar um Tipo pelo nome");
		}
		return tipo;
	}
	


}
