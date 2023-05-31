package oColecionador.repository;

import java.util.List;

import javax.persistence.*;

import oColecionador.entity.BordasEntity;
import oColecionador.entity.ColecaoEntity;
import oColecionador.entity.NotaProdutoEntity;
import oColecionador.entity.NotaTransacaoEntity;
import oColecionador.entity.TipoTransacaoEntity;
import oColecionador.entity.UsuarioEntity;

public class NotaTransacaoRepository {
	private static EntityManager em = Persistence.createEntityManagerFactory("o_colecionador").createEntityManager();

	public void inserir(NotaTransacaoEntity transacao) {
		try {
			em.getTransaction().begin();
			em.persist(transacao);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao inserir os dados da Transação.");
			System.out.println(e.getMessage());
		}
	}

	public void atualizar(NotaTransacaoEntity transacao) {
		try {
			em.getTransaction().begin();
			em.merge(transacao);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao atualizar os dados da Transação.");
			System.out.println(e.getMessage());
		}
	}

	public NotaTransacaoEntity pesquisaPeloId(Long id) {
		NotaTransacaoEntity transacao = null;
		try {
			transacao = em.find(NotaTransacaoEntity.class, id);
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar a Transação pelo id");
		}
		return transacao;
	}

	public void remover(Long id) {
		NotaTransacaoEntity transacao = pesquisaPeloId(id);
		remover(transacao);
	}

	public void remover(NotaTransacaoEntity transacao) {
		try {
			em.getTransaction().begin();
			em.remove(transacao);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao remover a Transação");
		}
	}

	@SuppressWarnings("unchecked")
	public List<NotaTransacaoEntity> listar() {
		List<NotaTransacaoEntity> transacaos = null;
		Query query = em.createQuery("SELECT f FROM NotaTransacaoEntity f");
		try {
			transacaos = query.getResultList();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao listar todos as Transações");
		}
		return transacaos;
	}

	// Implementar
	@SuppressWarnings("unchecked")
	public NotaTransacaoEntity pesquisaPeloNome(String nome) {
		NotaTransacaoEntity transacao = null;
		Query query = em.createQuery("SELECT f FROM NotaTransacaoEntity f WHERE f.nome = :nome");
		query.setParameter("nome", nome);
		try {
			List<NotaTransacaoEntity> transacaos = null;
			transacaos = query.getResultList();
			if (transacaos != null) {
				transacao = transacaos.get(0);
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar uma Transação pelo nome");
		}
		return transacao;
	}

	public List<NotaProdutoEntity> obterColecoesDoUsuarioLogado(UsuarioEntity usuarioEntity) {
		List<NotaProdutoEntity> notaProdutoEntities = null;
		try {
			Query query = em.createQuery("SELECT c FROM NotaProdutoEntity c WHERE c.usuarioEntity = :usuarioEntity");
			query.setParameter("usuario", usuarioEntity);
			notaProdutoEntities = query.getResultList();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao listar as coleções do usuário logado");
		}
		return notaProdutoEntities;
	}
	



}
