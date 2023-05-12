package oColecionador.repository;

import java.util.List;

import javax.persistence.*;
import javax.swing.JOptionPane;

import oColecionador.entity.Colecao;
import oColecionador.entity.Usuario;

public class UsuarioRepository {
	private static EntityManager em = Persistence.createEntityManagerFactory("o_colecionador").createEntityManager();

	public void inserir(Usuario usuario) {
		try {
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao inserir os dados do fabricante.");
			System.out.println(e.getMessage());
		}
	}

	public void atualizar(Usuario usuario) {
		try {
			em.getTransaction().begin();
			em.merge(usuario);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao atualizar os dados do fabricante.");
			System.out.println(e.getMessage());
		}
	}

	public Usuario pesquisaPeloId(Long id) {
		Usuario usuario = null;
		try {
			usuario = em.find(Usuario.class, id);
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar o fabricante pelo id");
		}
		return usuario;
	}

	public void remover(Long id) {
		Usuario usuario = pesquisaPeloId(id);
		remover(usuario);
	}

	public void remover(Usuario usuario) {
		try {
			em.getTransaction().begin();
			em.remove(usuario);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Ocorreu um erro ao remover o fabricante");
		}
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listar() {
		List<Usuario> usuario = null;
		Query query = em.createQuery("SELECT f FROM Usuario f");
		try {
			usuario = query.getResultList();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao listar todos os fabricantes");
		}
		return usuario;
	}

	// Implementar
	@SuppressWarnings("unchecked")
	public Usuario pesquisaPeloNome(String nome) {
		Usuario usuario = null;
		Query query = em.createQuery("SELECT f FROM Usuario f WHERE f.nome = :nome");
		query.setParameter("nome", nome);
		try {
			List<Usuario> usuarios = null;
			usuarios = query.getResultList();
			if (usuarios != null) {
				usuario = usuarios.get(0);
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar um fabricante pelo nome");
		}
		return usuario;
	}

	public Usuario pesquisaPeloUserAndSenha(String user, String senha) {

		Usuario usuario = null;
		List<Usuario> usuarios = null;
		Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.user = :user AND u.senha = :senha");
		query.setParameter("user", user);
		query.setParameter("senha", senha);

		try {
			usuarios = query.getResultList();
			if (usuarios != null) {
				usuario = usuarios.get(0);
			} else {

				System.out.println("Ocorreu um erro ao listar todos os fabricantes nn");
			}
		} catch (Exception e) {

		}
		return usuario;

	}

	public Usuario pesquisaPeloUser(String user) {
		Usuario usuario = null;
		Query query = em.createQuery("SELECT f FROM Usuario f WHERE f.user = :user");
		query.setParameter("user", user);
		try {
			List<Usuario> usuarios = null;
			usuarios = query.getResultList();
			if (usuarios != null) {
				usuario = usuarios.get(0);
			}
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao pesquisar um fabricante pelo nome");
		}
		return usuario;
	}

	public Usuario pesquisaPeloEmail(String email) {
		Usuario usuario = null;
		Query query = em.createQuery("SELECT f FROM Usuario f WHERE f.email = :email");
		query.setParameter("email", email);
		try {
			List<Usuario> usuarios = null;
			usuarios = query.getResultList();
			if (usuarios != null) {
				usuario = usuarios.get(0);
			}else {
				JOptionPane.showMessageDialog(null, "preencha o campos!!", "Erro",
						JOptionPane.ERROR_MESSAGE);
				
			}
		} catch (Exception exception) {
			JOptionPane.showMessageDialog(null, "preencha o campo corretamente com seu EMAIL!!", "Erro",
					JOptionPane.ERROR_MESSAGE);
			
		}
		return usuario;
	}

}
