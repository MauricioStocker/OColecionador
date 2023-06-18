package oColecionador.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "TB_colecao_moeda")
@Data
public class ColecaoMoedaEntity {

	@ToString.Exclude
	@EmbeddedId
	private ColecaoMoedaId colecaoMoedaID;

	

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo")
	private TipoTransacaoEntity tipoTransacaoEntity;
	
	@ManyToOne
	@JoinColumn(name = "id_colecao", insertable = false, updatable = false)
	private ColecaoEntity colecaoEntity;

	@Override
	public String toString() {
		return  "" +getColecaoMoedaID().getMoedaEntity().getIdMoeda() + getTipoTransacaoEntity() + getColecaoMoedaID().getColecaoEntity().getUsuarioEntity();
	}
}
