package oColecionador.repository;

import java.util.List;

import javax.persistence.*;

import oColecionador.entity.BordasEntity;
import oColecionador.entity.ColecaoEntity;
import oColecionador.entity.NotaProdutoEntity;
import oColecionador.entity.UsuarioEntity;

public class NotaProdutoRepository {
	private static EntityManager em = Persistence.createEntityManagerFactory("o_colecionador").createEntityManager();

	public void inserir(NotaProdutoEntity notaProdutoEntity) {
		try {
			em.getTransaction().begin();
			em.persist(notaProdutoEntity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao inserir os dados da nota do produto.");
			System.out.println(e.getMessage());
		}
	}

	public void atualizar(NotaProdutoEntity notaProdutoEntity) {
		try {
			em.getTransaction().begin();
			em.merge(notaProdutoEntity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao atualizar os dados da nota do produto.");
			System.out.println(e.getMessage());
		}
	}

	public NotaProdutoEntity pesquisaPeloId(Long id) {
		NotaProdutoEntity notaProdutoEntity = null;
		try {
			notaProdutoEntity = em.find(NotaProdutoEntity.class, id);
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar a nota do produto pelo id");
		}
		return notaProdutoEntity;
	}

	public void remover(Long id) {
		NotaProdutoEntity notaProdutoEntity = pesquisaPeloId(id);
		remover(notaProdutoEntity);
	}

	public void remover(NotaProdutoEntity notaProdutoEntity) {
		try {
			em.getTransaction().begin();
			em.remove(notaProdutoEntity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao remover a nota do produto");
		}
	}

	@SuppressWarnings("unchecked")
	public List<NotaProdutoEntity> listar() {
		List<NotaProdutoEntity> notaProdutoEntities = null;
		Query query = em.createQuery("SELECT f FROM NotaProdutoEntity f");
		try {
			notaProdutoEntities = query.getResultList();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao listar todas as notas dos produtos");
		}
		return notaProdutoEntities;
	}

	// Implementar
	@SuppressWarnings("unchecked")
	public NotaProdutoEntity pesquisaPeloNome(String nome) {
		NotaProdutoEntity notaProdutoEntity = null;
		Query query = em.createQuery("SELECT f FROM NotaProdutoEntity f WHERE f.nome = :nome");
		query.setParameter("nome", nome);
		try {
			List<NotaProdutoEntity> notaProdutoEntities = null;
			notaProdutoEntities = query.getResultList();
			if (notaProdutoEntities != null) {
				notaProdutoEntity = notaProdutoEntities.get(0);
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar uma nota do produto pelo nome");
		}
		return notaProdutoEntity;
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
	
	public List<NotaProdutoEntity> obterNotasProdutoVenda() {
	    List<NotaProdutoEntity> notasProdutoVenda = null;
	    try {
	        Query query = em.createQuery("SELECT n FROM NotaProdutoEntity n WHERE n.colecaoEntity.tipoTransacaoEntity.nome = 'VENDER'");
	        notasProdutoVenda = query.getResultList();
	    } catch (Exception e) {
	        System.out.println("Ocorreu um erro ao obter as notas de produto para venda");
	    }
	    return notasProdutoVenda;
	}

	

}
