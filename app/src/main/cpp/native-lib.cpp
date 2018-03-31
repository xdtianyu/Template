#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

JNICALL
Java_org_xdty_template_jni_Native_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
