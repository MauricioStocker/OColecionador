package oColecionador.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "moeda")
@Entity
@Data
public class Moeda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_moeda")
	private Long idMoeda;
	@Column(name = "titulo", length = 100)
	private String titulo;
	@Column(name = "ano")
	private String ano;
	@Column(name = "valor")
	private String valor;
	@Column(name = "peso")
	private String peso;
	@Column(name = "espessura")
	private String espessura;
	@Column(name = "diametro")
	private String diametro;
	@Column(name = "codigo_catalogo")
	private String codigoCatalogo;

	@OneToOne
	@JoinColumn(name = "id_bordas")
	private Bordas bordas;

	@OneToOne
	@JoinColumn(name = "id_material")
	private Material material;

	@ManyToOne
	@JoinColumn(name = "id_pais")
	private Pais pais;
	

	@Override
	public String toString() {
		return " TITULO : " + getTitulo() +" -- " + " CODIGO CATALOGO :  " +getCodigoCatalogo();
	}
	

}
