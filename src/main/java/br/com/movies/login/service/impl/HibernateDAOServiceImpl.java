package br.com.movies.login.service.impl;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import br.com.movies.login.dao.GenericDAO;

public abstract class HibernateDAOServiceImpl<T, PK extends Serializable> extends HibernateDaoSupport
		implements GenericDAO<T, PK> {

	/**
	 * Persistent.
	 */
	protected Class<T> persistentClass;

	/**
	 * @return current hibernate session
	 */
	protected Session getCurrentSession() {
		return getHibernateTemplate().getSessionFactory().getCurrentSession();
	}

	@Transactional
	public void create(T entity) throws Exception {

		logger.debug("Saving data based on BEAN " + persistentClass + ".");

		if (entity == null) {
			throw new Exception("Entity is empty.");
		}

		try {
			getHibernateTemplate().save(entity);
			getHibernateTemplate().flush();
			getHibernateTemplate().clear();
		} catch (Exception e) {
			throw new Exception("Error - Persist entity.", e);
		}

		logger.debug("Data were saved.");
	}

	@Transactional
	public void update(T entity) throws Exception {

		if (entity == null) {
			throw new Exception("Entity is empty.");
		}

		try {
			getHibernateTemplate().merge(entity);
			getHibernateTemplate().flush();
			getHibernateTemplate().clear();

		} catch (Exception e) {
			throw new Exception("Error - Persist entity.", e);
		}

	}

	@Transactional(readOnly = true)
	public T findById(PK id) {
		logger.debug("Find " + persistentClass + "by id.");
		T t = (T) getHibernateTemplate().get(persistentClass, id);
		return t;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public T findByParam(final String namedParam, final Object valueParam) {

		logger.debug("Find (boolean) " + persistentClass.getName() + " by named param " + namedParam);

		Criteria criteria = getCurrentSession().createCriteria(persistentClass);
		criteria.add(Restrictions.eq(namedParam, valueParam));

			return (T) criteria.uniqueResult();
	}
	
}
