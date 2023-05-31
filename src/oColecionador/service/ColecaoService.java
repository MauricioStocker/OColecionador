package oColecionador.service;

import java.util.List;

import javax.swing.JOptionPane;

import oColecionador.entity.ColecaoEntity;
import oColecionador.entity.UsuarioEntity;
import oColecionador.repository.ColecaoRepository;

public class ColecaoService {

	private ColecaoRepository colecaoRepository;

	public ColecaoService() {
		colecaoRepository = new ColecaoRepository();
	}

	public ColecaoEntity salvar(ColecaoEntity colecaoEntity) {

		if (colecaoEntity.getIdColecao() == null) {
		} else {

			colecaoRepository.atualizar(colecaoEntity);
			JOptionPane.showInternalMessageDialog(null, "Coleção Atualizado com sucesso  !!!!");

		}
		return colecaoEntity;
	}

	public List<ColecaoEntity> listar() {
		return colecaoRepository.listar();
	}
	
	

	public List<ColecaoEntity> listarColecaoUserLogado(UsuarioEntity usuarioEntity) {
		return colecaoRepository.listarColecaoPorTipoVenderDoUsuarioLogado(usuarioEntity);
	}
}
