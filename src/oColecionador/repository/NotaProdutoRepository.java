package oColecionador.repository;

import java.util.List;

import javax.persistence.*;

import oColecionador.entity.Bordas;
import oColecionador.entity.Colecao;
import oColecionador.entity.NotaProduto;
import oColecionador.entity.Usuario;

public class NotaProdutoRepository {
	private static EntityManager em = Persistence.createEntityManagerFactory("o_colecionador").createEntityManager();

	public void inserir(NotaProduto notaProduto) {
		try {
			em.getTransaction().begin();
			em.persist(notaProduto);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao inserir os dados do fabricante.");
			System.out.println(e.getMessage());
		}
	}

	public void atualizar(NotaProduto notaProduto) {
		try {
			em.getTransaction().begin();
			em.merge(notaProduto);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao atualizar os dados do fabricante.");
			System.out.println(e.getMessage());
		}
	}

	public NotaProduto pesquisaPeloId(Long id) {
		NotaProduto notaProduto = null;
		try {
			notaProduto = em.find(NotaProduto.class, id);
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar o fabricante pelo id");
		}
		return notaProduto;
	}

	public void remover(Long id) {
		NotaProduto notaProduto = pesquisaPeloId(id);
		remover(notaProduto);
	}

	public void remover(NotaProduto notaProduto) {
		try {
			em.getTransaction().begin();
			em.remove(notaProduto);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao remover o fabricante");
		}
	}

	@SuppressWarnings("unchecked")
	public List<NotaProduto> listar() {
		List<NotaProduto> notaProdutos = null;
		Query query = em.createQuery("SELECT f FROM NotaProduto f");
		try {
			notaProdutos = query.getResultList();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao listar todos os fabricantes");
		}
		return notaProdutos;
	}

	// Implementar
	@SuppressWarnings("unchecked")
	public NotaProduto pesquisaPeloNome(String nome) {
		NotaProduto notaProduto = null;
		Query query = em.createQuery("SELECT f FROM NotaProduto f WHERE f.nome = :nome");
		query.setParameter("nome", nome);
		try {
			List<NotaProduto> notaProdutos = null;
			notaProdutos = query.getResultList();
			if (notaProdutos != null) {
				notaProduto = notaProdutos.get(0);
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar um fabricante pelo nome");
		}
		return notaProduto;
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
