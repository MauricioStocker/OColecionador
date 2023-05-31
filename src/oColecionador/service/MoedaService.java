package oColecionador.service;

import java.util.List;

import javax.swing.JOptionPane;

import oColecionador.entity.MoedaEntity;

import oColecionador.repository.MoedaRepository;

public class MoedaService {
	private MoedaRepository moedaRepository;

	public MoedaService() {
		moedaRepository = new MoedaRepository();
	}

	public MoedaEntity salvar(MoedaEntity moedaEntity) {
		MoedaEntity entity = moedaRepository.pesquisaPeloNome(moedaEntity.getTitulo());
		if (moedaEntity.getIdMoeda() == null) {
			
			if (entity == null) {
				moedaRepository.inserir(moedaEntity);
				JOptionPane.showInternalMessageDialog(null,
						"Moeda  " + " ' " + moedaEntity.getTitulo() + " ' " + "cadastrado !!");
			} else {
				JOptionPane.showInternalMessageDialog(null,
						"Moeda " + " ' " + moedaEntity.getTitulo() + " ' " + "Já cadastrada !!!!");

			}
		} else {
			
			moedaRepository.atualizar(moedaEntity);
			JOptionPane.showInternalMessageDialog(null,
					"Moeda Atualizado com sucesso  !!!!");
		
		}
		return moedaEntity;
	}

	public List<MoedaEntity> listar() {
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
