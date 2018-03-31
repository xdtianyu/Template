package org.xdty.template.application;

import org.xdty.template.di.AppComponent;
import org.xdty.template.di.DaggerAppComponent;
import org.xdty.template.di.modules.AppModule;

public class Application extends android.app.Application {

    static {
        System.loadLibrary("native-lib");
    }

    private static AppComponent sAppComponent;

    private static Application sApplication;


    public static AppComponent getAppComponent() {
        return sAppComponent;
    }

    public static Application getApplication() {
        return sApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;

        sAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        sAppComponent.inject(this);
    }
}
