package de.witi.data.dao.jpa;

import com.google.inject.persist.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.EntityManager;


import de.witi.data.dao.Dao;

/**
 * JPA DAO.
 *
 * @author Witold Czaplewski - http://50226.de
 */
public class JPADao implements Dao {

    @Inject
    private EntityManager em;

    @Override
    @Transactional
    public <E extends Serializable> void delete(final E o) {
        em.remove(o);
    }

    @Override
    @Transactional
    public <E extends Serializable> E load(final Class<E> clazz, final Serializable id) {
        return em.find(clazz, id);
    }

    @Override
    @Transactional
    public <E extends Serializable> void save(final E o) {
        em.persist(o);
    }

    @Override
    @Transactional
    public <E extends Serializable> void update(final E o) {
        em.merge(o);
    }

    @Override
    @Transactional
    public <E extends Serializable> List<E> findAll(final Class<E> clazz) {
        return em.createQuery("from " + clazz.getAnnotation(Entity.class).name(), clazz).getResultList();
    }

    @Override
    @Transactional
    public <E extends Serializable> int countAll(final Class<E> clazz) {
        final String query = "count (e) from " + clazz.getSimpleName() + " e";
        return em.createQuery(query, Long.class).getSingleResult().intValue();
    }
}
