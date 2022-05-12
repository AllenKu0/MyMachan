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

public class ReceivedReceiptRequestValue implements ErpAPIRequestProvider {
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
    public ReceivedReceiptRequestValue(){
        mRequestTextList = new ArrayList<>();
    }
    @Override
    public SearchRequestEnvelope getRequest() {
        mRequestTextList.clear();
        searchRequestMethod.setRequest("purPurchaseOrder");
        searchRequestTable.setRequest("A.BillNo,A.BizPartnerId,A.TypeId,A.BillDate,A.OrgId,A.ShortName,B.RowId,B.RowNo,B.ReceivingSQty,B.WaitCheckBackSQty,B.CheckBackSQty,B.CheckState,B.CheckResult,B.GradeSQty,B.CheckType,B.BadnessSQty,B.SpecialSQty,B.CheckPersonId,B.MaterialId,B.MaterialName,B.MaterialSpec,B.FromBillNo,B.PlaceId,B.PlaceName,B.FromRowId, B.CU_Measure, B.CU_Feature, B.CU_BillNo2, B.CheckInfo,B.CU_DeliveryDate");
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
