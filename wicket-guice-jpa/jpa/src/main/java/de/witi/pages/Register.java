package de.witi.pages;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import com.google.inject.Inject;
import de.witi.data.dao.Dao;
import de.witi.entity.User;
import org.apache.wicket.markup.html.form.Button;

/**
 * User page.
 *
 * @author Witold Czaplewski - http://50226.de
 */
public class Register extends WebPage {

    private static final long serialVersionUID = 1L;
    @Inject
    private Dao dao;

    public Register(final PageParameters pp) {
        final Form<User> loginForm = new Form<User>("login", new CompoundPropertyModel<User>(new User()));        
        loginForm.add(new TextField<String>("name").setRequired(true));
        loginForm.add(new TextField<String>("password").setRequired(true));
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
                dao.save(user);
            }
        });

        add(loginForm);
    }
}
