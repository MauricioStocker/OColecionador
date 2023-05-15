package oColecionador.service;

import java.util.List;

import javax.swing.JOptionPane;

import oColecionador.entity.Material;
import oColecionador.entity.Pais;
import oColecionador.repository.MaterialRepository;

public class MaterialService {
	private MaterialRepository materialRepository;

	public MaterialService() {
		materialRepository = new MaterialRepository();
	}

	public Material salvar(Material material) {
		if (material.getIdMaterial() == null) {
			Material entity = materialRepository.pesquisaPeloNome(material.getNome());
			if (entity == null) {
				materialRepository.inserir(material);
			} else {
				JOptionPane.showInternalMessageDialog(null, " Material "  +  " '"  +  material.getNome() +  "' "  +  " já cadastrado");
			}
		} else {
			materialRepository.atualizar(material);
			Material material1 = new Material();
			material1 = materialRepository.pesquisaPeloNome(material.getNome());
			JOptionPane.showInternalMessageDialog(null,
					"Nome do Material foi editado para : "+ material1);
		}
		return material;
	}

	public List<Material> listar() {
		return materialRepository.listar();
	}

	public void remover(Material material) {
		materialRepository.remover(material);
	}

}
