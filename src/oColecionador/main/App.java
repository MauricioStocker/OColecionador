package oColecionador.main;

import oColecionador.entity.Bordas;

import oColecionador.entity.Material;
import oColecionador.entity.Pais;
import oColecionador.service.BordasService;

import oColecionador.service.MaterialService;
import oColecionador.service.PaisService;

public class App {

	public static void main(String[] args) {
		Pais pais = new Pais();
		PaisService paisService = new PaisService();

		BordasService service = new BordasService();
		
		Bordas principal = new Bordas();
		
		Material material = new Material();
		MaterialService service3 = new MaterialService();
		pais.setIdPais(1L);
		pais.setNome("Brasil");
		paisService.salvar(pais);
		
		
		
		principal.setNome("Zinco");
		service.salvar(principal);
		
		
		
		
		material.setIdMaterial(1L);
		material.setNome("cobre");
		service3.salvar(material);
		
		
		
		
		

		System.out.println(service.listar());
		
		System.out.println(service3.listar());
		System.out.println(paisService.listar());
	}

}
