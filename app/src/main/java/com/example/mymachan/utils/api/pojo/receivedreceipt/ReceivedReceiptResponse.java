package com.example.mymachan.utils.api.pojo.receivedreceipt;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReceivedReceiptResponse {
    @SerializedName("BillNo")
    @Expose
    private String billNo;
    @SerializedName("BizPartnerId")
    @Expose
    private String bizPartnerId;
    @SerializedName("TypeId")
    @Expose
    private String typeId;
    @SerializedName("BillDate")
    @Expose
    private String billDate;
    @SerializedName("OrgId")
    @Expose
    private String orgId;
    @SerializedName("ShortName")
    @Expose
    private String shortName;
    @SerializedName("RowId")
    @Expose
    private Integer rowId;
    @SerializedName("RowNo")
    @Expose
    private Integer rowNo;
    @SerializedName("ReceivingSQty")
    @Expose
    private String receivingSQty;
    @SerializedName("WaitCheckBackSQty")
    @Expose
    private Integer waitCheckBackSQty;
    @SerializedName("CheckBackSQty")
    @Expose
    private Integer checkBackSQty;
    @SerializedName("CheckState")
    @Expose
    private Integer checkState;
    @SerializedName("CheckResult")
    @Expose
    private Integer checkResult;
    @SerializedName("GradeSQty")
    @Expose
    private Integer gradeSQty;
    @SerializedName("CheckType")
    @Expose
    private Integer checkType;
    @SerializedName("BadnessSQty")
    @Expose
    private Integer badnessSQty;
    @SerializedName("SpecialSQty")
    @Expose
    private Integer specialSQty;
    @SerializedName("CheckPersonId")
    @Expose
    private String checkPersonId;
    @SerializedName("MaterialId")
    @Expose
    private String materialId;
    @SerializedName("MaterialName")
    @Expose
    private String materialName;
    @SerializedName("MaterialSpec")
    @Expose
    private String materialSpec;
    @SerializedName("FromBillNo")
    @Expose
    private String fromBillNo;
    @SerializedName("PlaceId")
    @Expose
    private String placeId;
    @SerializedName("PlaceName")
    @Expose
    private String placeName;
    @SerializedName("FromRowId")
    @Expose
    private Integer fromRowId;
    @SerializedName("CU_Measure")
    @Expose
    private String measure;
    @SerializedName("CU_Feature")
    @Expose
    private String feature;
    @SerializedName("CU_BillNo2")
    @Expose
    private String cUBillNo2;

    @SerializedName("CU_TagNO")
    @Expose
    private String cUTagNo;

    @SerializedName("CheckInfo")
    @Expose
    private String checkInfo;

    private String originQty;
    @SerializedName("CU_SSId")
    @Expose
    private String storage="";
    /*------------------------------------*/

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }
    @SerializedName("CU_DeliveryDate")
    @Expose
    private String deliverDate="";

    public String getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(String deliverDate) {
        this.deliverDate = deliverDate;
    }

    private String splitFromBillDate="";

    public String getSplitFromBillDate() {
        return splitFromBillDate;
    }

    public void setSplitFromBillDate(String splitFromBillDate) {
        this.splitFromBillDate = splitFromBillDate;
    }
    private String divider="";

    public String getDivider() {
        return divider;
    }

    public void setDivider(String divider) {
        this.divider = divider;
    }

    public String getcUBillNo2() {
        return cUBillNo2;
    }

    public void setcUBillNo2(String cUBillNo2) {
        this.cUBillNo2 = cUBillNo2;
    }

    public String getCheckInfo() {
        return checkInfo;
    }

    public void setCheckInfo(String checkInfo) {
        this.checkInfo = checkInfo;
    }

    private int position;

    private boolean open;

    private boolean merged;

    private boolean checked = false;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isClickable() {
        return clickable;
    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

    private boolean clickable = true;

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getBizPartnerId() {
        return bizPartnerId;
    }

    public void setBizPartnerId(String bizPartnerId) {
        this.bizPartnerId = bizPartnerId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Integer getRowId() {
        return rowId;
    }

    public void setRowId(Integer rowId) {
        this.rowId = rowId;
    }

    public Integer getRowNo() {
        return rowNo;
    }

    public void setRowNo(Integer rowNo) {
        this.rowNo = rowNo;
    }

    public String getReceivingSQty() {
        return receivingSQty;
    }

    public void setReceivingSQty(String receivingSQty) {
        this.receivingSQty = receivingSQty;
    }

    public Integer getWaitCheckBackSQty() {
        return waitCheckBackSQty;
    }

    public void setWaitCheckBackSQty(Integer waitCheckBackSQty) {
        this.waitCheckBackSQty = waitCheckBackSQty;
    }

    public Integer getCheckBackSQty() {
        return checkBackSQty;
    }

    public void setCheckBackSQty(Integer checkBackSQty) {
        this.checkBackSQty = checkBackSQty;
    }

    public Integer getCheckState() {
        return checkState;
    }

    public void setCheckState(Integer checkState) {
        this.checkState = checkState;
    }

    public Integer getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(Integer checkResult) {
        this.checkResult = checkResult;
    }

    public Integer getGradeSQty() {
        return gradeSQty;
    }

    public void setGradeSQty(Integer gradeSQty) {
        this.gradeSQty = gradeSQty;
    }

    public Integer getCheckType() {
        return checkType;
    }

    public void setCheckType(Integer checkType) {
        this.checkType = checkType;
    }

    public Integer getBadnessSQty() {
        return badnessSQty;
    }

    public void setBadnessSQty(Integer badnessSQty) {
        this.badnessSQty = badnessSQty;
    }

    public Integer getSpecialSQty() {
        return specialSQty;
    }

    public void setSpecialSQty(Integer specialSQty) {
        this.specialSQty = specialSQty;
    }

    public String getCheckPersonId() {
        return checkPersonId;
    }

    public void setCheckPersonId(String checkPersonId) {
        this.checkPersonId = checkPersonId;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialSpec() {
        return materialSpec;
    }

    public void setMaterialSpec(String materialSpec) {
        this.materialSpec = materialSpec;
    }

    public String getFromBillNo() {
        return fromBillNo;
    }

    public void setFromBillNo(String fromBillNo) {
        this.fromBillNo = fromBillNo;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Integer getFromRowId() {
        return fromRowId;
    }

    public void setFromRowId(Integer fromRowId) {
        this.fromRowId = fromRowId;
    }

    public String getCUBillNo2() {
        return cUBillNo2;
    }

    public void setCUBillNo2(String cUBillNo2) {
        this.cUBillNo2 = cUBillNo2;
    }

    public String getOriginQty() {
        return originQty;
    }

    public void setOriginQty(String originQty) {
        this.originQty = originQty;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isMerged() {
        return merged;
    }

    public void setMerged(boolean merged) {
        this.merged = merged;
    }

    public String getcUTagNo() {
        return cUTagNo;
    }

    public void setcUTagNo(String cUTagNo) {
        this.cUTagNo = cUTagNo;
    }
}
