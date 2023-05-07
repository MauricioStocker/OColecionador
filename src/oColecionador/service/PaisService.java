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
		if (pais.getIdPais() == null) {
			Pais entity = paisRepository.pesquisaPeloNome(pais.getNome());
			if (entity == null) {
				paisRepository.inserir(pais);
			} else {
				JOptionPane.showInternalMessageDialog(null, " Pais "  +  " '"  +  pais.getNome() +  "' "  +  " já cadastrado");
			}
		} else {
			paisRepository.atualizar(pais);
		}
		return pais;
	}

	public List<Pais> listar() {
		return paisRepository.listar();
	}

	public void remover(Pais pais) {
		paisRepository.remover(pais);
	}

}
