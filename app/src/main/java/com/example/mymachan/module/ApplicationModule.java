package com.example.mymachan.module;

import android.content.Context;

import com.example.mymachan.Application;
import com.example.mymachan.rxjava.SchedulerProvider;
import com.example.mymachan.rxjava.SchedulerProviderImp;
import com.example.mymachan.utils.sharepreference.LoginPreferences;
import com.example.mymachan.utils.sharepreference.LoginPreferencesProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

//    @Provides
//    public static Application provideApplication(){
//        return new Application();
//    }
    @Provides
    public Context provideContext() {
        return application.getApplicationContext();
    }

    @Provides
    public static SchedulerProvider provideSchedulerProvider(SchedulerProviderImp schedulerProviderImp) {
        return schedulerProviderImp;
    }

    @Provides
    public static Observable<Object> provideUIObservable(SchedulerProvider schedulerProvider) {
        return Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Object> e) throws Exception {
                e.onComplete();
            }
        }).subscribeOn(schedulerProvider.io()).observeOn(schedulerProvider.ui());
    }

    @Provides
    public static CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @Singleton
    public LoginPreferencesProvider provideLoginPreferencesProvider(LoginPreferences loginPreferences) {
        return loginPreferences;
    }
//
//    @Provides
//    @Singleton
//    public PrinterPreferencesProvider providePrinterPreferencesProvider(PrinterPreferences printerPreferences) {
//        return printerPreferences;
//    }
//
//    @Provides
//    @Singleton
//    public SettingPreferencesProvider provideSettingPreferencesProvider(SettingPreferences settingPreferences) {
//        return settingPreferences;
//    }
//
//    @Provides
//    @Singleton
//    public WeightDevicePreferencesProvider provideWeightDevicePreferencesProvider(WeightDevicePreferences weightDevicePreferences) {
//        return weightDevicePreferences;
//    }
}
