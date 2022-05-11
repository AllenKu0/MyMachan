package com.example.mymachan.ui.receivegood.phurchasereceivegoodsearch;

import android.content.DialogInterface;

import com.example.mymachan.base.BaseAttacher;
import com.example.mymachan.base.BaseView;
import com.example.mymachan.ui.receivegood.phurchasereceivegoodsearch.PurchaseReceiveGoodSearch;

import java.util.List;

public interface PurchaseReceiveGoodsContract {
    interface View extends BaseView {
        void onSupplierMoreClick();

        void onGetSupplierList(List<String> list);

        void onGetPurchaseNumberList(List<String> list, int position);

        void onGetMaterialNumberList(List<String> list, int position);

        void onAddPurchaseNumberClick();

        void onAddMaterialNumberClick();

        void onSearchClick();

        DialogInterface.OnClickListener onPurchaseNumberDialogItemClick(List<String> list, int position);

        DialogInterface.OnClickListener onMaterialNumberDialogItemClick(List<String> list, int position);

        DialogInterface.OnClickListener onSupplierLiseDialogItemClick(List<String> list);
    }

    interface Presenter<V extends View>extends BaseAttacher<V> {
        void getSupplierList(String mRequest);

        void getPurchaseNumberList(String partnerId, int position);

        void getMaterialNumberList(String partnerId, int position);

        void showSelectProvideToast();

        PurchaseReceiveGoodSearch getNoneRepeatData(PurchaseReceiveGoodSearch mPurchaseReceiveGoodSearch);
    }

    interface Adapter{
        void addItem();

        void onMoreClick(int position);
    }
}
