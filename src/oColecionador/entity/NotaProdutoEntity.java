package oColecionador.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "tb_nota_produto")
public class NotaProdutoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_nota_produto")
	private Long idNotaProduto;

	

	@ToString.Exclude
	@OneToMany(mappedBy = "notaProdutoEntity", cascade = CascadeType.ALL)
	private List<NotaProdutoColecaoEntity> notaProdutoColecaoEntities;

}
