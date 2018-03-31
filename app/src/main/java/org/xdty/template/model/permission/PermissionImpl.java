package org.xdty.template.model.permission;

import android.content.Context;

public class PermissionImpl implements Permission {

    private PermissionImpl() {}

    public void init(Context context) {

    }

    public static PermissionImpl getInstance() {
        return SingletonHelper.sINSTANCE;
    }

    private final static class SingletonHelper {
        private final static PermissionImpl sINSTANCE = new PermissionImpl();
    }
}
