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
public class ColecaoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_colecao")
	private Long idColecao;
	@Column(name = "quantidade")
	private String quantidade;
	@OneToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private UsuarioEntity usuarioEntity;
	@ManyToOne
	@JoinColumn(name = "id_moeda", nullable = false)
	private MoedaEntity moedaEntity;

	@OneToOne
	@JoinColumn(name = "id_tipo", nullable = false)
	private TipoTransacaoEntity tipoTransacaoEntity;

	@Override
	public String toString() {
		return "USUÁRIO : " + getUsuarioEntity() + "  " + " MOEDA  : " + getMoedaEntity().getTitulo() + "   " + " STATUS : "
				+ getTipoTransacaoEntity();
	}

}
