package oColecionador.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "tb_nota_produto_colecao")
public class NotaProdutoColecaoEntity {

	@ToString.Exclude
	@EmbeddedId
	private NotaProdutoColecaoId notaProdutoColecaoID;

	@ManyToOne
	@JoinColumn(name = "id_nota_produto", insertable = false, updatable = false)
	private NotaProdutoEntity notaProdutoEntity;

	

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private UsuarioEntity usuarioEntity;

	@Column(name = "quantidade")
	private String quantidade;

	@Column(name = "valor_unidade")
	private String valorUni;

}
