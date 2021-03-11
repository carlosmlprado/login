package br.com.movies.login.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.movies.login.dao.LoginDAO;
import br.com.movies.login.entity.BasicEntity;
import br.com.movies.login.entity.UserEntity;

@Repository("loginDAO")
public class LoginDAOImpl extends BasicEntity<UserEntity, Integer> implements LoginDAO {

}
