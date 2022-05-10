package com.example.mymachan.ui.login;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.mymachan.R;
import com.example.mymachan.api.ErpAPI;
import com.example.mymachan.api.MachanAPI;
import com.example.mymachan.api.pojo.response.OrgVResponse;
import com.example.mymachan.api.pojo.response.PersonVResponse;
import com.example.mymachan.base.BasePresenter;
import com.example.mymachan.rxjava.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

public class LoginPresenter<V extends LoginContract.View> extends BasePresenter<V> implements LoginContract.Presenter<V> {
    private final String TAG = this.getClass().getName();

    @Inject
    public LoginPresenter(MachanAPI machanAPI, ErpAPI erpAPI, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(machanAPI, erpAPI, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onLoginEvent(String account) {
        getmView().showProgressDialog(R.string.hint_login);

        getCompositeDisposable().add(getMachanAPI()
                .getPersonV(getmView().getResourceString(R.string.api_request_person, account))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribeWith(new DisposableObserver<PersonVResponse>() {
                    @Override
                    public void onNext(@NonNull PersonVResponse personVResponse) {
                        getmView().dismissProgressDialog();
                        getmView().startMainActivity();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        getmView().dismissProgressDialog();
                        if (e.getMessage().equals("HTTP 404 Not Found")) {
                            Log.e(TAG, "onError: 404");
                        } else {
                            Log.e(TAG, "onError: 404");
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                })
        );
    }

    @Override
    public void getFactoryList() {
        getmView().showProgressDialog(R.string.hint_loading);

        getCompositeDisposable().add(getMachanAPI()
                .getOrgV(getmView().getResourceString(R.string.api_request_org))
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribeWith(new DisposableObserver<List<OrgVResponse>>() {
                            @Override
                            public void onNext(@NonNull List<OrgVResponse> orgVResponses) {
                                getmView().dismissProgressDialog();
                                List<String> itemList = new ArrayList<>();
                                for(OrgVResponse vResponse : orgVResponses){
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append(vResponse.getOrgId()).append(" ").append(vResponse.getOrgName());
                                    itemList.add(stringBuilder.toString());
                                }
                                getmView().onGetOrgList(itemList);
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {
                                getmView().dismissProgressDialog();
                                getmView().showToast(R.string.error_code_network);
                            }

                            @Override
                            public void onComplete() {

                            }
                        }));

    }
}
