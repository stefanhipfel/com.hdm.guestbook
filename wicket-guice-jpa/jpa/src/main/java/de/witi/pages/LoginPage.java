package de.witi.pages;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import com.google.inject.Inject;
import de.witi.data.dao.Dao;
import de.witi.entity.User;
import java.util.List;
import org.apache.wicket.markup.html.form.Button;

/**
 * User page.
 *
 * @author Witold Czaplewski - http://50226.de
 */
public class LoginPage extends WebPage {

    private static final long serialVersionUID = 1L;
    @Inject
    private Dao dao;

    public LoginPage() {
        final Form<User> loginForm = new Form<User>("login", new CompoundPropertyModel<User>(new User()));        
        loginForm.add(new TextField<String>("name").setRequired(true));
        loginForm.add(new TextField<String>("password").setRequired(true));
        loginForm.add(new Button("register") {
            private static final long serialVersionUID = 1L;                     
            @Override
            public void onSubmit() {                
                setResponsePage(RegisterPage.class);
            }
        });
        loginForm.add(new Button("login") {
            private static final long serialVersionUID = 1L;                     
            @Override
            public void onSubmit() {                
                final User u = (User) getForm().getModelObject();
                final User user = new User();
                user.setName(u.getName());
                user.setPassword(u.getPassword());
                System.out.println("Name: "+u.getName());
                System.out.println("Password: "+u.getPassword());     
                List<User> users = dao.findAll(User.class);
                int i =0;
                boolean found = false;
                while(i < users.size() && !found) {
                    if(users.get(i).equals(user))
                        found = true;
                    i++;
                }
                if(found) {
                    setResponsePage(HomePage.class);
                }
            }
        });
        add(loginForm);
    }
}
