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
import revendaCarros.entity.Pessoa;

@Entity
@Data
@Table(name = "notaproduto")
public class NotaProduto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long idNotaProduto;
	@ManyToOne
	@JoinColumn(name = "id_colecao", nullable = false)
	private Colecao colecao;
	
	@Column(name = "quantidade")
	private String quantidade;

	@Column(name = "valor_unidade")
	private String valorUni;
	
	@Override
	public String toString() {
		return "ID NORA DO PRODUTO : " +getIdNotaProduto()+" --- " + " TITULO DO PRODUTO : " + getColecao().getMoeda().getTitulo()+ 
				" --- " + "  VALOR DO PRODUTO  " + getValorUni()+" --- " + "STATUS :"+getColecao().getTipoTransacao();
	}
	

}
