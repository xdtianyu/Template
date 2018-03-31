package org.xdty.template.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.xdty.template.R;
import org.xdty.template.application.Application;
import org.xdty.template.contract.MainContract;
import org.xdty.template.di.DaggerMainComponent;
import org.xdty.template.di.modules.AppModule;
import org.xdty.template.di.modules.MainModule;
import org.xdty.template.jni.Native;
import org.xdty.template.model.permission.Permission;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @Inject
    MainContract.Presenter mPresenter;

    @Inject
    Permission mPermission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerMainComponent.builder()
                .appModule(new AppModule(Application.getApplication()))
                .mainModule(new MainModule(this))
                .build()
                .inject(this);

        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.sample_text);
        tv.setText(Native.getInstance().stringFromJNI());

        mPresenter.start();
    }

}
