package com.hdm.guestbook.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hdm.guestbook.model.Overview;

@Component
public class OverviewDao {
	// Injected database connection:
	@PersistenceContext
	private EntityManager em;

	// Stores a new guest:
	@Transactional
	public void persist(String user, String text, Date timestamp) {
		Overview newEntry = new Overview();
		newEntry.setText(text);
		newEntry.setTimetamp(timestamp);
		newEntry.setUser(user);
		em.persist(newEntry);
	}

	// Retrieves all the guests:
	public List<Overview> getAllEntries() {
		TypedQuery<Overview> query = em.createQuery(
				"SELECT g FROM Overview g ORDER BY g.id", Overview.class);
		return query.getResultList();
	}
}