package com.grupogo.mvvmtemplateapp;

import android.app.Application;

import com.grupogo.mvvmtemplateapp.dagger.components.AppComponent;
import com.grupogo.mvvmtemplateapp.dagger.components.DaggerAppComponent;

/**
 * Created by jorge_cmata on 18/10/17.
 */

public class TemplateApplication extends Application {

    AppComponent mAppComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder().build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
