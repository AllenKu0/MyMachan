package com.example.mymachan;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.mymachan.api.ErpAPI;
import com.example.mymachan.api.MachanAPI;
import com.example.mymachan.utils.api.pojo.getpurorderbybparid.GetPurOrderByBParIdResponse;
import com.example.mymachan.utils.api.pojo.receivegood.ReceiveGoodResponse;
import com.example.mymachan.api.pojo.response.SupplierVResponse;
import com.example.mymachan.base.BasePresenter;
import com.example.mymachan.response.ResponseEnvelope;
import com.example.mymachan.rxjava.SchedulerProvider;
import com.example.mymachan.utils.CommonUtils;
import com.example.mymachan.utils.RequestValueGenerator;
import com.example.mymachan.utils.api.pojo.receivegood.ReceiveGoodRequest;
import com.example.mymachan.utils.api.soap.requestValue.RequestValueProvider;
import com.example.mymachan.utils.sharepreference.LoginPreferencesProvider;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

public class PurchaseReceiveGoodSearchPresenter<V extends PurchaseReceiveGoodsContract.View>
        extends BasePresenter<V> implements PurchaseReceiveGoodsContract.Presenter<V> {

    @Inject
    RequestValueProvider requestValueProvider;

    @Inject
    ReceiveGoodRequest receiveGoodRequest;

    @Inject
    List<PurchaseReceiveGoodSearch.ItemPurchaseNumber> itemPurchaseNumbers;

    @Inject
    List<PurchaseReceiveGoodSearch.ItemMaterialNumber> itemMaterialNumbers;

    @Inject
    LoginPreferencesProvider loginPreferencesProvider;

    @Inject
    public PurchaseReceiveGoodSearchPresenter(MachanAPI machanAPI, ErpAPI erpAPI, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(machanAPI, erpAPI, schedulerProvider, compositeDisposable);
    }

    @Override
    public void getSupplierList(String mRequest) {
        getmView().showProgressDialog(R.string.hint_loading);

        String url;
        if (mRequest.isEmpty()) {
            url = getmView().getResourceString(R.string.api_request_supplier);
        } else {
            url = getmView().getResourceString(R.string.api_request_supplier_with_condition);
        }

        getCompositeDisposable().add(getMachanAPI().getSupplierV(url)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribeWith(new DisposableObserver<List<SupplierVResponse>>() {

                    @Override
                    public void onNext(@NonNull List<SupplierVResponse> supplierVResponses) {
                        getmView().dismissProgressDialog();
                        List<String> list = new ArrayList<>();
                        for (SupplierVResponse responses : supplierVResponses) {
                            String item = getmView().getResourceString(R.string.receive_good_supplier_item,
                                    responses.getBizPartnerId(),
                                    responses.getBizPartnerName());
                            list.add(item);
                        }
                        if (supplierVResponses.isEmpty()) {
                            getmView().showToast("找不到符合搜尋的項目");
                        } else {
                            getmView().onGetSupplierList(list);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("TAG", "onError: " );
                    }

                    @Override
                    public void onComplete() {
                        Log.e("TAG", "onComplete: " );
                    }
                }));

    }
    //partnerId 廠商代碼
    @Override
    public void getPurchaseNumberList(String partnerId, int position) {
        getmView().showProgressDialog(R.string.hint_loading);

        receiveGoodRequest.setOrgId(loginPreferencesProvider.getOrgId());
        receiveGoodRequest.setPartnerId(partnerId);

        requestValueProvider.getReceiveGoodRequest().setRequestValue(
                RequestValueGenerator.getReceiveGoodRequest(receiveGoodRequest));

        getCompositeDisposable().add(getErpAPI().getERPData(
                requestValueProvider.getReceiveGoodRequest().getRequest())
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribeWith(new DisposableObserver<ResponseEnvelope>() {
                    @Override
                    public void onNext(@NonNull ResponseEnvelope responseEnvelope) {
                        Log.e("{TAG}", "onNext: aaaaaaaa" + responseEnvelope.getResponseBody().getResponseData().getData());
                        getmView().dismissProgressDialog();
                        List<ReceiveGoodResponse> receiveGoodResponses = CommonUtils.getResponseJsonArray(
                                responseEnvelope.getResponseBody().getResponseData().getData(), ReceiveGoodResponse.class);
                        List<String> purchaseNumberList = new ArrayList<>();
                        for (ReceiveGoodResponse response : receiveGoodResponses) {
                            if (response.getBillNo().contains(itemPurchaseNumbers.get(position).getPurchaseNumber())) {
                                purchaseNumberList.add(response.getBillNo());
                            }
                        }
                        getmView().onGetPurchaseNumberList(CommonUtils.getNoneRepeatItemList(purchaseNumberList), position);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("{TAG}", "onError: " + e.getMessage());
                        getmView().dismissProgressDialog();
                        getmView().showToast(R.string.error_code_network);
                    }

                    @Override
                    public void onComplete() {
                        Log.e("{TAG}", "onComplete: cccccccc");
                    }
                })
        );
    }

    @Override
    public void getMaterialNumberList(String partnerId, int position) {
        getmView().showProgressDialog(R.string.hint_loading);

        receiveGoodRequest.setOrgId(loginPreferencesProvider.getOrgId());
        receiveGoodRequest.setPartnerId(partnerId);
        requestValueProvider.getReceiveGoodRequest().setRequestValue(
                RequestValueGenerator.getReceiveGoodRequest(receiveGoodRequest));

        getCompositeDisposable().add(getErpAPI().getERPData(
                requestValueProvider.getReceiveGoodRequest().getRequest())
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribeWith(new DisposableObserver<ResponseEnvelope>() {
                    @Override
                    public void onNext(@NonNull ResponseEnvelope responseEnvelope) {
                        getmView().dismissProgressDialog();
                        List<GetPurOrderByBParIdResponse> list = CommonUtils.getResponseJsonArray(
                                responseEnvelope.getResponseBody().getResponseData().getData(),GetPurOrderByBParIdResponse.class);
                        List<String> materialNumberList = new ArrayList<>();
                        for(GetPurOrderByBParIdResponse data : list){
                            if(data.getMaterialId().contains(itemMaterialNumbers.get(position).getMaterialNumber())){
                                materialNumberList.add(data.getMaterialId());
                            }
                        }
                        getmView().onGetMaterialNumberList(CommonUtils.getNoneRepeatItemList(materialNumberList),position);
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

    @Override
    public void showSelectProvideToast() {

    }

    @Override
    public PurchaseReceiveGoodSearch getNoneRepeatData(PurchaseReceiveGoodSearch mPurchaseReceiveGoodSearch) {
        List<String> list = new ArrayList<>();
        List<PurchaseReceiveGoodSearch.ItemPurchaseNumber> removeList = new ArrayList<>();
        // 多新增，沒打字的
        for(PurchaseReceiveGoodSearch.ItemPurchaseNumber item: mPurchaseReceiveGoodSearch.getPurchaseNumbersList()){
            if(item.getPurchaseNumber().isEmpty()){
                removeList.add(item);
            }
        }
        //移除
        mPurchaseReceiveGoodSearch.getPurchaseNumbersList().removeAll(removeList);
        //
        for(PurchaseReceiveGoodSearch.ItemPurchaseNumber item: mPurchaseReceiveGoodSearch.getPurchaseNumbersList()){
            list.add(item.getPurchaseNumber());
        }
        mPurchaseReceiveGoodSearch.setPurchaseNumber(CommonUtils.getNoneRepeatItemList(list));
        return mPurchaseReceiveGoodSearch;
    }
}
