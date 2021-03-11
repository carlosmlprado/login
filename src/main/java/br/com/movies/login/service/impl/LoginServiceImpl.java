package br.com.movies.login.service.impl;

import org.springframework.stereotype.Service;

import br.com.movies.login.dao.LoginDAO;
import br.com.movies.login.dto.UserDTO;
import br.com.movies.login.entity.UserEntity;
import br.com.movies.login.service.LoginService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service("loginService")
@AllArgsConstructor
@Slf4j
public class LoginServiceImpl implements LoginService {

	private LoginDAO loginDAO;

	@Override
	public UserDTO verifyIfUserExists(UserDTO user) {
		log.info("Verifying if user exists and retrieve an object with his/her informations..");
		UserEntity userEntity = new UserEntity();
		UserDTO userDTO = new UserDTO();
		try {
			userEntity = loginDAO.findByParam("cpf", user.getCpf());

			if (null != userEntity) {
				log.info("User " + user.getName() + " already exists");
				userDTO = builder(userEntity);

			} else {
				userEntity = new UserEntity();
				log.info("User " + user.getName() + " doesn't exists. Persisting it now");
				userEntity = UserEntity.builder(user);
				loginDAO.create(userEntity);
				userDTO = builder(userEntity);

				log.debug("Object userEntity: " + userEntity);
			}
			log.debug("Return: " + userDTO);
			return userDTO;
		} catch (Exception e) {
			log.error("Erro retrieving user information: " + e.getMessage());
			return new UserDTO();
		}

	}

	/**
	 * 
	 * @param userEntity
	 * @return
	 */
	private UserDTO builder(UserEntity userEntity) {

		UserDTO userDTO = new UserDTO();
		userDTO.setName(userEntity.getName());
		userDTO.setCpf(userEntity.getCpf());
		userDTO.setUserId(userEntity.getId());

		return userDTO;

	}
}
