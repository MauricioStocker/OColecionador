package oColecionador.repository;

import java.util.List;

import javax.persistence.*;

import oColecionador.entity.Bordas;
import oColecionador.entity.Colecao;
import oColecionador.entity.Usuario;

public class ColecaoRepository {
	private static EntityManager em = Persistence.createEntityManagerFactory("o_colecionador").createEntityManager();

	public void inserir(Colecao colecao) {
		try {
			em.getTransaction().begin();
			em.persist(colecao);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao inserir os dados do fabricante.");
			System.out.println(e.getMessage());
		}
	}

	public void atualizar(Colecao colecao) {
		try {
			em.getTransaction().begin();
			em.merge(colecao);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao atualizar os dados do fabricante.");
			System.out.println(e.getMessage());
		}
	}

	public Colecao pesquisaPeloId(Long id) {
		Colecao colecao = null;
		try {
			colecao = em.find(Colecao.class, id);
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar o fabricante pelo id");
		}
		return colecao;
	}

	public void remover(Long id) {
		Colecao colecao = pesquisaPeloId(id);
		remover(colecao);
	}

	public void remover(Colecao colecao) {
		try {
			em.getTransaction().begin();
			em.remove(colecao);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao remover o fabricante");
		}
	}

	@SuppressWarnings("unchecked")
	public List<Colecao> listar() {
		List<Colecao> colecao = null;
		Query query = em.createQuery("SELECT f FROM Colecao f");
		try {
			colecao = query.getResultList();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao listar todos os fabricantes");
		}
		return colecao;
	}

	// Implementar
	@SuppressWarnings("unchecked")
	public Colecao pesquisaPeloNome(String nome) {
		Colecao colecao = null;
		Query query = em.createQuery("SELECT f FROM Colecao f WHERE f.nome = :nome");
		query.setParameter("nome", nome);
		try {
			List<Colecao> colecaos = null;
			colecaos = query.getResultList();
			if (colecaos != null) {
				colecao = colecaos.get(0);
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar um fabricante pelo nome");
		}
		return colecao;
	}
	
	public List<Colecao> listarColecaoPorTipoVenderDoUsuarioLogado(Usuario usuario) {
	    List<Colecao> colecoes = null;
	    try {
	        Query query = em.createQuery("SELECT c FROM Colecao c JOIN c.tipoTransacao t WHERE t.nome = 'VENDER' AND c.usuario = :usuario");
	        query.setParameter("usuario", usuario);
	        colecoes = query.getResultList();
	    } catch (Exception e) {
	        System.out.println("Ocorreu um erro ao listar as coleções do tipo VENDER do usuário logado");
	    }
	    return colecoes;
	}


	public List<Colecao> obterColecoesDoUsuarioLogado(Usuario usuario) {
	    List<Colecao> colecoes = null;
	    try {
	        Query query = em.createQuery("SELECT c FROM Colecao c WHERE c.usuario = :usuario");
	        query.setParameter("usuario", usuario);
	        colecoes = query.getResultList();
	    } catch (Exception e) {
	        System.out.println("Ocorreu um erro ao listar as coleções do usuário logado");
	    }
	    return colecoes;
	}

	



}
