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
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "colecao")
@Data
@Getter
@Setter
public class Colecao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_colecao")
	private Long idColecao;
	@Column(name = "quantidade")
	private String quantidade;
	@OneToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;
	@ManyToOne
	@JoinColumn(name = "id_moeda", nullable = false)
	private Moeda moeda;

	@OneToOne
	@JoinColumn(name = "id_tipo", nullable = false)
	private TipoTransacao tipoTransacao;
	
	@Override
	public String toString() {
		return  "USUÁRIO : "  +getUsuario() +  "        " + " MOEDA  : "  + getMoeda()+ "        " + " STATUS :   " + getTipoTransacao() ;
	}

}
