package oColecionador.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.ToString;

@Embeddable
@Data
public class NotaProdutoColecaoId implements Serializable {

	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_nota_produto", nullable = false, referencedColumnName = "id_nota_produto")
	private NotaProdutoEntity notaProdutoEntity;

	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_moeda", nullable = false, referencedColumnName = "id_moeda")
	private MoedaEntity moedaEntity;
}
