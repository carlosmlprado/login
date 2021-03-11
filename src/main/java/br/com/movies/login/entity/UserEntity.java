package br.com.movies.login.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.movies.login.dto.UserDTO;
import lombok.Data;

@Entity
@Data
@Table(name = "usuario")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	public Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "cpf")
	private String cpf;

	public static UserEntity builder(UserDTO usuario) {
		UserEntity user = new UserEntity();
		user.setCpf(usuario.getCpf());
		user.setName(usuario.getName());

		return user;
	}

}
