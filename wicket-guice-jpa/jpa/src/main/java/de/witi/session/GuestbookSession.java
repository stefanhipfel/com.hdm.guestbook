/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.witi.session;

import com.google.inject.Inject;
import de.witi.data.dao.Dao;
import de.witi.entity.User;
import org.apache.wicket.Request;
import org.apache.wicket.Session;
import org.apache.wicket.injection.web.InjectorHolder;
import org.apache.wicket.protocol.http.WebSession;

/**
 *
 * @author stefan
 */
public class GuestbookSession extends WebSession{
    
    private static final long serialVersionUID = 1L;
    @Inject
    private Dao dao;
     
    String _userName;
    String _userPw;

    
    public GuestbookSession(Request request)
    {
        super (request);
        InjectorHolder.getInjector().inject(this);
    
    }
    
    public synchronized void setUser(User user)
    {
        _userName = user.getName(); dirty();
        _userPw = user.getPassword(); dirty();

    }
    
    public synchronized void clearUser()
    {
        _userName = null; dirty();
    }
    
    public synchronized User getUser()
    {

        if (_userName!=null) return dao.getSingleUser(_userName).get(0);
                return null;
    }
    
    public synchronized boolean isUserLogin()
    {
        return _userName!=null ? true : false;
    }
    
    public static GuestbookSession get()
    {
        return (GuestbookSession) Session.get();
    }
}
