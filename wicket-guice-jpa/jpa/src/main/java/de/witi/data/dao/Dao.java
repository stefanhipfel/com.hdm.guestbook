package de.witi.data.dao;

import java.io.Serializable;
import java.util.List;

/**
 * DAO Interface.
 *
 * @author Witold Czaplewski - http://50226.de
 */
public interface Dao {

    public <E extends Serializable> void save(final E o);

    public <E extends Serializable> void update(final E o);

    public <E extends Serializable> E load(final Class<E> clazz, Serializable id);

    public <E extends Serializable> void delete(final E o);

    public <E extends Serializable> List<E> findAll(final Class<E> clazz);

    public <E extends Serializable> int countAll(final Class<E> clazz);
    
    public <E extends Serializable> E find(final Class<E> clazz, final E o);
    
    public <E extends Serializable> boolean exists(final Class<E> clazz, final E o);
}
