package com.example.mymachan.utils.api.soap.requestValue;

import com.example.mymachan.utils.api.soap.ErpAPIRequestProvider;
import com.example.mymachan.utils.api.soap.request.SearchRequest;
import com.example.mymachan.utils.api.soap.request.SearchRequestBoolean;
import com.example.mymachan.utils.api.soap.request.SearchRequestEnvelope;
import com.example.mymachan.utils.api.soap.request.SearchRequestMethod;
import com.example.mymachan.utils.api.soap.request.SearchRequestTable;
import com.example.mymachan.utils.api.soap.request.SearchRequestValue;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ReceiveGoodRequestValue implements ErpAPIRequestProvider {
    @Inject
    SearchRequestEnvelope searchRequestEnvelope;

    @Inject
    SearchRequestMethod searchRequestMethod;

    @Inject
    SearchRequestTable searchRequestTable;

    @Inject
    SearchRequestValue searchRequestValue;

    @Inject
    SearchRequestBoolean searchRequestBoolean;

    List<SearchRequest> mRequestTextList;
    @Inject
    public ReceiveGoodRequestValue(){
        mRequestTextList = new ArrayList<>();
    }
    @Override
    public SearchRequestEnvelope getRequest() {
        mRequestTextList.clear();
        searchRequestMethod.setRequest("purPurchaseOrder");
        searchRequestTable.setRequest("A.OrgId,A.BillNo,A.BillDate,B.RowId,B.RowNo,B.MaterialId,B.MaterialName,B.SQuantity,B.UnTransSQty,B.TransSQty,B.CU_BillNo2,B.DeliveryDate");
        mRequestTextList.add(searchRequestMethod);
        mRequestTextList.add(searchRequestTable);
        mRequestTextList.add(searchRequestValue);
        mRequestTextList.add(searchRequestBoolean);

        searchRequestEnvelope.getSearchRequestBody()
                .getSearchRequestExecuteProc()
                .getSearchRequestParams()
                .setRequestText(mRequestTextList);
        return searchRequestEnvelope;
    }

    @Override
    public void setRequestValue(String requestValue) {
        searchRequestValue.setRequest(requestValue);
    }
}
