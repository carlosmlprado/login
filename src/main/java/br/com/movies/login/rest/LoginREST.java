package br.com.movies.login.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.movies.login.dto.UserDTO;
import br.com.movies.login.service.LoginService;
import lombok.AllArgsConstructor;
import com.google.gson.Gson;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
@RequestMapping("/login")
public class LoginREST {

	private LoginService loginService;

	@GetMapping("/")
	public String test() {
		return "It works!";
	}

	@GetMapping("/getLogin/{cpf}/{name}")
	public ResponseEntity<?> getUser(@PathVariable("cpf") String cpf, @PathVariable("name") String name) {

		UserDTO user = new UserDTO();
		user.setCpf(cpf);
		user.setName(name);
		user = loginService.verifyIfUserExists(user);

		if (null != user.getUserId()) {
			return new ResponseEntity<>(new Gson().toJson(user), HttpStatus.OK);

		} else {
			return new ResponseEntity<>(new Gson().toJson("Error"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
