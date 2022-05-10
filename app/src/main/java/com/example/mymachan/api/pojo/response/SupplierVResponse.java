package com.example.mymachan.api.pojo.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SupplierVResponse {
    @SerializedName("BizPartnerId")
    @Expose
    private String bizPartnerId;

    @SerializedName("BizPartnerName")
    @Expose
    private String bizPartnerName;

    @SerializedName("ShortName")
    @Expose
    private String shortName;

    @SerializedName("CU_ForSCM")
    @Expose
    private String cUForSCM;

    @SerializedName("ContactAddress")
    @Expose
    private String contactAddress;

    public String getBizPartnerId() {
        return bizPartnerId;
    }

    public void setBizPartnerId(String bizPartnerId) {
        this.bizPartnerId = bizPartnerId;
    }

    public String getBizPartnerName() {
        return bizPartnerName;
    }

    public void setBizPartnerName(String bizPartnerName) {
        this.bizPartnerName = bizPartnerName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getcUForSCM() {
        return cUForSCM;
    }

    public void setcUForSCM(String cUForSCM) {
        this.cUForSCM = cUForSCM;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getFaxNo() {
        return faxNo;
    }

    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    @SerializedName("FaxNo")
    @Expose
    private String faxNo;


}
