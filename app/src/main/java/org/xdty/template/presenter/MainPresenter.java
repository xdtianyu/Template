package org.xdty.template.presenter;

import org.xdty.template.application.Application;
import org.xdty.template.contract.MainContract;

public class MainPresenter implements MainContract.Presenter{

    private MainContract.View mView;

    public MainPresenter(MainContract.View view) {
        mView = view;
        Application.getAppComponent().inject(this);
    }

    @Override
    public void start() {

    }
}
