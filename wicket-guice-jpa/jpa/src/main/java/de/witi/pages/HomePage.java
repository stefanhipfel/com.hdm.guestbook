package de.witi.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

/**
 * Home page.
 *
 * @author Witold Czaplewski - http://50226.de
 */
public class HomePage extends WebPage {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor.
     */
    public HomePage() {
        // Add link
        add(new BookmarkablePageLink<Void>("login", OverviewPage.class));
    }
}
