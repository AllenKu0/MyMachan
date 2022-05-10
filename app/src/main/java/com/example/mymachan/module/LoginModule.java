package com.example.mymachan.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mymachan.annotation.LoginScoped;
import com.example.mymachan.ui.login.LoginContract;
import com.example.mymachan.ui.login.LoginPresenter;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class LoginModule {

    @Provides
    @LoginScoped
    static AppCompatActivity provideAppCompatActivity(){
        return new AppCompatActivity();
    }

    @Provides
    @LoginScoped
    static Context provideContext(AppCompatActivity activity){
        return activity;
    }

    @Provides
    @LoginScoped
    static LoginContract.Presenter<LoginContract.View> providePresenter
            (LoginPresenter<LoginContract.View> presenter){
        return presenter;
    }
}
