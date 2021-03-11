package br.com.movies.login.service;

import br.com.movies.login.dto.UserDTO;

public interface LoginService {

	UserDTO verifyIfUserExists(UserDTO user);
	
}
