package oColecionador.service;

import java.util.List;

import javax.swing.JOptionPane;

import oColecionador.entity.BordasEntity;
import oColecionador.entity.ColecaoEntity;
import oColecionador.entity.ColecaoMoedaEntity;
import oColecionador.entity.MoedaEntity;
import oColecionador.entity.UsuarioEntity;
import oColecionador.repository.ColecaoRepository;

public class ColecaoService {

	private ColecaoRepository colecaoRepository;

	public ColecaoService() {
		colecaoRepository = new ColecaoRepository();
	}

	public ColecaoEntity salvar(ColecaoEntity colecaoEntity) {

		if (colecaoEntity.getIdColecao() == null) {

			colecaoRepository.inserir(colecaoEntity);
			JOptionPane.showMessageDialog(null, "Cooleção  cadastrada!");

		} else {

			colecaoRepository.atualizar(colecaoEntity);
			JOptionPane.showMessageDialog(null, "Moeda atualizada com sucesso!");

		}
		return colecaoEntity;
	}

	public ColecaoEntity presquisaId(Long id) {

		return colecaoRepository.pesquisaPeloId(id);
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

	public ColecaoEntity presquisaIdColecao(Long id) {

		return colecaoRepository.pesquisaPeloIdColecao(id);
	}
	
	public List<ColecaoMoedaEntity> presquisaMoedasColeção(Long idColecao) {

		return colecaoRepository.obterMoedasDaColecaoPorId(idColecao);
	}
}
