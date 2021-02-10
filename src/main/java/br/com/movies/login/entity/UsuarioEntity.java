package br.com.movies.login.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.movies.login.dto.UsuarioDTO;
import lombok.Data;

@Entity
@Data
@Table(name = "usuario")
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	public Integer id;

	@Column(name = "name")
	private String nome;

	@Column(name = "cpf")
	private String cpf;

	public UsuarioEntity builder(UsuarioDTO usuario) {

		this.setCpf(usuario.getCpf());
		this.setNome(usuario.getName());

		return this;
	}

}
