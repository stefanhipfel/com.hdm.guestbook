package de.witi;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import de.witi.data.dao.Dao;
import de.witi.entity.Entry;
import de.witi.entity.User;
import java.sql.Date;

/**
 * Initializer for some sample data.
 *
 * @author Witold Czaplewski - http://50226.de
 */
@Singleton
public class DataInitializer {

    private static final String[] NAMES = {"Hans", "Willy", "Manfred", "Peter"};
    private static final String[] PASSWORDS = {"Schuhmacher", "Müller", "Schneider", "Zimmer"};

    @Inject
    public DataInitializer(final Dao dao) {
        for (int i = 0; i < 3; ++i) {
            final User user = new User();
            user.setName(NAMES[i]);
            user.setPassword(PASSWORDS[i]);
            dao.save(user);
        }
        for (int i = 0; i < 3; ++i) {
            Entry entry = new Entry();
            entry.setUser(NAMES[i]);
            entry.setTimetamp(new Date(System.currentTimeMillis()));
            entry.setText(PASSWORDS[i]);
            dao.save(entry);
        }
        
    }
}
