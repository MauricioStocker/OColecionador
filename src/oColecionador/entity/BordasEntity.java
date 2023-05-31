package oColecionador.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bordas")
@Data
@Getter
@Setter
public class BordasEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_bordas")
	private Long idBordas;

	@Column(name = "nome", length = 50, unique = true)
	private String nome;

	@Override
	public String toString() {
		return "" + getNome();
	}
}
