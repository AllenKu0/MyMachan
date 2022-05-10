package com.example.mymachan.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

//import com.example.mymachan.Component.DaggerLoginComponent;
import com.example.mymachan.Application;
import com.example.mymachan.Component.DaggerLoginComponent;
import com.example.mymachan.Component.LoginComponent;
import com.example.mymachan.PurchaseReceiveActivity;
import com.example.mymachan.R;
import com.example.mymachan.base.BaseActivity;
import com.example.mymachan.databinding.ActivityLoginBinding;
import com.example.mymachan.databinding.ActivityMainBinding;
import com.example.mymachan.utils.sharepreference.LoginPreferencesProvider;

import java.util.List;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity implements LoginContract.View  {
    private final String TAG = this.getClass().getName();
    @Inject
    LoginContract.Presenter<LoginContract.View> presenter;

    @Inject
    LoginPreferencesProvider loginPreferencesProvider;

    private LoginComponent component;
    private ActivityLoginBinding activityLoginBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        presenter.onAttached(this);
    }

    @Override
    public void init() {
        component = DaggerLoginComponent.builder()
                .applicationComponent(((Application) getApplication()).getApplicationComponent())
                .build();
        component.inject(this);
        activityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        activityLoginBinding.setView(this);
    }

    @Override
    public void onLoginClick() {
        Log.e(TAG, "onLoginClick: bbbbbbbbbb" );
        presenter.onLoginEvent(activityLoginBinding.getNumber());
    }

    @Override
    public void onSelectOrgClick() {
        Log.e(TAG, "onSelectOrgClick: aaaaaaaaaaaa" );
        presenter.getFactoryList();
    }

    @Override
    public void startMainActivity() {
        Intent intent = new Intent(LoginActivity.this, PurchaseReceiveActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onGetOrgList(List<String> itemList) {
        showItemDialog(itemList,onFactoryListClick(itemList));
    }

    @Override
    public DialogInterface.OnClickListener onFactoryListClick(List<String> idList) {
        return new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                loginPreferencesProvider.setOrgId(idList.get(i).split(" ")[0]);
                showToast(idList.get(i));
            }
        };
    }
}