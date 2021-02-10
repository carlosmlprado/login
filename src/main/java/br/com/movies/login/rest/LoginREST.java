package br.com.movies.login.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.movies.login.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import com.google.gson.Gson;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
@RequestMapping("/login")
public class LoginREST {

	@GetMapping("/getLogin/{cpf}/{name}")
	public ResponseEntity<?> getUser(@PathVariable("cpf") String cpf, @PathVariable("name") String name) {

		UsuarioDTO user = new UsuarioDTO();
		user.setCpf("123456");
		user.setName("Joaquim");
		user.setUserId(1);
		return new ResponseEntity<>(new Gson().toJson(user), HttpStatus.OK);
	}
}
