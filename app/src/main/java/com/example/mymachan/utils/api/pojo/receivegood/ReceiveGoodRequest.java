package com.example.mymachan.utils.api.pojo.receivegood;

import java.util.ArrayList;
import java.util.List;

import dagger.Provides;

public class ReceiveGoodRequest {
    private String partnerId;

    private String orgId;

    private List<String> purchaseNumbers = new ArrayList<>();

    private List<String> materialNumbers = new ArrayList<>();

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public List<String> getPurchaseNumbers() {
        return purchaseNumbers;
    }

    public void setPurchaseNumbers(List<String> purchaseNumbers) {
        this.purchaseNumbers = purchaseNumbers;
    }

    public List<String> getMaterialNumbers() {
        return materialNumbers;
    }

    public void setMaterialNumbers(List<String> materialNumbers) {
        this.materialNumbers = materialNumbers;
    }
}
