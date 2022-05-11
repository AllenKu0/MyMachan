package com.example.mymachan.api.pojo.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SSMasterV2Response {
    @SerializedName("CU_SMDID")
    @Expose
    private String cUSmdid;
    @SerializedName("CU_SMaterialID")
    @Expose
    private String cUSMaterialid;
    @SerializedName("CU_OrgId")
    @Expose
    private String cUOrgId;
    @SerializedName("CU_SMNo01")
    @Expose
    private String cUSMNo01;
    @SerializedName("CU_SMNo02")
    @Expose
    private String cUSMNo02;
    @SerializedName("CU_SMNo03")
    @Expose
    private String cUSMNo03;
    @SerializedName("CU_SMNoGroup")
    @Expose
    private String cUSMNoGroup;
    @SerializedName("CU_SMNoIOT")
    @Expose
    private String cUSMNoIOT;

    public String getcUSmdid() {
        return cUSmdid;
    }

    public void setcUSmdid(String cUSmdid) {
        this.cUSmdid = cUSmdid;
    }

    public String getcUSMaterialid() {
        return cUSMaterialid;
    }

    public void setcUSMaterialid(String cUSMaterialid) {
        this.cUSMaterialid = cUSMaterialid;
    }

    public String getcUOrgId() {
        return cUOrgId;
    }

    public void setcUOrgId(String cUOrgId) {
        this.cUOrgId = cUOrgId;
    }

    public String getcUSMNo01() {
        return cUSMNo01;
    }

    public void setcUSMNo01(String cUSMNo01) {
        this.cUSMNo01 = cUSMNo01;
    }

    public String getcUSMNo02() {
        return cUSMNo02;
    }

    public void setcUSMNo02(String cUSMNo02) {
        this.cUSMNo02 = cUSMNo02;
    }

    public String getcUSMNo03() {
        return cUSMNo03;
    }

    public void setcUSMNo03(String cUSMNo03) {
        this.cUSMNo03 = cUSMNo03;
    }

    public String getcUSMNoGroup() {
        return cUSMNoGroup;
    }

    public void setcUSMNoGroup(String cUSMNoGroup) {
        this.cUSMNoGroup = cUSMNoGroup;
    }

    public String getcUSMNoIOT() {
        return cUSMNoIOT;
    }

    public void setcUSMNoIOT(String cUSMNoIOT) {
        this.cUSMNoIOT = cUSMNoIOT;
    }
}
