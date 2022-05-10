package com.example.mymachan.utils.api.pojo.getpurorderbybparid;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GetPurOrderByBParIdResponse implements Serializable {
    @SerializedName("OrgId")
    @Expose
    private String orgId;
    @SerializedName("BillNo")
    @Expose
    private String billNo;
    @SerializedName("RowNo")
    @Expose
    private String rowNo;
    @SerializedName("RowId")
    @Expose
    private String rowId;
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

    private String shortName;

    private String originQty;

    private int position;

    private int order;

    private boolean open;

    private boolean merged;

    private boolean checked;

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

    public String getRowNo() {
        return rowNo;
    }

    public void setRowNo(String rowNo) {
        this.rowNo = rowNo;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
