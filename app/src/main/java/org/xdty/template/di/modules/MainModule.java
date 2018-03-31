package org.xdty.template.di.modules;

import org.xdty.template.contract.MainContract;
import org.xdty.template.presenter.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    private MainContract.View mView;

    public MainModule(MainContract.View view) {
        mView = view;
    }

    @Provides
    MainContract.View provideView() {
        return mView;
    }

    @Provides
    MainContract.Presenter providePresenter() {
        return new MainPresenter(mView);
    }

}
