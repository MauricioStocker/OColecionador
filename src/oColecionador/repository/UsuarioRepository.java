package oColecionador.repository;

import java.util.List;

import javax.persistence.*;
import javax.swing.JOptionPane;

import oColecionador.entity.ColecaoEntity;
import oColecionador.entity.UsuarioEntity;

public class UsuarioRepository {
	private static EntityManager em = Persistence.createEntityManagerFactory("o_colecionador").createEntityManager();

	public void inserir(UsuarioEntity usuarioEntity) {
		try {
			em.getTransaction().begin();
			em.persist(usuarioEntity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao inserir os dados do Usuário.");
			System.out.println(e.getMessage());
		}
	}

	public void atualizar(UsuarioEntity usuarioEntity) {
		try {
			em.getTransaction().begin();
			em.merge(usuarioEntity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao atualizar os dados do Usuário.");
			System.out.println(e.getMessage());
		}
	}

	public UsuarioEntity pesquisaPeloId(Long id) {
		UsuarioEntity usuarioEntity = null;
		try {
			usuarioEntity = em.find(UsuarioEntity.class, id);
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar o Usuário pelo id");
		}
		return usuarioEntity;
	}

	public void remover(Long id) {
		UsuarioEntity usuarioEntity = pesquisaPeloId(id);
		remover(usuarioEntity);
	}

	public void remover(UsuarioEntity usuarioEntity) {
		try {
			em.getTransaction().begin();
			em.remove(usuarioEntity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao remover o Usuário");
		}
	}

	@SuppressWarnings("unchecked")
	public List<UsuarioEntity> listar() {
		List<UsuarioEntity> usuarioEntity = null;
		Query query = em.createQuery("SELECT f FROM UsuarioEntity f");
		try {
			usuarioEntity = query.getResultList();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao listar todos os Usuario");
		}
		return usuarioEntity;
	}

	// Implementar
	@SuppressWarnings("unchecked")
	public UsuarioEntity pesquisaPeloNome(String nome) {
		UsuarioEntity usuarioEntity = null;
		Query query = em.createQuery("SELECT f FROM UsuarioEntity f WHERE f.nome = :nome");
		query.setParameter("nome", nome);
		try {
			List<UsuarioEntity> usuarioEntities = null;
			usuarioEntities = query.getResultList();
			if (usuarioEntities != null) {
				usuarioEntity = usuarioEntities.get(0);
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar um Usuário pelo nome");
		}
		return usuarioEntity;
	}

	public UsuarioEntity pesquisaPeloUserAndSenha(String user, String senha) {

		UsuarioEntity usuarioEntity = null;
		List<UsuarioEntity> usuarioEntities = null;
		Query query = em.createQuery("SELECT u FROM UsuarioEntity u WHERE u.user = :user AND u.senha = :senha");
		query.setParameter("user", user);
		query.setParameter("senha", senha);

		try {
			usuarioEntities = query.getResultList();
			if (usuarioEntities != null) {
				usuarioEntity = usuarioEntities.get(0);
			} else {

				System.out.println("Ocorreu um erro ao listar todos os Usuário ");
			}
		} catch (Exception e) {

		}
		return usuarioEntity;

	}

	public UsuarioEntity pesquisaPeloUser(String user) {
		UsuarioEntity usuarioEntity = null;
		Query query = em.createQuery("SELECT f FROM UsuarioEntity f WHERE f.user = :user");
		query.setParameter("user", user);
		try {
			List<UsuarioEntity> usuarioEntities = null;
			usuarioEntities = query.getResultList();
			if (usuarioEntities != null) {
				usuarioEntity = usuarioEntities.get(0);
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar um Usuário pelo user");
		}
		return usuarioEntity;
	}

	public UsuarioEntity pesquisaPeloEmail(String email) {
		UsuarioEntity usuarioEntity = null;
		Query query = em.createQuery("SELECT f FROM UsuarioEntity f WHERE f.email = :email");
		query.setParameter("email", email);
		try {
			List<UsuarioEntity> usuarioEntities = null;
			usuarioEntities = query.getResultList();
			if (usuarioEntities != null) {
				usuarioEntity = usuarioEntities.get(0);
			}else {
				JOptionPane.showMessageDialog(null, "preencha o campos!!", "Erro",
						JOptionPane.ERROR_MESSAGE);
				
			}
		} catch (Exception exception) {
			JOptionPane.showMessageDialog(null, "preencha o campo corretamente com seu EMAIL!!", "Erro",
					JOptionPane.ERROR_MESSAGE);
			
		}
		return usuarioEntity;
	}

}
