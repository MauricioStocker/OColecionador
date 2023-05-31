package oColecionador.service;

import java.util.List;

import javax.swing.JOptionPane;

import oColecionador.entity.BordasEntity;
import oColecionador.entity.MaterialEntity;
import oColecionador.repository.BordasRepository;

public class BordasService {
	private BordasRepository bordasRepository;

	public BordasService() {
		bordasRepository = new BordasRepository();
	}

	public BordasEntity salvar(BordasEntity bordasEntity) {
		if (bordasEntity.getIdBordas() == null) {
			BordasEntity entity = bordasRepository.pesquisaPeloNome(bordasEntity.getNome());
			if (entity == null) {
				bordasRepository.inserir(bordasEntity);
			} else {
				JOptionPane.showInternalMessageDialog(null,
						" Borda " + " '" + bordasEntity.getNome() + "' " + " já cadastrado");

			}
		} else {
			bordasRepository.atualizar(bordasEntity);
			BordasEntity bordas1 = new BordasEntity();
			bordas1 = bordasRepository.pesquisaPeloNome(bordasEntity.getNome());
			JOptionPane.showInternalMessageDialog(null,
					"Nome do Material foi editado para : "+ bordas1);
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
