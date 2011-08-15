/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.witi.pages;

import de.witi.session.GuestbookSession;
import org.apache.wicket.Page;
import org.apache.wicket.authorization.strategies.page.SimplePageAuthorizationStrategy;

/**
 *
 * @author stefan
 */
public class UserLoginPageAuthStrategy extends SimplePageAuthorizationStrategy{

    public UserLoginPageAuthStrategy(Class<? extends Page> signInPageClass)
    {
        super(SecurePageInterface.class, signInPageClass);
    }
    
    @Override
    protected boolean isAuthorized() {
        return GuestbookSession.get().isUserLogin();
    }
    
}
