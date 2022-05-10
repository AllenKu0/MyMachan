package com.example.mymachan.api.pojo.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by 5*N on 2017/12/28
 */

public class OrgVResponse {

    @SerializedName("OrgId")
    @Expose
    private String orgId;
    @SerializedName("OrgName")
    @Expose
    private String orgName;
    @SerializedName("OrgShortName")
    @Expose
    private String orgShortName;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgShortName() {
        return orgShortName;
    }

    public void setOrgShortName(String orgShortName) {
        this.orgShortName = orgShortName;
    }

}
