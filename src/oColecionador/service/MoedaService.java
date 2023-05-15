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
		Moeda entity = moedaRepository.pesquisaPeloNome(moeda.getTitulo());
		if (moeda.getIdMoeda() == null) {
			
			if (entity == null) {
				moedaRepository.inserir(moeda);
				JOptionPane.showInternalMessageDialog(null,
						"Moeda  " + " ' " + moeda.getTitulo() + " ' " + "cadastrado !!");
			} else {
				JOptionPane.showInternalMessageDialog(null,
						"Moeda " + " ' " + moeda.getTitulo() + " ' " + "Já cadastrada !!!!");

			}
		} else {
			
			moedaRepository.atualizar(moeda);
			JOptionPane.showInternalMessageDialog(null,
					"Moeda Atualizado com sucesso  !!!!");
		
		}
		return moeda;
	}

	public List<Moeda> listar() {
		return moedaRepository.listar();
	}

	public void remover(Long idMoeda) {
		if(idMoeda.equals(null)) {
			JOptionPane.showConfirmDialog(null, "Não existe moedas para deletar");
		}else {
			moedaRepository.remover(idMoeda);
		}
		
	}

}
