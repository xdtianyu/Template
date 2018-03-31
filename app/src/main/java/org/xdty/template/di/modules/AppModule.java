package org.xdty.template.di.modules;

import com.google.gson.Gson;

import org.xdty.template.BuildConfig;
import org.xdty.template.application.Application;
import org.xdty.template.model.database.Database;
import org.xdty.template.model.database.DatabaseImpl;
import org.xdty.template.model.db.Models;
import org.xdty.template.model.permission.Permission;
import org.xdty.template.model.permission.PermissionImpl;
import org.xdty.template.model.setting.Setting;
import org.xdty.template.model.setting.SettingImpl;
import org.xdty.template.utils.Constants;
import org.xdty.template.utils.OkHttp;
import org.xdty.template.utils.Utils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.requery.Persistable;
import io.requery.android.sqlite.DatabaseSource;
import io.requery.sql.Configuration;
import io.requery.sql.ConfigurationBuilder;
import io.requery.sql.EntityDataStore;
import okhttp3.OkHttpClient;

@Module
public class AppModule {
    private Application app;

    public AppModule(Application application) {
        app = application;
    }

    @Singleton
    @Provides
    public Application provideApplication() {
        return app;
    }

    @Singleton
    @Provides
    public Setting provideSetting(Application app) {
        SettingImpl setting = SettingImpl.getInstance();
        setting.init(app);
        return setting;
    }

    @Singleton
    @Provides
    public Database provideDatabase() {
        return DatabaseImpl.getInstance();
    }

    @Singleton
    @Provides
    public Permission providePermission(Application app) {
        PermissionImpl permission = PermissionImpl.getInstance();
        permission.init(app);
        return permission;
    }

    @Singleton
    @Provides
    public Utils provideUtils() {
        return Utils.getInstance();
    }

    @Singleton
    @Provides
    public Gson provideGson(Utils utils) {
        return utils.getGson();
    }

    @Singleton
    @Provides
    public EntityDataStore<Persistable> provideDatabaseSource() {

        DatabaseSource source = new DatabaseSource(app, Models.DEFAULT,
                Constants.DB_NAME, Constants.DB_VERSION) {
            @Override
            protected void onConfigure(ConfigurationBuilder builder) {
                super.onConfigure(builder);
                builder.setQuoteColumnNames(true);
            }
        };
        source.setLoggingEnabled(BuildConfig.DEBUG);
        Configuration configuration = source.getConfiguration();

        return new EntityDataStore<>(configuration);
    }

    @Singleton
    @Provides
    public OkHttpClient provideOkHttpClient() {
        return OkHttp.getInstance().client();
    }

}
