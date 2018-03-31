package org.xdty.template.utils;

import com.google.gson.Gson;

public class Utils {

    private Gson mGson;

    private Utils() {
        mGson = new Gson();
    }

    public Gson getGson() {
        return mGson;
    }

    public static Utils getInstance() {
        return SingletonHelper.sINSTANCE;
    }

    private final static class SingletonHelper {
        private final static Utils sINSTANCE = new Utils();
    }
}
