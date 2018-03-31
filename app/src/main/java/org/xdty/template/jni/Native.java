package org.xdty.template.jni;

public class Native {

    public native String stringFromJNI();

    private Native() {}

    public static Native getInstance() {
        return SingletonHelper.sINSTANCE;
    }

    private final static class SingletonHelper {
        private final static Native sINSTANCE = new Native();
    }
}
