package oColecionador.service;

import java.util.List;
import java.util.Objects;

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

	public void removerMoedaDaColecao(Long idColecao, Long idMoeda) {
		ColecaoEntity colecaoEntity = colecaoRepository.pesquisaPeloIdColecao(idColecao);
		if (colecaoEntity != null) {
			List<ColecaoMoedaEntity> listaColecaoMoedas = colecaoEntity.getColecaoMoedaEntities();
			if (listaColecaoMoedas != null) {
				// Encontrar a moeda a ser removida na lista
				ColecaoMoedaEntity moedaParaRemover = null;
				for (ColecaoMoedaEntity colecaoMoeda : listaColecaoMoedas) {
					if (Objects.equals(colecaoMoeda.getColecaoMoedaID().getMoedaEntity().getIdMoeda(), idMoeda)) {
						moedaParaRemover = colecaoMoeda;
						break;
					}
				}

				// Remover a moeda da lista, se encontrada
				if (moedaParaRemover != null) {
					listaColecaoMoedas.remove(moedaParaRemover);
					colecaoRepository.excluirMoedaDaColecao(idColecao, idMoeda);
					JOptionPane.showMessageDialog(null, "Moeda removida da coleção com sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "A moeda não está presente na coleção");
				}
			} else {
				JOptionPane.showMessageDialog(null, "A coleção não possui moedas");
			}
		} else {
			JOptionPane.showMessageDialog(null, "A coleção não foi encontrada");
		}
	}

}
