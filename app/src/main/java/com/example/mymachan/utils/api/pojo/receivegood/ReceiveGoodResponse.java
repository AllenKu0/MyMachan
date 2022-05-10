package com.example.mymachan.utils.api.pojo.receivegood;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ReceiveGoodResponse implements Serializable {
    @SerializedName("OrgId")
    @Expose
    private String orgId;

    @SerializedName("BillNo")
    @Expose
    private String billNo;

    @SerializedName("BillDate")
    @Expose
    private String billDate;

    @SerializedName("RowId")
    @Expose
    private String rowId;

    @SerializedName("RowNo")
    @Expose
    private String rowNo;

    @SerializedName("MaterialId")
    @Expose
    private String materialId;

    @SerializedName("MaterialName")
    @Expose
    private String materialName;

    @SerializedName("SQuantity")
    @Expose
    private String sQuantity;

    @SerializedName("UnTransSQty")
    @Expose
    private String unTransSQty;

    @SerializedName("TransSQty")
    @Expose
    private String transSQty;

    @SerializedName("CU_BillNo")
    @Expose
    private String cUBillNo="-";

    @SerializedName("CU_BillNo2")
    @Expose
    private String cUBillNo2;

    @SerializedName("CU_GradeSQty")
    @Expose
    private String GradeSQty;

    @SerializedName("CU_BizPartnerId")
    @Expose
    private String BizPartnerId;

    @SerializedName("ReciveDate")
    @Expose
    private String reciveDate;

    @SerializedName("CU_SSId")
    @Expose
    private String storage="";
    /*-----------------------------*/
    public String getStorage(){
        return storage;
    }
    public void setStorage(String storage){
        this.storage=storage;
    }
    @SerializedName("DeliveryDate")
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

    public String getcUFromBillNo() {
        return cUFromBillNo;
    }

    public void setcUFromBillNo(String cUFromBillNo) {
        this.cUFromBillNo = cUFromBillNo;
    }

    @SerializedName("CU_FromBillNo")
    @Expose
    private String cUFromBillNo;
    public String getGradeSQty() {
        return GradeSQty;
    }

    public void setGradeSQty(String gradeSQty) {
        GradeSQty = gradeSQty;
    }

    public String getBizPartnerId() {
        return BizPartnerId;
    }

    public void setBizPartnerId(String bizPartnerId) {
        BizPartnerId = bizPartnerId;
    }

    public String getBadnessSQty() {
        return BadnessSQty;
    }

    public void setBadnessSQty(String badnessSQty) {
        BadnessSQty = badnessSQty;
    }

    @SerializedName("CU_BadnessSQty")
    @Expose
    private String BadnessSQty;
    public String getsQuantity() {
        return sQuantity;
    }

    public void setsQuantity(String sQuantity) {
        this.sQuantity = sQuantity;
    }

    public String getcUBillNo() {
        return cUBillNo;
    }

    public void setcUBillNo(String cUBillNo) {
        this.cUBillNo = cUBillNo;
    }

    public String getcUBillNo2() {
        return cUBillNo2;
    }

    public void setcUBillNo2(String cUBillNo2) {
        this.cUBillNo2 = cUBillNo2;
    }

    public String getReciveDate() {
        return reciveDate;
    }

    public void setReciveDate(String reciveDate) {
        this.reciveDate = reciveDate;
    }

    private String shortName;

    private String originQty;

    private int position;

    private int checkType = 2;

    private boolean submit = false;

    private boolean open;

    private boolean merged;

    private boolean checked = false;

    private boolean clickable = true;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getRowNo() {
        return rowNo;
    }

    public void setRowNo(String rowNo) {
        this.rowNo = rowNo;
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

    public String getSQuantity() {
        return sQuantity;
    }

    public void setSQuantity(String sQuantity) {
        this.sQuantity = sQuantity;
    }

    public String getUnTransSQty() {
        return unTransSQty;
    }

    public void setUnTransSQty(String unTransSQty) {
        this.unTransSQty = unTransSQty;
    }

    public String getTransSQty() {
        return transSQty;
    }

    public void setTransSQty(String transSQty) {
        this.transSQty = transSQty;
    }

    public String getCUBillNo() {
        return cUBillNo;
    }

    public void setCUBillNo(String cUBillNo) {
        this.cUBillNo = cUBillNo;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
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

    public int getCheckType() {
        return checkType;
    }

    public void setCheckType(int checkType) {
        this.checkType = checkType;
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

    public boolean isSubmit() {
        return submit;
    }

    public void setSubmit(boolean submit) {
        this.submit = submit;
    }

}
