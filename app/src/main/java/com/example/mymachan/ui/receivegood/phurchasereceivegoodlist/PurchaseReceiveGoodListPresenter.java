package com.example.mymachan.ui.receivegood.phurchasereceivegoodlist;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.mymachan.R;
import com.example.mymachan.api.ErpAPI;
import com.example.mymachan.api.MachanAPI;
import com.example.mymachan.api.pojo.response.SSMasterV2Response;
import com.example.mymachan.base.BasePresenter;
import com.example.mymachan.base.BaseView;
import com.example.mymachan.response.ResponseEnvelope;
import com.example.mymachan.rxjava.SchedulerProvider;
import com.example.mymachan.ui.receivegood.phurchasereceivegoodsearch.PurchaseReceiveGoodSearch;
import com.example.mymachan.utils.CommonUtils;
import com.example.mymachan.utils.RequestValueGenerator;
import com.example.mymachan.utils.api.pojo.createreceivingorderbysingle.CreateReceivingOrderBySingleRequest;
import com.example.mymachan.utils.api.pojo.createreceivingorderbysingle.CreateReceivingOrderBySingleResponse;
import com.example.mymachan.utils.api.pojo.receivedreceipt.ReceivedReceiptRequest;
import com.example.mymachan.utils.api.pojo.receivedreceipt.ReceivedReceiptResponse;
import com.example.mymachan.utils.api.pojo.receivegood.ReceiveGoodDeliveryRequest;
import com.example.mymachan.utils.api.pojo.receivegood.ReceiveGoodRequest;
import com.example.mymachan.utils.api.pojo.receivegood.ReceiveGoodResponse;
import com.example.mymachan.utils.api.soap.request.RequestEnvelope;
import com.example.mymachan.utils.api.soap.request.RequestText;
import com.example.mymachan.utils.api.soap.request.SearchRequestEnvelope;
import com.example.mymachan.utils.api.soap.requestValue.RequestValueProvider;
import com.example.mymachan.utils.sharepreference.LoginPreferencesProvider;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

