package de.witi;

import org.apache.wicket.guice.GuiceComponentInjector;
import org.apache.wicket.protocol.http.WebApplication;

import com.google.inject.Guice;
import de.witi.pages.HomePage;
import de.witi.config.modules.DataModule;
import de.witi.config.modules.JPAModule;
import de.witi.pages.LoginPage;
import de.witi.pages.UserLoginPageAuthStrategy;
import de.witi.pages.UserPage;
import de.witi.session.GuestbookSession;
import org.apache.wicket.Request;
import org.apache.wicket.Response;
import org.apache.wicket.Session;

/**
 * Application class.
 *
 * @author Witold Czaplewski - http://50226.de
 */
public class WicketApplication extends WebApplication {

    /**
     * Constructor
     */
    public WicketApplication() {
    }

    protected GuiceComponentInjector getGuiceInjector() {
        return new GuiceComponentInjector(this, Guice.createInjector(new JPAModule(), new DataModule()));
    }

    @Override
    protected void init() {
        super.init();

        mountBookmarkablePage("user", UserPage.class);

        addComponentInstantiationListener(getGuiceInjector());
        
        getSecuritySettings().setAuthorizationStrategy(new UserLoginPageAuthStrategy(LoginPage.class));
    }

    /* (non-Javadoc)
     * @see org.apache.wicket.Application#getHomePage()
     */
    @Override
    public Class<HomePage> getHomePage() {
        return HomePage.class;
    }
    @Override
    public Session newSession(Request request, Response response){
        return new GuestbookSession(request);
    }
}
