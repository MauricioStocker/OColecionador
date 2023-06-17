package oColecionador.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.protobuf.TextFormat.ParseException;

import lombok.Data;
import oColecionador.util.FormataData;

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
	private Date ano;

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
	@JoinTable(name = "moeda_borda", joinColumns = @JoinColumn(name = "id_moeda"), inverseJoinColumns = @JoinColumn(name = "id_borda"))
	private List<BordasEntity> bordas;

	@ManyToMany
	@JoinTable(name = "moeda_material", joinColumns = @JoinColumn(name = "id_moeda"), inverseJoinColumns = @JoinColumn(name = "id_material"))
	private List<MaterialEntity> materiais;

	@ManyToOne
	@JoinColumn(name = "id_pais")
	private PaisEntity paisEntity;

	@OneToOne(mappedBy = "idColecaMoeda.idMoeda", cascade = CascadeType.ALL, fetch = FetchType.LAZY)

	@Override
	public String toString() {
		return "ID MOEDA = " + getIdMoeda() + "      TITULO: " +getTitulo() ;
	}

}