public class PurchaseReceiveGoodListPresenter<V extends PurchaseReceiveGoodListActivityContract.View>
        extends BasePresenter<V> implements PurchaseReceiveGoodListActivityContract.Presenter<V> {
    private String mShortName;
    @Inject
    RequestEnvelope requestEnvelope;

    @Inject
    LoginPreferencesProvider loginPreferencesProvider;

    @Inject
    ReceiveGoodRequest receiveGoodRequest;

    @Inject
    RequestValueProvider requestValueProvider;

    @Inject
    ReceiveGoodDeliveryRequest receiveGoodDeliveryRequest;

    @Inject
    ReceivedReceiptRequest receivedReceiptRequest;

    @Inject
    @Named("BatchList")
    List<ReceiveGoodResponse> mBatchList;

    private boolean itHasCreatedStag=false;
    private int endNowSize = 0, internetErr = 0;
    private String mReceipt;
    private boolean addError=false;
    private List<CreateReceivingOrderBySingleRequest> mReceiveList = new ArrayList<>();
    private List<ReceiveGoodResponse> mReceiveGoodResponseList = new ArrayList<>();

    @Inject
    public PurchaseReceiveGoodListPresenter(MachanAPI machanAPI, ErpAPI erpAPI, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(machanAPI, erpAPI, schedulerProvider, compositeDisposable);
    }

    @Override
    public void getReceiveGoodList(PurchaseReceiveGoodSearch purchaseReceiveGoodSearch) {
        getmView().showProgressDialog(R.string.hint_loading);

        mShortName = purchaseReceiveGoodSearch.getSupplierName();
        List<String> purchaseNumberList = new ArrayList<>();
        List<String> materialNumberList = new ArrayList<>();
        for (int i = 0; i < purchaseReceiveGoodSearch.getPurchaseNumbersList().size(); i++) {
            purchaseNumberList.add(purchaseReceiveGoodSearch.getPurchaseNumbersList().get(i).getPurchaseNumber());
        }
        for (int i = 0; i < purchaseReceiveGoodSearch.getMaterialNumberList().size(); i++) {
            materialNumberList.add(purchaseReceiveGoodSearch.getMaterialNumberList().get(i).getMaterialNumber());
        }

        receiveGoodRequest.setOrgId(loginPreferencesProvider.getOrgId());
        receiveGoodRequest.setPartnerId(purchaseReceiveGoodSearch.getSupplierId());
        receiveGoodRequest.setPurchaseNumbers(purchaseNumberList);
        receiveGoodRequest.setMaterialNumbers(materialNumberList);

        requestValueProvider.getReceiveGoodRequest().setRequestValue(
                RequestValueGenerator.getReceiveGoodRequest(receiveGoodRequest));

        getCompositeDisposable().add(getErpAPI().getERPData(requestValueProvider.getReceiveGoodRequest().getRequest())
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribeWith(new DisposableObserver<ResponseEnvelope>() {
                    @Override
                    public void onNext(@NonNull ResponseEnvelope responseEnvelope) {
                        if (responseEnvelope.getResponseBody().getResponseData().getData().length() != 0) {
                            List<ReceiveGoodResponse> list = CommonUtils.getResponseJsonArray(
                                    responseEnvelope.getResponseBody().getResponseData().getData(), ReceiveGoodResponse.class);
                            for (ReceiveGoodResponse item : list) {
                                item.setShortName(purchaseReceiveGoodSearch.getSupplierId());
                                item.setOriginQty(item.getUnTransSQty());
                            }
                            if (list.size() == 0) {
                                getmView().showToast(R.string.error_code_search);
                                getmView().onBackClick();
                            } else {
                                int EndSize = list.size();
                                getMaterialStorage(list,0, EndSize);
                            }
                        }
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
    //拿儲位
    @Override
    public void getMaterialStorage(List<ReceiveGoodResponse> receiveGoodResponses, int mTsize, int EndSize) {
        String url;
        url = getmView().getResourceString(R.string.api_request_ssmasterv2_with_condition, receiveGoodResponses.get(mTsize).getMaterialId());

        getCompositeDisposable().add(getMachanAPI().getSSMasterV2(url)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribeWith(new DisposableObserver<List<SSMasterV2Response>>() {
                    @Override
                    public void onNext(@NonNull List<SSMasterV2Response> ssMasterV2Responses) {
                        for(int i=0;i<ssMasterV2Responses.size();i++){
                            if(ssMasterV2Responses.get(i).getcUSMaterialid().equals(receiveGoodResponses.get(mTsize).getMaterialId())){
                                receiveGoodResponses.get(mTsize).setStorage(ssMasterV2Responses.get(i).getcUSMNoIOT());
                            }
                        }

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        if(internetErr>EndSize){
                            internetErr=0;
                            mBatchList.clear();
                            getmView().dismissProgressDialog();
                            getmView().showToast(R.string.error_code_network);
                        }else{
                            internetErr++;
                            getMaterialStorage(receiveGoodResponses,endNowSize,EndSize);
                        }
                    }

                    @Override
                    public void onComplete() {
                        if(endNowSize != EndSize-1){
                            mBatchList.add(receiveGoodResponses.get(endNowSize));
                            endNowSize++;
                            getMaterialStorage(receiveGoodResponses,endNowSize,EndSize);
                        }else{
                            mBatchList.add(receiveGoodResponses.get(endNowSize));
                            endNowSize = 0;
                            getmView().dismissProgressDialog();
                            getmView().onReceiveGoodResponse(receiveGoodResponses);
                        }
                    }
                }));
    }

    @Override
    public void CreateReceipt(List<CreateReceivingOrderBySingleRequest> list) {
        getmView().showProgressDialog(R.string.hint_loading);

        requestEnvelope.getRequestBody()
                .getRequestExecuteProc()
                .setMethodName(getmView().getResourceString(R.string.api_method_createreceivingorderbysingle));

        requestEnvelope.getRequestBody()
                .getRequestExecuteProc()
                .getRequestParams()
                .getRequestText()
                .setRequestText(CommonUtils.getRequestJson(list));

        getCompositeDisposable().add(getErpAPI().getERPData(requestEnvelope)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribeWith(new DisposableObserver<ResponseEnvelope>() {
                    @Override
                    public void onNext(@NonNull ResponseEnvelope responseEnvelope) {
                        getmView().dismissProgressDialog();

                        CreateReceivingOrderBySingleResponse response =
                                CommonUtils.getResponseJson(responseEnvelope.getResponseBody().getResponseData().getData()
                                        ,CreateReceivingOrderBySingleResponse.class);

                        if(response.getIsSuccess()){
                            mReceipt = response.getBillNo();
                            getmView().showToast("已播送");
                            mReceiveList = new ArrayList<>(list);
                            getReceivedList();
                        }else {
                            getmView().showToast(response.getMessageList().get(0));
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
//                        NotTransferFile.write(getmView().getNotTransferReceiveGoodList());
                        getmView().dismissProgressDialog();
                        getmView().showToast(R.string.error_code_network_not_transfer);
                        getmView().onBackClick();
                    }

                    @Override
                    public void onComplete() {

                    }
                }));

    }

    private void getReceivedList() {
        getmView().showProgressDialog(R.string.hint_loading);

        receivedReceiptRequest.setBillNo(mReceipt);

        requestValueProvider.getReceivedReceiptRequestValue()
                .setRequestValue(RequestValueGenerator.getReceivedReceiptRequest(receivedReceiptRequest));

        getCompositeDisposable().add(getErpAPI()
                .getERPData(requestValueProvider.getReceivedReceiptRequestValue().getRequest())
                .subscribeOn(getSchedulerProvider().ui())
                .observeOn(getSchedulerProvider().io())
                .subscribeWith(new DisposableObserver<ResponseEnvelope>() {
                    @Override
                    public void onNext(@NonNull ResponseEnvelope responseEnvelope) {
                        getmView().dismissProgressDialog();

                        if(responseEnvelope.getResponseBody().getResponseData().getData().equals("[]")){
                            getmView().showToast(R.string.error_code_search);
                            return;
                        }

                        List<ReceivedReceiptResponse> responses = CommonUtils.getResponseJsonArray(
                                responseEnvelope.getResponseBody().getResponseData().getData(),ReceivedReceiptResponse.class);

                        List<ReceiveGoodResponse> list = new ArrayList<>();

                        for (int i = 0; i < responses.size(); i++) {
                            ReceiveGoodResponse response = new ReceiveGoodResponse();
                            response.setPosition(i);
                            response.setChecked(true);
                            response.setShortName(mShortName);
                            response.setMaterialId(responses.get(i).getMaterialId());
                            response.setBillNo(responses.get(i).getFromBillNo());
                            response.setUnTransSQty(responses.get(i).getReceivingSQty());
                            response.setOriginQty(responses.get(i).getReceivingSQty());
                            response.setMaterialName(responses.get(i).getMaterialName());
                            response.setCheckType(responses.get(i).getCheckType());
                            response.setBizPartnerId(responses.get(i).getBizPartnerId());
                            response.setCUBillNo(responses.get(i).getCUBillNo2());
                            response.setGradeSQty(responses.get(i).getGradeSQty().toString());
                            response.setBadnessSQty(responses.get(i).getBadnessSQty().toString());
                            response.setcUFromBillNo(responses.get(i).getCUBillNo2());
                            response.setSubmit(true);
                            response.setStorage(mReceiveList.get(i).getStorage());

                            Log.d("getReceivedList", "getReceivedList: 收貨查詢完成"+response.getCUBillNo());
                            list.add(response);
                        }
                        mReceiveGoodResponseList = list;

                        getmView().onCreateReceiptResponse(list,mReceipt);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        getmView().dismissProgressDialog();
                        getmView().showToast(R.string.error_code_network);
                    }

                    @Override
                    public void onComplete() {
                        if(!itHasCreatedStag) {
                            addError=false;
                        }
                    }
                })
        );
    }

//    @Override
//    public void getDeliveryData(List<ReceiveGoodResponse> receiveGoodResponses, int EndSize) {
//        receiveGoodDeliveryRequest.setOrgId(receiveGoodResponses.get(endNowSize).getOrgId());
//        receiveGoodDeliveryRequest.setMaterialId(receiveGoodResponses.get(endNowSize).getMaterialId());
//        receiveGoodDeliveryRequest.setBillNo(receiveGoodResponses.get(endNowSize).getBillNo());
//        receiveGoodDeliveryRequest.setBillDate(receiveGoodResponses.get(endNowSize).getBillDate());
//
//        requestValueProvider.getReceiveGoodRequest()
//                .setRequestValue(RequestValueGenerator.getReceiveGoodDeliveryRequest(receiveGoodDeliveryRequest));
//    }


}
