package com.example.mymachan;

import android.content.Context;

import androidx.multidex.MultiDex;

import com.example.mymachan.Component.ApplicationComponent;
import com.example.mymachan.Component.DaggerApplicationComponent;
import com.example.mymachan.module.ApplicationModule;


public class Application extends android.app.Application {
    private ApplicationComponent mApplicationComponent;
    public Application get(Context context){
        return (Application) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                                .applicationModule(new ApplicationModule(this))
                                .build();
        mApplicationComponent.inject(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    public ApplicationComponent getApplicationComponent(){
        return mApplicationComponent;
    }
}
