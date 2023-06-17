package oColecionador.repository;

import java.util.List;

import javax.persistence.*;

import oColecionador.entity.BordasEntity;
import oColecionador.entity.ColecaoEntity;
import oColecionador.entity.ColecaoMoedaEntity;
import oColecionador.entity.MoedaEntity;
import oColecionador.entity.UsuarioEntity;

public class ColecaoRepository {
	private static EntityManager em = Persistence.createEntityManagerFactory("o_colecionador").createEntityManager();

	public void inserir(ColecaoEntity colecaoEntity) {

		try {
			em.getTransaction().begin();
			em.persist(colecaoEntity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao inserir os dados da Coleção.");
			System.out.println(e.getMessage());
		}
	}

	public void atualizar(ColecaoEntity colecaoEntity) {
		try {
			em.getTransaction().begin();
			em.merge(colecaoEntity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao atualizar os dados da coleção.");
			System.out.println(e.getMessage());
		}
	}

	public ColecaoEntity pesquisaPeloId(Long idColecao) {
		ColecaoEntity colecaoEntity = null;
		try {
			colecaoEntity = em.find(ColecaoEntity.class, idColecao);
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar a coleção pelo id");
		}
		return colecaoEntity;
	}

	public void remover(Long id) {
		ColecaoEntity colecaoEntity = pesquisaPeloId(id);
		remover(colecaoEntity);
	}

	public void remover(ColecaoEntity colecaoEntity) {
		try {
			em.getTransaction().begin();
			em.remove(colecaoEntity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao remover a coleção");
		}
	}

	@SuppressWarnings("unchecked")
	public List<ColecaoEntity> listar() {
		List<ColecaoEntity> colecaoEntity = null;
		Query query = em.createQuery("SELECT f FROM ColecaoEntity f");
		try {
			colecaoEntity = query.getResultList();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao listar todas as coleções");
		}
		return colecaoEntity;
	}

	// Implementar
	@SuppressWarnings("unchecked")
	public ColecaoEntity pesquisaPeloNome(String nome) {
		ColecaoEntity colecaoEntity = null;
		Query query = em.createQuery("SELECT f FROM ColecaoEntity f WHERE f.nome = :nome");
		query.setParameter("nome", nome);
		try {
			List<ColecaoEntity> colecaoEntities = null;
			colecaoEntities = query.getResultList();
			if (colecaoEntities != null) {
				colecaoEntity = colecaoEntities.get(0);
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar uma coleção pelo nome");
		}
		return colecaoEntity;
	}

	public List<ColecaoEntity> listarColecaoPorTipoVenderDoUsuarioLogado(UsuarioEntity usuarioEntity) {
		List<ColecaoEntity> colecoes = null;
		try {
			Query query = em.createQuery(
					"SELECT c FROM ColecaoEntity c JOIN c.tipoTransacaoEntity t WHERE t.nome = 'VENDER' AND c.usuarioEntity = :usuario");
			query.setParameter("usuario", usuarioEntity);
			colecoes = query.getResultList();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao listar as coleções do tipo VENDER do usuário logado");
		}
		return colecoes;
	}

	public List<ColecaoEntity> obterColecoesDoUsuarioLogado(UsuarioEntity usuarioEntity) {
		List<ColecaoEntity> colecoes = null;
		try {
			Query query = em.createQuery("SELECT c FROM ColecaoEntity c WHERE c.usuarioEntity = :usuarioEntity");
			query.setParameter("usuarioEntity", usuarioEntity);
			colecoes = query.getResultList();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao listar as coleções do usuário logado");
		}
		return colecoes;
	}

	public ColecaoEntity pesquisaPeloIdColecao(Long idColecao) {
		ColecaoEntity colecaoEntity = null;
		try {
			colecaoEntity = em.find(ColecaoEntity.class, idColecao);
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar a coleção pelo ID");
		}
		return colecaoEntity;
	}
	public List<ColecaoMoedaEntity> obterMoedasDaColecaoPorId(Long idColecao) {
	    List<ColecaoMoedaEntity> moedas = null;
	    try {
	        Query query = em.createQuery("SELECT m FROM ColecaoMoedaEntity m WHERE m.colecaoEntity.idColecao = :idColecao");
	        query.setParameter("idColecao", idColecao);
	        moedas = query.getResultList();
	    } catch (Exception e) {
	        System.out.println("Ocorreu um erro ao obter as moedas da coleção por ID");
	    }
	    return moedas;
	}


}
