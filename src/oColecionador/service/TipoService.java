package oColecionador.service;

import java.util.List;

import oColecionador.entity.TipoTransacaoEntity;

import oColecionador.repository.TipoRepository;

public class TipoService {

	private TipoRepository tipoRepository;

	public TipoService() {
		tipoRepository = new TipoRepository();

	}

	public List<TipoTransacaoEntity> listar() {
		return tipoRepository.listar();
	}
}
