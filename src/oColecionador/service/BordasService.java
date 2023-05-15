package oColecionador.service;

import java.util.List;

import javax.swing.JOptionPane;

import oColecionador.entity.Bordas;
import oColecionador.entity.Material;
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
			Bordas bordas1 = new Bordas();
			bordas1 = bordasRepository.pesquisaPeloNome(bordas.getNome());
			JOptionPane.showInternalMessageDialog(null,
					"Nome do Material foi editado para : "+ bordas1);
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
