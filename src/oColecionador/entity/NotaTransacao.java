package oColecionador.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "notaTransacao")
public class NotaTransacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_transacao")
	private Long idTransacao;
	@OneToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn(name = "id_produto", nullable = false)
	private NotaProduto notaProduto;
	@Column(name = "valor")
	private String valor;
	@Column(name = "data")
	private Calendar data;
}
