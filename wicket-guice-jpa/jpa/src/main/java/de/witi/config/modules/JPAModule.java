package de.witi.config.modules;

import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.ServletModule;
import de.witi.JPAInitializer;
import de.witi.data.dao.Dao;
import de.witi.data.dao.jpa.JPADao;

/**
 * JPA Module.
 *
 * @author Witold Czaplewski - http://50226.de
 */
public class JPAModule extends ServletModule {

    /**
     * (non-Javadoc)
     * @see com.google.inject.ServletModule#configure()
     */
    @Override
    protected void configureServlets() {
        install(new JpaPersistModule("jpaUnit"));
        filter("/*").through(PersistFilter.class);

        bind(JPAInitializer.class).asEagerSingleton();

        //dao stuff
        bind(Dao.class).to(JPADao.class);
    }
}
