package com.example.mymachan.ui.login;

import android.content.DialogInterface;

import com.example.mymachan.base.BaseAttacher;
import com.example.mymachan.base.BaseView;

import java.util.List;

public interface LoginContract {
    interface View extends BaseView{
        void onLoginClick();

        void onSelectOrgClick();

        void startMainActivity();

        void onGetOrgList(List<String> itemList);

        DialogInterface.OnClickListener onFactoryListClick(List<String> idList);
    }
    interface Presenter<V extends View> extends BaseAttacher<V>{
        void onLoginEvent(String account);

        void getFactoryList();
    }
}
