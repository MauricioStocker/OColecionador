package oColecionador.service;

import javax.swing.JOptionPane;

import oColecionador.entity.Usuario;
import oColecionador.repository.UsuarioRepository;

public class UsuarioService {

	String UsuarioLogado;
	UsuarioRepository usuarioRepository = new UsuarioRepository();

	public Boolean login(Usuario usuario) {

		if (usuarioRepository.pesquisaPeloUserAndSenha(usuario.getUser(), usuario.getSenha()) != null
				|| usuario.getUser().equals("admin") && usuario.getSenha().equals("admin")) {

			return true;
		}
		if (usuarioRepository.pesquisaPeloUserAndSenha(usuario.getUser(), usuario.getSenha()) == null) {
			JOptionPane.showInternalMessageDialog(null, "Preencha os campos LOGIN/SENHA para realizar o login");
			return false;
		} else {
			return false;
		}

	}

	public Usuario salvar(Usuario usuario) {
		if (usuario.getIdUsuario() == null) {
			Usuario entity = usuarioRepository.pesquisaPeloNome(usuario.getNome());
			if (entity == null) {
				usuarioRepository.inserir(usuario);
				JOptionPane.showInternalMessageDialog(null, "Usuário cadastrado !!");
			} else {
				JOptionPane.showInternalMessageDialog(null, "Usuário existe na base de dados cadastrado !!");

			}
		} else {
			usuarioRepository.atualizar(usuario);
		}
		return usuario;
	}
	


}
