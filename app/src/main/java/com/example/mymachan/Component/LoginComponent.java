package com.example.mymachan.Component;

import com.example.mymachan.annotation.LoginScoped;
import com.example.mymachan.module.LoginModule;
import com.example.mymachan.ui.login.LoginActivity;

import dagger.Component;

@LoginScoped
@Component(dependencies = ApplicationComponent.class,
        modules = {
                LoginModule.class
        })
public interface LoginComponent {
    void inject(LoginActivity activity);
}
