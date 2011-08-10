package com.hdm.guestbook.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hdm.guestbook.model.Login;

@Component
public class LoginDao {
	// Injected database connection:
	@PersistenceContext
	private EntityManager em;

	// Stores a new guest:
	@Transactional
	public void persist(Login login) {
		em.persist(login);
	}

	public Login getLoginByName(String name) {
		TypedQuery<Login> query = em.createQuery(
				"SELECT g FROM Login g WHERE g.name = '" + name
						+ "'", Login.class);
		return query.getSingleResult();
	}
	
	@Transactional
	public void register(Login login) throws DataIntegrityViolationException {
		em.persist(login);
	}

	// Retrieves all the guests:
	public List<Login> getAllLogins() {
		TypedQuery<Login> query = em.createQuery(
				"SELECT g FROM Login g ORDER BY g.id", Login.class);
		return query.getResultList();
	}
}