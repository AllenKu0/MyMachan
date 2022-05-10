package com.example.mymachan.base;

import com.example.mymachan.api.ErpAPI;
import com.example.mymachan.api.MachanAPI;
import com.example.mymachan.rxjava.SchedulerProvider;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter <V extends BaseView> implements BaseAttacher<V>{
    private V mView;
    private MachanAPI machanAPI;
    private ErpAPI erpAPI;
    private SchedulerProvider schedulerProvider;
    private CompositeDisposable compositeDisposable;

    @Inject
    public BasePresenter(MachanAPI machanAPI, ErpAPI erpAPI, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        this.machanAPI = machanAPI;
        this.erpAPI = erpAPI;
        this.schedulerProvider = schedulerProvider;
        this.compositeDisposable = compositeDisposable;
    }

    public V getmView() {
        return mView;
    }

    public MachanAPI getMachanAPI() {
        return machanAPI;
    }

    public ErpAPI getErpAPI() {
        return erpAPI;
    }

    public SchedulerProvider getSchedulerProvider() {
        return schedulerProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    public void setCompositeDisposable(CompositeDisposable compositeDisposable) {
        this.compositeDisposable = compositeDisposable;
    }

    @Override
    public void onAttached(V view) {
        mView = view;
    }

    @Override
    public void onDetached() {
        mView = null;
    }
}
