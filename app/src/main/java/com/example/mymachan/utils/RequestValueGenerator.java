package com.example.mymachan.utils;

import com.example.mymachan.utils.api.pojo.receivedreceipt.ReceivedReceiptRequest;
import com.example.mymachan.utils.api.pojo.receivegood.ReceiveGoodDeliveryRequest;
import com.example.mymachan.utils.api.pojo.receivegood.ReceiveGoodRequest;

public class RequestValueGenerator {
    public static String getReceiveGoodRequest(ReceiveGoodRequest receiveGood){
        StringBuilder request = new StringBuilder("B.UnTransSQty > 0 and "+
                "A.CurrentState = 2 and "+
                "A.BillDate > 0 and " +
                "A.BillDate < " + CommonUtils.getYear() + "1231 and " +
                "A.BizPartnerId = '" + receiveGood.getPartnerId() + "' and " +
                "A.OrgId = '" + receiveGood.getOrgId() + "'");

        if(receiveGood.getPurchaseNumbers().size() > 0){
            request.append(" and (");

            for (int i = 0; i < receiveGood.getPurchaseNumbers().size(); i++) {
                if (receiveGood.getPurchaseNumbers().size() == 1) {
                    request.append("A.BillNo = '")
                            .append(receiveGood.getPurchaseNumbers().get(0))
                            .append("')");
                } else {
                    if (i > 0) request.append(" or ");

                    request.append("A.BillNo = '")
                            .append(receiveGood.getPurchaseNumbers().get(i))
                            .append("'");

                    if (i == receiveGood.getPurchaseNumbers().size() - 1) request.append(")");
                }
            }

            if (receiveGood.getMaterialNumbers().size() > 0) request.append(" and (");

            for (int i = 0; i < receiveGood.getMaterialNumbers().size(); i++) {
                if (receiveGood.getPurchaseNumbers().size() == 1) {
                    request.append("B.MaterialId = '")
                            .append(receiveGood.getMaterialNumbers().get(0))
                            .append("')");
                } else {
                    if (i > 0) request.append(" or ");

                    request.append("B.MaterialId = '")
                            .append(receiveGood.getMaterialNumbers().get(i))
                            .append("'");

                    if (i == receiveGood.getMaterialNumbers().size() - 1) request.append(")");
                }
            }
        }
        return request.toString();
    }

    public static  String getReceiveGoodDeliveryRequest(ReceiveGoodDeliveryRequest receiveGoodDelivery){

        StringBuilder deliveryRequest =
                new StringBuilder("A.BillNo = '" + receiveGoodDelivery.getBillNo() + "' and "+
                        "A.OrgId = '" + receiveGoodDelivery.getOrgId()  + "' and " +
                        "B.MaterialId = '" + receiveGoodDelivery.getMaterialId()  + "' and " +
                        "A.BillDate = '"+ receiveGoodDelivery.getBillDate() + "' and "+
                        "A.BillDate < " + CommonUtils.getYear() + "1231");
        //A.BillNo=&apos;1MP1708160096&apos;and A.OrgId=&apos;1000&apos;and A.BillDate &gt;=20170816 and A.BillDate &lt;=20201231
        return deliveryRequest.toString();
    }

    public static String getReceivedReceiptRequest(ReceivedReceiptRequest receivedReceiptRequest) {
        return "A.BillNo='" + receivedReceiptRequest.getBillNo() + "'";
    }
}
