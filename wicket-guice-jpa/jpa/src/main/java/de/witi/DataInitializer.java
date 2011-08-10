package de.witi;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import de.witi.data.dao.Dao;
import de.witi.entity.User;

/**
 * Initializer for some sample data.
 *
 * @author Witold Czaplewski - http://50226.de
 */
@Singleton
public class DataInitializer {

    private static final String[] NAMES = {"Hans", "Willy", "Manfred", "Peter"};
    private static final String[] SURNAMES = {"Schuhmacher", "Müller", "Schneider", "Zimmer"};

    @Inject
    public DataInitializer(final Dao dao) {
        for (int i = 0; i < 10; ++i) {
            final User user = new User();
            user.setName(NAMES[(int) (Math.random() * NAMES.length)]);
            user.setPassword(SURNAMES[(int) (Math.random() * SURNAMES.length)]);
            dao.save(user);
        }
    }
}
