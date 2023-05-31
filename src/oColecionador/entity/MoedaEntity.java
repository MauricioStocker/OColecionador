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

@Table(name = "moeda")
@Entity
@Data
public class MoedaEntity {

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

	@ManyToMany
	@JoinTable(name = "moeda_Borda", joinColumns = @JoinColumn(name = "id_moeda"), inverseJoinColumns = @JoinColumn(name = "id_borda"))
	private List<BordasEntity> bordas;

	@ManyToMany
	@JoinTable(name = "moeda_material", joinColumns = @JoinColumn(name = "id_moeda"), inverseJoinColumns = @JoinColumn(name = "id_material"))
	private List<MaterialEntity> materiais;

	@ManyToOne
	@JoinColumn(name = "id_pais")
	private PaisEntity paisEntity;
	

	@Override
	public String toString() {
		return " (1) " + getTitulo() +"   (2) " + getCodigoCatalogo()+ "   (3) " +getAno() +"   (4) " + getValor() + "   (5) " +getEspessura() + "   (6) "
	+getPeso()+ "   (7) " + getDiametro()+ "   (8) " + getPaisEntity().getNome()+ "   (9) " + getBordas()+"   (10) "+ getMateriais();
	}
	

}
