package org.xdty.template.di;

import org.xdty.template.activity.MainActivity;
import org.xdty.template.di.modules.AppModule;
import org.xdty.template.di.modules.MainModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { MainModule.class, AppModule.class })
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
