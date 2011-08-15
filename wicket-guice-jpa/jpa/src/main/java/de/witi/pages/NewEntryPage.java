package de.witi.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.CompoundPropertyModel;

import com.google.inject.Inject;
import de.witi.data.dao.Dao;
import de.witi.entity.Entry;
import java.sql.Date;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.TextArea;

/**
 * User page.
 *
 * @author Witold Czaplewski - http://50226.de
 */
public class NewEntryPage extends WebPage {

    private static final long serialVersionUID = 1L;
    @Inject
    private Dao dao;

    public NewEntryPage() {
        
        final Form<Entry> loginForm = new Form<Entry>("newEntry", new CompoundPropertyModel<Entry>(new Entry()));  
        loginForm.add(new TextArea("text").setRequired(true));
        loginForm.add(new Button("submit") {
            private static final long serialVersionUID = 1L;
            @Override
            public void onSubmit() {                
                final Entry u = (Entry) getForm().getModelObject();
                final Entry entry = new Entry();
                entry.setUser("Peter");
                entry.setText(u.getText());
                entry.setTimetamp(new Date(System.currentTimeMillis()));             
                dao.save(entry);   
                setResponsePage(OverviewPage.class);
            }
        });
        add(loginForm);    
       
    }
}
