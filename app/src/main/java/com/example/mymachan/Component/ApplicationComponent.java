package com.example.mymachan.Component;

import com.example.mymachan.Application;
import com.example.mymachan.api.ErpAPI;
import com.example.mymachan.api.MachanAPI;
import com.example.mymachan.module.APIModule;
import com.example.mymachan.module.ApplicationModule;
import com.example.mymachan.rxjava.SchedulerProvider;
import com.example.mymachan.utils.api.soap.requestValue.RequestValueProvider;
import com.example.mymachan.utils.sharepreference.LoginPreferencesProvider;

import javax.inject.Singleton;

import dagger.Component;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

@Singleton
@Component(modules ={
        ApplicationModule.class,
        APIModule.class,
})
public interface ApplicationComponent {
    void inject(Application application);

    ErpAPI getErpAPI();

    MachanAPI getMachanAPI();

    SchedulerProvider getSchedulerProvider();

    Observable<Object> getObservable();

    CompositeDisposable getCompositeDisposable();

    RequestValueProvider getRequestValueProvider();

    LoginPreferencesProvider getLoginPreferencesProvider();
}
