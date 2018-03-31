package org.xdty.template.model.setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SettingImpl implements Setting {

    private SharedPreferences mPrefs;

    private SettingImpl() {
    }

    public static SettingImpl getInstance() {
        return SingletonHelper.sINSTANCE;
    }

    public void init(Context context) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    private final static class SingletonHelper {
        private final static SettingImpl sINSTANCE = new SettingImpl();
    }

}
