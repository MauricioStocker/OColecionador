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

@Getter
@Setter
@Entity
@Data
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long idUsuario;

	@Column(name = "senha")
	private String senha;

	@Column(name = "user")
	private String user;

	@Column(name = "nome")
	private String nome;

	@Column(name = "endereco")
	private String endereco;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "email")
	private String email;

	@Override
	public String toString() {
		return ""+ getNome();
	}
}
