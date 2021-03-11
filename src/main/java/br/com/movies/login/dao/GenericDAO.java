package br.com.movies.login.dao;

import java.io.Serializable;

public interface GenericDAO<T, PK extends Serializable> {

	/**
	 * @throws Exception.
	 */
	void create(T object) throws Exception;

	/**
	 * @throws Exception.
	 */
	void update(T object) throws Exception;

	/**
	 * @param id
	 * 
	 */
	T findById(final PK id);
	
	/**
	 * 
	 * @param namedParam
	 * @param valueParam
	 * @return
	 */
	T findByParam(final String namedParam, final Object valueParam);
	
	
}
