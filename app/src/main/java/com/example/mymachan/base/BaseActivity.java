package com.example.mymachan.base;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mymachan.R;
import com.example.mymachan.utils.CommonUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {
    private ProgressDialog mProgressDialog;
    private Calendar mCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showProgressDialog(@StringRes int text) {
        dismissProgressDialog();
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage(this.getResources().getString(text));
        mProgressDialog.setCancelable(false);
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.show();
    }

    @Override
    public void dismissProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    @Override
    public void showSelectDialog(@StringRes int text, DialogInterface.OnClickListener onClickListener) {
        new AlertDialog.Builder(this)
                .setMessage(text)
                .setPositiveButton(R.string.hint_confirm, onClickListener)
                .setNegativeButton(R.string.hint_cancel, onClickListener)
                .setCancelable(false)
                .create()
                .show();
    }

    @Override
    public void showSelectDialog(String text, DialogInterface.OnClickListener onClickListener) {
        new AlertDialog.Builder(this)
                .setMessage(text)
                .setPositiveButton(R.string.hint_confirm, onClickListener)
                .setNegativeButton(R.string.hint_cancel, onClickListener)
                .setCancelable(false)
                .create()
                .show();
    }

    @Override
    public void showItemDialog(List<String> list, DialogInterface.OnClickListener onClickListener) {
        new AlertDialog.Builder(this)
                .setItems(list.toArray(new String[list.size()]), onClickListener)
                .create()
                .show();
    }

    @Override
    public void showDatePickerDialog(DatePickerDialog.OnDateSetListener onDateSetListener) {
        DatePickerDialog dialog = new DatePickerDialog(this,
                onDateSetListener,
                mCalendar.get(Calendar.YEAR),
                mCalendar.get(Calendar.MONTH),
                mCalendar.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }

    @Override
    public String getResourceString(@StringRes int text) {
        return getResources().getString(text);
    }

    @Override
    public String getResourceString(@StringRes int text, Object... args) {
        return CommonUtils.getStringResourceFormat(this, text, args);
    }

//    @Override
//    public void showCategoryDialog(CategoryDialog.OnClickListener onClickListener) {
//        CategoryDialog dialog = new CategoryDialog(this);
//        dialog.setOnSubmitClickListener(onClickListener);
//        dialog.show();
//    }
//
//    @Override
//    public void showStorageDialog(StorageDialog.OnClickListener onSubmitClickListener) {
//        StorageDialog dialog = new StorageDialog(this);
//        dialog.setOnSubmitClickListener(onSubmitClickListener);
//        dialog.show();
//    }
//    @Override
//    public void showStorageSearchDialog(StorageSearchDialog.OnClickListener onSubmitClickListener) {
//        StorageSearchDialog dialog = new StorageSearchDialog(this);
//        dialog.setOnSubmitClickListener(onSubmitClickListener);
//        dialog.show();
//    }
//
//    @Override
//    public void showScrapDialog(ScrapDialog.OnClickListener onClickListener) {
//        ScrapDialog dialog = new ScrapDialog(this);
//        dialog.setOnSubmitClickListener(onClickListener);
//        dialog.show();
//    }
//
//    @Override
//    public void showShelfDialog(ShelfDialog.OnClickListener onClickListener) {
//        ShelfDialog dialog = new ShelfDialog(this);
//        dialog.setOnSubmitClickListener(onClickListener);
//        dialog.show();
//    }
//
//    @Override
//    public String getResourceString(@StringRes int text) {
//        return getResources().getString(text);
//    }
//
//    @Override
//    public String getResourceString(@StringRes int text, Object... args) {
//        return CommonUtils.getStringResourceFormat(this, text, args);
//    }

    @Override
    public String getTodayTime() {
        String dateformat = "yyyyMMdd";
        Calendar mCal = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat(dateformat);
        String today = df.format(mCal.getTime());
        return today;
    }

    @Override
    public void showToast(@StringRes int text) {
       Toast.makeText(this, text, Toast.LENGTH_SHORT);
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT);
    }
}
