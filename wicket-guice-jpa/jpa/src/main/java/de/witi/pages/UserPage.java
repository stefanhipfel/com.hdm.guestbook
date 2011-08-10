package de.witi.pages;

import org.apache.wicket.PageParameters;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;

import com.google.inject.Inject;
import de.witi.data.dao.Dao;
import de.witi.entity.User;
import java.util.List;
import org.apache.wicket.model.LoadableDetachableModel;

/**
 * User page.
 *
 * @author Witold Czaplewski - http://50226.de
 */
public class UserPage extends WebPage {

    private static final long serialVersionUID = 1L;
    @Inject
    private Dao dao;

    public UserPage(final PageParameters pp) {
        final Form<User> form = new Form<User>("form", new CompoundPropertyModel<User>(new User()));
        form.add(new TextField<String>("name").setRequired(true));
        form.add(new TextField<String>("surname").setRequired(true));

        final WebMarkupContainer wmc = new WebMarkupContainer("list");

        wmc.add(new ListView<User>("list", new LoadableDetachableModel<List<User>>() {

            private static final long serialVersionUID = 1L;

            @Override
            protected List<User> load() {
                return dao.findAll(User.class);
            }
        }) {

            private static final long serialVersionUID = 1L;

            @Override
            protected void populateItem(final ListItem<User> item) {
                final User user = item.getModelObject();
                item.add(new Label("name", user.getName()));
                item.add(new Label("surname", user.getPassword()));
            }
        });

        wmc.setOutputMarkupId(true);
        add(wmc);

        form.add(new AjaxSubmitLink("submit") {

            private static final long serialVersionUID = 1L;

            @Override
            protected void onSubmit(final AjaxRequestTarget target, final Form<?> form) {
                final User u = (User) form.getModelObject();
                final User user = new User();
                user.setName(u.getName());
                user.setPassword(u.getName());
                dao.save(user);
                target.addComponent(wmc);
            }
        });

        add(form);
    }
}
