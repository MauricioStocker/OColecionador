package oColecionador.service;

import java.util.List;

import javax.swing.JOptionPane;

import oColecionador.entity.Bordas;
import oColecionador.repository.BordasRepository;

public class BordasService {
	private BordasRepository bordasRepository;

	public BordasService() {
		bordasRepository = new BordasRepository();
	}

	public Bordas salvar(Bordas bordas) {
		if (bordas.getIdBordas() == null) {
			Bordas entity = bordasRepository.pesquisaPeloNome(bordas.getNome());
			if (entity == null) {
				bordasRepository.inserir(bordas);
			} else {
				JOptionPane.showInternalMessageDialog(null,
						" Borda " + " '" + bordas.getNome() + "' " + " já cadastrado");

			}
		} else {
			bordasRepository.atualizar(bordas);
		}
		return bordas;
	}

	public List<Bordas> listar() {
		return bordasRepository.listar();
	}

	public void remover(Bordas bordas) {
		bordasRepository.remover(bordas);
	}

}
