package de.witi.wicket;

import org.apache.wicket.guice.GuiceComponentInjector;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import de.witi.pages.HomePage;
import de.witi.WicketApplication;
import de.witi.config.modules.MockDAOModule;
import de.witi.pages.UserPage;

/**
 * Test wicket page.
 *
 * @author Witold Czaplewski - http://50226.de
 */
public class TestWicketPages {

    private WicketTester tester;

    @Before
    public void setup() {
        tester = new WicketTester(new WicketApplication() {
            /* (non-Javadoc)
             * @see witi.WicketApplication#getGuiceInjector()
             */

            @Override
            protected GuiceComponentInjector getGuiceInjector() {
                return new GuiceComponentInjector(this, Guice.createInjector(new MockDAOModule()));
            }
        });
    }

    @Test
    public void testStartPage() {
        tester.startPage(HomePage.class);
    }

    @Test
    public void testUserPage() {
        tester.startPage(UserPage.class);
    }
}
