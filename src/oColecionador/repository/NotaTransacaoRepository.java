package oColecionador.repository;

import java.util.List;

import javax.persistence.*;

import oColecionador.entity.Bordas;
import oColecionador.entity.Colecao;
import oColecionador.entity.NotaProduto;
import oColecionador.entity.NotaTransacao;
import oColecionador.entity.TipoTransacao;
import oColecionador.entity.Usuario;

public class NotaTransacaoRepository {
	private static EntityManager em = Persistence.createEntityManagerFactory("o_colecionador").createEntityManager();

	public void inserir(NotaTransacao transacao) {
		try {
			em.getTransaction().begin();
			em.persist(transacao);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao inserir os dados do fabricante.");
			System.out.println(e.getMessage());
		}
	}

	public void atualizar(NotaTransacao transacao) {
		try {
			em.getTransaction().begin();
			em.merge(transacao);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao atualizar os dados do fabricante.");
			System.out.println(e.getMessage());
		}
	}

	public NotaTransacao pesquisaPeloId(Long id) {
		NotaTransacao transacao = null;
		try {
			transacao = em.find(NotaTransacao.class, id);
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar o fabricante pelo id");
		}
		return transacao;
	}

	public void remover(Long id) {
		NotaTransacao transacao = pesquisaPeloId(id);
		remover(transacao);
	}

	public void remover(NotaTransacao transacao) {
		try {
			em.getTransaction().begin();
			em.remove(transacao);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao remover o fabricante");
		}
	}

	@SuppressWarnings("unchecked")
	public List<NotaTransacao> listar() {
		List<NotaTransacao> transacaos = null;
		Query query = em.createQuery("SELECT f FROM NotaTransacao f");
		try {
			transacaos = query.getResultList();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao listar todos os fabricantes");
		}
		return transacaos;
	}

	// Implementar
	@SuppressWarnings("unchecked")
	public NotaTransacao pesquisaPeloNome(String nome) {
		NotaTransacao transacao = null;
		Query query = em.createQuery("SELECT f FROM NotaTransacao f WHERE f.nome = :nome");
		query.setParameter("nome", nome);
		try {
			List<NotaTransacao> transacaos = null;
			transacaos = query.getResultList();
			if (transacaos != null) {
				transacao = transacaos.get(0);
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar um fabricante pelo nome");
		}
		return transacao;
	}

	public List<NotaProduto> obterColecoesDoUsuarioLogado(Usuario usuario) {
		List<NotaProduto> notaProdutos = null;
		try {
			Query query = em.createQuery("SELECT c FROM NotaProduto c WHERE c.usuario = :usuario");
			query.setParameter("usuario", usuario);
			notaProdutos = query.getResultList();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao listar as coleções do usuário logado");
		}
		return notaProdutos;
	}
	



}
