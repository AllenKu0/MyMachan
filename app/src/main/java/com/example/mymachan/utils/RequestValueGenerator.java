package com.example.mymachan.utils;

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
}