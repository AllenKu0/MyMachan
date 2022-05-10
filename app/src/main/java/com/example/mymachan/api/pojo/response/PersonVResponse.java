package com.example.mymachan.api.pojo.response;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PersonVResponse {

    @SerializedName("PersonId")
    @Expose
    private String personId;
    @SerializedName("PersonName")
    @Expose
    private String personName;
    @SerializedName("WarehouseCategoryId")
    @Expose
    private String warehouseCategoryId;
    @SerializedName("CU_SCMPW")
    @Expose
    private String cUSCMPW;
    @SerializedName("CU_SCMOrg")
    @Expose
    private String cUSCMOrg;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getWarehouseCategoryId() {
        return warehouseCategoryId;
    }

    public void setWarehouseCategoryId(String warehouseCategoryId) {
        this.warehouseCategoryId = warehouseCategoryId;
    }

    public String getCUSCMPW() {
        return cUSCMPW;
    }

    public void setCUSCMPW(String cUSCMPW) {
        this.cUSCMPW = cUSCMPW;
    }

    public String getCUSCMOrg() {
        return cUSCMOrg;
    }

    public void setCUSCMOrg(String cUSCMOrg) {
        this.cUSCMOrg = cUSCMOrg;
    }

}
