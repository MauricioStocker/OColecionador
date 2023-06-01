package oColecionador.service;

import java.util.List;

import javax.swing.JOptionPane;

import oColecionador.entity.BordasEntity;
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
			ColecaoEntity entity = colecaoRepository.pesquisaPeloId(colecaoEntity.getIdColecao());
			if (entity == null) {
				colecaoRepository.inserir(colecaoEntity);
			} else {
				JOptionPane.showInternalMessageDialog(null,
						" Borda " + " '" + colecaoEntity.getIdColecao() + "' " + " já cadastrado");

			}
		} else {
			colecaoRepository.atualizar(colecaoEntity);
			ColecaoEntity entity1 = new ColecaoEntity();
			entity1 = colecaoRepository.pesquisaPeloId(colecaoEntity.getIdColecao());
		
		}
		return colecaoEntity;
	}

	public List<ColecaoEntity> listar() {
		return colecaoRepository.listar();
	}

	public List<ColecaoEntity> listarColecaoUserLogado(UsuarioEntity usuarioEntity) {
		return colecaoRepository.listarColecaoPorTipoVenderDoUsuarioLogado(usuarioEntity);
	}

	public List<ColecaoEntity> listarColecaoLogado(UsuarioEntity usuarioEntity) {
		return colecaoRepository.obterColecoesDoUsuarioLogado(usuarioEntity);
	}
}
