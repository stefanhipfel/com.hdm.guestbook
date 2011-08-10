package de.witi;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.PersistService;

/**
 * JPA initializer.
 *
 * @author Witold Czaplewski - http://50226.de
 */
@Singleton
public class JPAInitializer {

    @Inject
    public JPAInitializer(final PersistService service) {
        service.start();
    }
}
