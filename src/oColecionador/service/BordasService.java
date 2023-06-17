package oColecionador.service;

import java.util.List;

import javax.swing.JOptionPane;

import oColecionador.entity.BordasEntity;
import oColecionador.entity.MaterialEntity;
import oColecionador.entity.PaisEntity;
import oColecionador.repository.BordasRepository;

public class BordasService {
	private BordasRepository bordasRepository;

	public BordasService() {
		bordasRepository = new BordasRepository();
	}

	public BordasEntity salvar(BordasEntity bordasEntity) {
		BordasEntity entity = bordasRepository.pesquisaPeloNome(bordasEntity.getNome());
		if (bordasEntity.getIdBordas() == null) {

			if (entity == null) {

				bordasRepository.inserir(bordasEntity);
			} else {
				JOptionPane.showInternalMessageDialog(null,
						" Borda " + " '" + bordasEntity.getNome() + "' " + " já cadastrado");
			}
		} else {
			BordasEntity pais1 = new BordasEntity();
			pais1 = bordasRepository.pesquisaPeloNome(bordasEntity.getNome());
			if (pais1 == null) {

				bordasRepository.atualizar(bordasEntity);
			} else {
				JOptionPane.showInternalMessageDialog(null,
						" Borda " + " '" + bordasEntity.getNome() + "' " + " já cadastrado");
			}

		}
		return bordasEntity;
	}

	public List<BordasEntity> listar() {
		return bordasRepository.listar();
	}

	public void remover(BordasEntity bordasEntity) {
		bordasRepository.remover(bordasEntity);
	}

}
