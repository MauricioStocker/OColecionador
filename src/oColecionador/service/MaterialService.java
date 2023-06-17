package oColecionador.service;

import java.util.List;

import javax.swing.JOptionPane;

import oColecionador.entity.BordasEntity;
import oColecionador.entity.MaterialEntity;
import oColecionador.entity.PaisEntity;
import oColecionador.repository.MaterialRepository;

public class MaterialService {
	private MaterialRepository materialRepository;

	public MaterialService() {
		materialRepository = new MaterialRepository();
	}

	public MaterialEntity salvar(MaterialEntity materialEntity) {
		MaterialEntity entity = materialRepository.pesquisaPeloNome(materialEntity.getNome());
		if (materialEntity.getIdMaterial() == null) {

			if (entity == null) {

				materialRepository.inserir(materialEntity);
			} else {
				JOptionPane.showInternalMessageDialog(null,
						" Material " + " '" + materialEntity.getNome() + "' " + " já cadastrado");
			}
		} else {
			MaterialEntity pais1 = new MaterialEntity();
			pais1 = materialRepository.pesquisaPeloNome(materialEntity.getNome());
			if (pais1 == null) {

				materialRepository.atualizar(materialEntity);
			} else {
				JOptionPane.showInternalMessageDialog(null,
						" Material " + " '" + materialEntity.getNome() + "' " + " já cadastrado");
			}

		}
		return materialEntity;
	}

	public List<MaterialEntity> listar() {
		return materialRepository.listar();
	}

	public void remover(Long idMaterial) {
		materialRepository.remover(idMaterial);
		JOptionPane.showInternalMessageDialog(null, "Excluido ");
	}

}
