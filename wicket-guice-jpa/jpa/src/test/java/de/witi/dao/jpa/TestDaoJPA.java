package de.witi.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.persist.UnitOfWork;
import de.witi.config.modules.DataModule;
import de.witi.entity.User;
import de.witi.data.dao.Dao;

/**
 * Test DAO Jpa.
 *
 * @author Witold Czaplewski - http://50226.de
 */
public class TestDaoJPA {

    @Inject
    private Dao dao;
    private User user;
    @Inject
    private UnitOfWork workManager;

    @Before
    public void startTransaction() {
        Injector injector = Guice.createInjector(new DataModule() {

            @Override
            protected boolean initData() {
                return false;
            }
        });

        injector.injectMembers(this);

        workManager.begin();

        user = new User();
        user.setName("name");
        user.setPassword("password");
        dao.save(user);
    }

    @After
    public void endTransaction() {
        workManager.end();
    }

    /**
     * Test method for {@link witi.data.dao.jpa.EventDaoJPAImp#findAll()}.
     */
    @Test
    public void testFindAll() {
        final List<User> users = new ArrayList<User>();
        users.add(user);
        Assert.assertEquals(users, dao.findAll(User.class));
    }

    /**
     * Test method for {@link witi.data.dao.jpa.EventDaoJPAImp#countAll()}.
     */
    @Test
    public void testCountAll() {
        Assert.assertEquals(1, dao.countAll(User.class));
    }

    /**
     * Test method for {@link witi.data.dao.jpa.AbstractDaoJPAImpl#delete(witi.data.dataobjects.DomainObject)}.
     */
    @Test
    public void testDelete() {
        dao.delete(dao.load(User.class, user.getName()));
        Assert.assertEquals(0, dao.countAll(User.class));
    }

    /**
     * Test method for {@link witi.data.dao.jpa.AbstractDaoJPAImpl#load(java.io.Serializable)}.
     */
    @Test
    public void testLoad() {
        User user2 = dao.load(User.class, user.getName());
        Assert.assertEquals(user, user2);
    }

    /**
     * Test method for {@link witi.data.dao.jpa.AbstractDaoJPAImpl#save(witi.data.dataobjects.DomainObject)}.
     */
    @Test
    public void testSave() {
        //if we have got this far then save works
    }
}
