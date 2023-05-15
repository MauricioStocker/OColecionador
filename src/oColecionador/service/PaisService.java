package oColecionador.service;

import java.util.List;

import javax.swing.JOptionPane;

import oColecionador.entity.Pais;

import oColecionador.repository.PaisRepository;

public class PaisService {
	private PaisRepository paisRepository;

	public PaisService() {
		paisRepository = new PaisRepository();
	}

	
	public Pais salvar(Pais pais) {
		Pais entity = paisRepository.pesquisaPeloNome(pais.getNome());
		if (pais.getIdPais() == null) {
			
			if (entity == null) {
				paisRepository.inserir(pais);
			} else {
				JOptionPane.showInternalMessageDialog(null, " Pais " + " '" + pais.getNome() + "' " + " já cadastrado");
			}
		} else {
			paisRepository.atualizar(pais);
			Pais pais1 = new Pais();
			pais1 = paisRepository.pesquisaPeloNome(pais.getNome());
			JOptionPane.showInternalMessageDialog(null,
					"Nome do pais foi editado para : "+ pais1);
		}
		return pais;
	}

	public List<Pais> listar() {
		return paisRepository.listar();
	}

	public void remover(Long idPais) {
		paisRepository.remover(idPais);
		JOptionPane.showInternalMessageDialog(null,
				"removido  ");
		
	}

}
