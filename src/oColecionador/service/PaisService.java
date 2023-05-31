package oColecionador.service;

import java.util.List;

import javax.swing.JOptionPane;

import oColecionador.entity.PaisEntity;

import oColecionador.repository.PaisRepository;

public class PaisService {
	private PaisRepository paisRepository;

	public PaisService() {
		paisRepository = new PaisRepository();
	}

	
	public PaisEntity salvar(PaisEntity paisEntity) {
		PaisEntity entity = paisRepository.pesquisaPeloNome(paisEntity.getNome());
		if (paisEntity.getIdPais() == null) {
			
			if (entity == null) {
				paisRepository.inserir(paisEntity);
			} else {
				JOptionPane.showInternalMessageDialog(null, " Pais " + " '" + paisEntity.getNome() + "' " + " já cadastrado");
			}
		} else {
			paisRepository.atualizar(paisEntity);
			PaisEntity pais1 = new PaisEntity();
			pais1 = paisRepository.pesquisaPeloNome(paisEntity.getNome());
			JOptionPane.showInternalMessageDialog(null,
					"Nome do pais foi editado para : "+ pais1);
		}
		return paisEntity;
	}

	public List<PaisEntity> listar() {
		return paisRepository.listar();
	}

	public void remover(Long idPais) {
		paisRepository.remover(idPais);
		JOptionPane.showInternalMessageDialog(null,
				"removido  ");
		
	}

}
