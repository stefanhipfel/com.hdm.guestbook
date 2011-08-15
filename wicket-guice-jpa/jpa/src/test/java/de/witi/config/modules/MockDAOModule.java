package de.witi.config.modules;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.AbstractModule;
import de.witi.data.dao.Dao;
import de.witi.entity.User;

/**
 * Mock DAO module.
 *
 * @author Witold Czaplewski - http://50226.de
 */
public class MockDAOModule extends AbstractModule {

    /* (non-Javadoc)
     * @see com.google.inject.AbstractModule#configure()
     */
    @Override
    protected void configure() {

//        final User user = new User();
//        user.setName("name");
//        user.setPassword("password");
//
//        final List<User> users = new ArrayList<User>();
//        users.add(user);
//
//        Dao mockDAO = mock(Dao.class);
//        when(mockDAO.countAll(User.class)).thenReturn(1);
//        when(mockDAO.findAll(User.class)).thenReturn(users);
//        when(mockDAO.load(User.class, anyInt())).thenReturn(user);
//
//        bind(Dao.class).toInstance(mockDAO);
    }
}
