package oColecionador.main;

import oColecionador.entity.BordasEntity;

import oColecionador.entity.MaterialEntity;
import oColecionador.entity.PaisEntity;
import oColecionador.service.BordasService;

import oColecionador.service.MaterialService;
import oColecionador.service.PaisService;

public class App {

	public static void main(String[] args) {
		PaisEntity paisEntity = new PaisEntity();
		PaisService paisService = new PaisService();

		BordasService service = new BordasService();
		
		BordasEntity principal = new BordasEntity();
		
		MaterialEntity materialEntity = new MaterialEntity();
		MaterialService service3 = new MaterialService();
		paisEntity.setIdPais(1L);
		paisEntity.setNome("Brasil");
		paisService.salvar(paisEntity);
		
		
		
		principal.setNome("Zinco");
		service.salvar(principal);
		
		
		
		
		materialEntity.setIdMaterial(1L);
		materialEntity.setNome("cobre");
		service3.salvar(materialEntity);
		
		
		
		
		

		System.out.println(service.listar());
		
		System.out.println(service3.listar());
		System.out.println(paisService.listar());
	}

}
