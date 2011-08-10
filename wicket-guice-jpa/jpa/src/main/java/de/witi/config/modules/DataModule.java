package de.witi.config.modules;

import com.google.inject.AbstractModule;
import de.witi.DataInitializer;

/**
 * Data Module.
 *
 * @author Witold Czaplewski - http://50226.de
 */
public class DataModule extends AbstractModule {

    /**
     * (non-Javadoc)
     * @see com.google.inject.AbstractModule#configure()
     */
    @Override
    protected void configure() {
        if (initData()) {
            bind(DataInitializer.class).asEagerSingleton();
        }
    }

    /**
     * Should the data be initialized?
     *
     * @return true if data should be initialized else false
     */
    protected boolean initData() {
        return true;
    }
}
