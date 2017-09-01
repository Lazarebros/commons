package com.d2l2c.user.management.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.d2l2c.user.management.bean.User;
import com.d2l2c.user.management.dao.UserDao;

/**
 * @author dayanlazare
 *
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@PersistenceContext(name = "userEntityManager", unitName = "userPersistenceUnit")
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUser(String username, String password) {
		User user = null;

		Query query = em.createQuery("Select user From User user Where user.username = :username and user.password = :password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		query.setMaxResults(1);

		List<User> listUsers = query.getResultList();
		if (!listUsers.isEmpty()) {
			user = listUsers.get(0);
		}
		return user;
	}

	@Override
	public void add(User user) {
		em.persist(user);
	}

	@Override
	public List<User> findAll() {
		CriteriaQuery<User> criteriaQuery = em.getCriteriaBuilder().createQuery(User.class);
		@SuppressWarnings("unused")
		Root<User> root = criteriaQuery.from(User.class);
		return em.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public List<User> findAll(Sort sort) {
		return null;
	}

	@Override
	public List<User> findAll(Iterable<Integer> ids) {
		return null;
	}

	@Override
	public <S extends User> List<S> save(Iterable<S> entities) {
		return null;
	}

	@Override
	public void flush() {
	}

	@Override
	public <S extends User> S saveAndFlush(S entity) {
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<User> entities) {
	}

	@Override
	public void deleteAllInBatch() {
	}

	@Override
	public User getOne(Integer id) {
		return null;
	}

	@Override
	public <S extends User> List<S> findAll(Example<S> example) {
		return null;
	}

	@Override
	public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
		return null;
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		return null;
	}

	@Override
	public <S extends User> S save(S entity) {
		return null;
	}

	@Override
	public User findOne(Integer id) {
		return null;
	}

	@Override
	public boolean exists(Integer id) {
		return false;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void delete(Integer id) {
	}

	@Override
	public void delete(User entity) {
	}

	@Override
	public void delete(Iterable<? extends User> entities) {
	}

	@Override
	public void deleteAll() {
	}

	@Override
	public <S extends User> S findOne(Example<S> example) {
		return null;
	}

	@Override
	public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
		return null;
	}

	@Override
	public <S extends User> long count(Example<S> example) {
		return 0;
	}

	@Override
	public <S extends User> boolean exists(Example<S> example) {
		return false;
	}

}
