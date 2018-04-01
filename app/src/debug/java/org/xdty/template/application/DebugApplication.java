package org.xdty.template.application;

import android.os.StrictMode;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import org.xdty.template.utils.OkHttp;

import io.reactivex.Completable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

public class DebugApplication extends Application {
    private final static String TAG = DebugApplication.class.getSimpleName();

    @Override
    public void onCreate() {

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .detectLeakedClosableObjects()
                .penaltyLog()
                //.penaltyDeath()
                .build());

        CompositeDisposable disposable = new CompositeDisposable();
        disposable.add(Completable.complete().subscribeOn(Schedulers.io()).subscribe(new Action() {
            @Override
            public void run() throws Exception {
                Stetho.initialize(
                        Stetho.newInitializerBuilder(DebugApplication.this)
                                .enableDumpapp(
                                        Stetho.defaultDumperPluginsProvider(DebugApplication.this))
                                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(
                                        DebugApplication.this))
                                .build());
            }
        }));
        disposable.dispose();

        OkHttp.getInstance().addNetworkInterceptor(new StethoInterceptor());

        super.onCreate();
    }
}
