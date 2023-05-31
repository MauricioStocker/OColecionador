package oColecionador.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import revendaCarros.entity.Pessoa;

@Entity
@Data
@Table(name = "nota_produto")
public class NotaProdutoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long idNotaProduto;
	
	@Column(name = "quantidade")
	private String quantidade;

	@Column(name = "valor_unidade")
	private String valorUni;
	
	@OneToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private UsuarioEntity usuarioEntity;
	
	@ManyToMany
	@JoinTable(name = "colecao_nota_prod", joinColumns = @JoinColumn(name = "id_produto"), inverseJoinColumns = @JoinColumn(name = "id_colecao"))
	private List<ColecaoEntity> colecaos;
	
	@Override
	public String toString() {
		return "ID NOTA: " +getIdNotaProduto()+" --- " + " TITULO : " + getColecaos()+ 
				" --- " + "  VALOR : " + getValorUni()+" --- " + "VENDEDOR :"+ getUsuarioEntity().getNome();
	}
	

}
