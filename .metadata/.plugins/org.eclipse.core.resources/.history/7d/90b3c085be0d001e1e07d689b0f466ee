package oColecionador.entity;

import java.beans.Transient;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.ToString;

@Data
@Embeddable
public class ColecaoMoedaId implements Serializable {
	
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_colecao", nullable = false, referencedColumnName = "id_colecao")
    private ColecaoEntity colecaoEntity;

    
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_moeda", nullable = false, referencedColumnName = "id_moeda")
    private MoedaEntity moedaEntity;

}
