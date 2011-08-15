package de.witi.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import com.google.inject.Inject;
import de.witi.data.dao.Dao;
import de.witi.entity.User;
import java.sql.BatchUpdateException;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.PasswordTextField;

/**
 * User page.
 *
 * @author Witold Czaplewski - http://50226.de
 */
public class RegisterPage extends WebPage {

    private static final long serialVersionUID = 1L;
    @Inject
    private Dao dao;

    public RegisterPage() {
        final Form<User> loginForm = new Form<User>("login", new CompoundPropertyModel<User>(new User()));        
        loginForm.add(new TextField<String>("name").setRequired(true));        
        loginForm.add(new PasswordTextField("password").setRequired(true));
        loginForm.add(new Button("register") {
            private static final long serialVersionUID = 1L;
            @Override
            public void onSubmit() {                
                final User u = (User) getForm().getModelObject();
                final User user = new User();
                user.setName(u.getName());
                user.setPassword(u.getPassword());
                System.out.println("Name: "+u.getName());
                System.out.println("Password: "+u.getPassword()); 
                if(dao.load(User.class, user.getName()) == null)
                    dao.save(user);   
                setResponsePage(HomePage.class);
            }
        });

        add(loginForm);
    }
}
