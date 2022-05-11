package com.example.mymachan.utils.api.pojo.createreceivingorderbysingle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateReceivingOrderBySingleRequest {
    @SerializedName("FromOrderBillNo")
    @Expose
    private String fromOrderBillNo;
    @SerializedName("FromOrderRowId")
    @Expose
    private String fromOrderRowId;
    @SerializedName("ReceivingSQty")
    @Expose
    private String receivingSQty;
    @SerializedName("DestTypeId")
    @Expose
    private String destTypeId;
    @SerializedName("PresentSQty")
    @Expose
    private String presentSQty;
    @SerializedName("WarehouseId")
    @Expose
    private String warehouseId;
    @SerializedName("PlaceId")
    @Expose
    private String placeId;
    @SerializedName("Weight")
    @Expose
    private String weight;
    @SerializedName("WeightUnitId")
    @Expose
    private String weightUnitId;
    @SerializedName("CU_Tolerance")
    @Expose
    private String cUTolerance;
    @SerializedName("CU_BoXWeight")
    @Expose
    private String cUBoXWeight;
    @SerializedName("CU_RecivePersonId")
    @Expose
    private String cURecivePersonId;

    private String unitWeight;
    @SerializedName("BillDate")
    @Expose
    private String billDate;

    @SerializedName("ReciveDate")
    @Expose
    private String reciveDate;

    private String storage="";

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    private String divider;

    public String getDivider() {
        return divider;
    }

    public void setDivider(String divider) {
        this.divider = divider;
    }

    public String getFromOrderBillNo() {
        return fromOrderBillNo;
    }

    public void setFromOrderBillNo(String fromOrderBillNo) {
        this.fromOrderBillNo = fromOrderBillNo;
    }

    public String getFromOrderRowId() {
        return fromOrderRowId;
    }

    public void setFromOrderRowId(String fromOrderRowId) {
        this.fromOrderRowId = fromOrderRowId;
    }

    public String getReceivingSQty() {
        return receivingSQty;
    }

    public void setReceivingSQty(String receivingSQty) {
        this.receivingSQty = receivingSQty;
    }

    public String getDestTypeId() {
        return destTypeId;
    }

    public void setDestTypeId(String destTypeId) {
        this.destTypeId = destTypeId;
    }

    public String getPresentSQty() {
        return presentSQty;
    }

    public void setPresentSQty(String presentSQty) {
        this.presentSQty = presentSQty;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWeightUnitId() {
        return weightUnitId;
    }

    public void setWeightUnitId(String weightUnitId) {
        this.weightUnitId = weightUnitId;
    }

    public String getCUTolerance() {
        return cUTolerance;
    }

    public void setCUTolerance(String cUTolerance) {
        this.cUTolerance = cUTolerance;
    }

    public String getCUBoXWeight() {
        return cUBoXWeight;
    }

    public void setCUBoXWeight(String cUBoXWeight) {
        this.cUBoXWeight = cUBoXWeight;
    }

    public String getCURecivePersonId() {
        return cURecivePersonId;
    }

    public void setCURecivePersonId(String cURecivePersonId) {
        this.cURecivePersonId = cURecivePersonId;
    }

    public String getUnitWeight() {
        return unitWeight;
    }

    public void setUnitWeight(String unitWeight) {
        this.unitWeight = unitWeight;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getReciveDate() {
        return reciveDate;
    }

    public void setReciveDate(String reciveDate) {
        this.reciveDate = reciveDate;
    }
}
