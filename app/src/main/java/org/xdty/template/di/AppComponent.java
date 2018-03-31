package org.xdty.template.di;

import org.xdty.template.application.Application;
import org.xdty.template.di.modules.AppModule;
import org.xdty.template.model.database.DatabaseImpl;
import org.xdty.template.presenter.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(Application application);

    void inject(MainPresenter mainPresenter);

    void inject(DatabaseImpl database);
}
