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
@Table(name = "TB_colecao")
@Data
public class ColecaoEntity {
	
	

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_colecao")
    @Id
    private Long idColecao;
    
 
    @OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private UsuarioEntity usuarioEntity;
    
	@Column(name = "Titulo")
	private String TituloColecao;
    
    
    
    @ToString.Exclude
    @OneToMany(mappedBy = "colecaoEntity", cascade = CascadeType.ALL)
    private List<ColecaoMoedaEntity> colecaoMoedaEntities;
    
    @Override
	public String toString() {
		return "ID TITULO = " + getTituloColecao()+ "      DONO DA COLEÇÃO : "+ getUsuarioEntity()  ;
	}

}
