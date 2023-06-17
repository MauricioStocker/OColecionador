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
                JOptionPane.showMessageDialog(null,
                        "Moeda '" + moedaEntity.getTitulo() + "' cadastrada!");
            } else {
                JOptionPane.showMessageDialog(null,
                        "Moeda '" + moedaEntity.getTitulo() + "' já cadastrada!");
            }
        } else {
            moedaRepository.atualizar(moedaEntity);
            JOptionPane.showMessageDialog(null, "Moeda atualizada com sucesso!");
        }
        return moedaEntity;
    }

    public List<MoedaEntity> listar() {
        return moedaRepository.listar();
    }

    public void remover(Long idMoeda) {
        if (idMoeda == null) {
            JOptionPane.showMessageDialog(null, "Não existem moedas para deletar!");
        } else {
            moedaRepository.remover(idMoeda);
        }
    }
}
