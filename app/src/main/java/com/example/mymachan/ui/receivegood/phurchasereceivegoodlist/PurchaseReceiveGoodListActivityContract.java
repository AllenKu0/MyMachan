package com.example.mymachan.ui.receivegood.phurchasereceivegoodlist;

import android.content.DialogInterface;

import com.example.mymachan.base.BaseAttacher;
import com.example.mymachan.base.BaseView;
import com.example.mymachan.ui.receivegood.phurchasereceivegoodsearch.PurchaseReceiveGoodSearch;
import com.example.mymachan.utils.api.pojo.createreceivingorderbysingle.CreateReceivingOrderBySingleRequest;
import com.example.mymachan.utils.api.pojo.receivegood.ReceiveGoodResponse;

import java.util.List;

public interface PurchaseReceiveGoodListActivityContract {
    interface View extends BaseView{
        void onSubmitClick();

        void onBackClick();

        void onReceiveGoodResponse(List<ReceiveGoodResponse> list);

        void onCreateReceiptResponse(List<ReceiveGoodResponse> list, String receipt);

        DialogInterface.OnClickListener onAskReceiveDialogClick();


    }
    interface Presenter<V extends View> extends BaseAttacher<V> {
        void getReceiveGoodList(PurchaseReceiveGoodSearch purchaseReceiveGoodSearch);
//        void getDeliveryData(List<ReceiveGoodResponse> receiveGoodResponses,int EndSize);
        void getMaterialStorage(List<ReceiveGoodResponse> receiveGoodResponses,int mTsize,int EndSize);

        void CreateReceipt(final List<CreateReceivingOrderBySingleRequest> list);
    }

    interface Adapter{
        void onItemClick(int position);

        void onMoreClick(int position);

        void initSubmitData(List<ReceiveGoodResponse> list);

        void setListData(List<ReceiveGoodResponse> list);

        void onStorageClick(int position);

        List<ReceiveGoodResponse> getSelectedListData();

        List<CreateReceivingOrderBySingleRequest> getSelectedSubmitData();
    }
}
