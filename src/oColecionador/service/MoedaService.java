package oColecionador.service;

import java.util.List;

import javax.swing.JOptionPane;


import oColecionador.entity.Moeda;

import oColecionador.repository.MoedaRepository;

public class MoedaService {
	private MoedaRepository moedaRepository;

	public MoedaService() {
		moedaRepository = new MoedaRepository();
	}

	public Moeda salvar(Moeda moeda) {
		if (moeda.getIdMoeda() == null) {
			Moeda entity = moedaRepository.pesquisaPeloNome(moeda.getTitulo());
			if (entity == null) {
				moedaRepository.inserir(moeda);
				JOptionPane.showInternalMessageDialog(null, "Moeda cadastrado !!");
			} else {
				JOptionPane.showInternalMessageDialog(null, "Moeda Já cadastrada !!!!");
				
			}
		} else {
			moedaRepository.atualizar(moeda);
		}
		return moeda;
	}

	public List<Moeda> listar() {
		return moedaRepository.listar();
	}

	public void remover(Moeda moeda) {
		moedaRepository.remover(moeda);
	}

}
