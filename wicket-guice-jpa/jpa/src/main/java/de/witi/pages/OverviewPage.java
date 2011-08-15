package de.witi.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;

import com.google.inject.Inject;
import de.witi.data.dao.Dao;
import de.witi.entity.Entry;
import java.util.List;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.LoadableDetachableModel;

/**
 * User page.
 *
 * @author Witold Czaplewski - http://50226.de
 */
public class OverviewPage extends WebPage implements SecurePageInterface {

    private static final long serialVersionUID = 1L;
    @Inject
    private Dao dao;

    public OverviewPage() {
        final Form loginForm = new Form("overviewForm");
        loginForm.add(new Button("newEntry") {
            private static final long serialVersionUID = 1L;
            @Override
            public void onSubmit() {     
                setResponsePage(NewEntryPage.class);
            }
        });
        add(loginForm);
        
        final WebMarkupContainer wmc = new WebMarkupContainer("list");
        wmc.add(new ListView<Entry>("list", new LoadableDetachableModel<List<Entry>>() {

            private static final long serialVersionUID = 1L;

            @Override
            protected List<Entry> load() {
                return dao.findAll(Entry.class);
            }
        }) {

            private static final long serialVersionUID = 1L;

            @Override
            protected void populateItem(final ListItem<Entry> item) {
                final Entry entry = item.getModelObject();
                item.add(new Label("id", entry.getId()+""));
                item.add(new Label("user", entry.getUser()));
                item.add(new Label("timestamp", entry.getTimetamp().toString()));
                item.add(new Label("text", entry.getText()));
            }
        });

        wmc.setOutputMarkupId(true);
        add(wmc);        
    }
}
