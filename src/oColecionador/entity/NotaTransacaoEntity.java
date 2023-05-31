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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "nota_transacao")
public class NotaTransacaoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_transacao")
	private Long idTransacao;
	

	@Column(name = "valor")
	private String valor;
	@Column(name = "data")
	private String data;
	@Column(name = "numero_nota")
	private String numNota;
	
	@OneToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private UsuarioEntity usuarioEntity;
	
	@ManyToMany
	@JoinTable(name = "notaprod_notatrans", joinColumns = @JoinColumn(name = "id_transacao"), inverseJoinColumns = @JoinColumn(name = "id_produto"))
	private List<NotaProdutoEntity> notaProdutos;
	
}
