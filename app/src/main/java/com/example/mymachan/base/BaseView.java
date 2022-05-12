package com.example.mymachan.base;

import android.app.DatePickerDialog;
import android.content.DialogInterface;

import androidx.annotation.StringRes;

import java.util.List;

public interface BaseView {
    void init();

    void showProgressDialog(@StringRes int text);

    void dismissProgressDialog();

    void showSelectDialog(@StringRes int text, DialogInterface.OnClickListener onClickListener);

    void showSelectDialog(String text, DialogInterface.OnClickListener onClickListener);


    void showItemDialog(List<String> list, DialogInterface.OnClickListener onClickListener);

    void showDatePickerDialog(DatePickerDialog.OnDateSetListener onDateSetListener);

    String getResourceString(@StringRes int text);

    String getResourceString(@StringRes int text, Object... args);

    String getTodayTime();
    void showToast(String text);

    void showToast(@StringRes int text);

}
