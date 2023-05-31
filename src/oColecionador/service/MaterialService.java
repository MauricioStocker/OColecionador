package oColecionador.service;

import java.util.List;

import javax.swing.JOptionPane;

import oColecionador.entity.MaterialEntity;
import oColecionador.entity.PaisEntity;
import oColecionador.repository.MaterialRepository;

public class MaterialService {
	private MaterialRepository materialRepository;

	public MaterialService() {
		materialRepository = new MaterialRepository();
	}

	public MaterialEntity salvar(MaterialEntity materialEntity) {
		if (materialEntity.getIdMaterial() == null) {
			MaterialEntity entity = materialRepository.pesquisaPeloNome(materialEntity.getNome());
			if (entity == null) {
				materialRepository.inserir(materialEntity);
			} else {
				JOptionPane.showInternalMessageDialog(null, " Material "  +  " '"  +  materialEntity.getNome() +  "' "  +  " já cadastrado");
			}
		} else {
			materialRepository.atualizar(materialEntity);
			MaterialEntity material1 = new MaterialEntity();
			material1 = materialRepository.pesquisaPeloNome(materialEntity.getNome());
			JOptionPane.showInternalMessageDialog(null,
					"Nome do Material foi editado para : "+ material1);
		}
		return materialEntity;
	}

	public List<MaterialEntity> listar() {
		return materialRepository.listar();
	}

	public void remover(Long idMaterial) {
		materialRepository.remover(idMaterial);
		JOptionPane.showInternalMessageDialog(null,
				"Excluido ");
	}

}
