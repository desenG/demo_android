package com.djcanadastudio.demo_android;

import android.support.multidex.MultiDexApplication;

import com.facebook.FacebookSdk;

/**
 * Created by desenguo on 2016-03-07.
 */
public class App extends MultiDexApplication {
    public void onCreate() {
        super.onCreate();
        //Facebook SDK
        FacebookSdk.sdkInitialize(getApplicationContext());
    }
}
