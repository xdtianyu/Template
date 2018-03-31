package org.xdty.template.model.database;

import org.xdty.template.application.Application;

import javax.inject.Inject;

import io.requery.Persistable;
import io.requery.sql.EntityDataStore;

public class DatabaseImpl implements Database {

    @Inject
    EntityDataStore<Persistable> mDataStore;

    private DatabaseImpl() {
        Application.getAppComponent().inject(this);
    }

    public static DatabaseImpl getInstance() {
        return SingletonHelper.sINSTANCE;
    }

    private final static class SingletonHelper {
        private final static DatabaseImpl sINSTANCE = new DatabaseImpl();
    }
}
