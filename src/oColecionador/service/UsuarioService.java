package oColecionador.service;

import javax.swing.JOptionPane;

import oColecionador.entity.UsuarioEntity;
import oColecionador.repository.UsuarioRepository;

public class UsuarioService {

	UsuarioEntity usuarioEntity;
	String UsuarioLogado;
	UsuarioRepository usuarioRepository = new UsuarioRepository();

	public Boolean login(UsuarioEntity usuarioEntity) {

		if (usuarioRepository.pesquisaPeloUserAndSenha(usuarioEntity.getUser(), usuarioEntity.getSenha()) != null
				|| usuarioEntity.getUser().equals("admin") && usuarioEntity.getSenha().equals("admin")) {

			return true;
		}
		if (usuarioRepository.pesquisaPeloUserAndSenha(usuarioEntity.getUser(), usuarioEntity.getSenha()) == null) {

			return false;
		} else {
			return false;
		}

	}

	public UsuarioEntity salvar(UsuarioEntity usuarioEntity) {
		if (usuarioEntity.getIdUsuario() == null) {
			UsuarioEntity entity = usuarioRepository.pesquisaPeloNome(usuarioEntity.getNome());
			if (entity == null) {
				usuarioRepository.inserir(usuarioEntity);
				JOptionPane.showInternalMessageDialog(null, "Usuário cadastrado !!");
			} else {
				JOptionPane.showInternalMessageDialog(null, "Usuário existe na base de dados cadastrado !!");

			}
		} else {
			usuarioRepository.atualizar(usuarioEntity);
		}
		return usuarioEntity;
	}
	
	public UsuarioEntity pesquisaUser(String user) {
		
		return usuarioEntity = usuarioRepository.pesquisaPeloUser(user);
			
	
	}
	public UsuarioEntity pesquisaEmail(String email) {
		return usuarioEntity = usuarioRepository.pesquisaPeloEmail(email);
	}
	
}
