package com.example.mymachan.utils.api.soap.request;

import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Root(name = "ExecuteProc")
@Namespace(reference = "http://tempuri.org/")
public class RequestExecuteProc {
    @Element(name = "groupId")
    private String groupId = "machan02";

    @Element(name = "userId")
    private String userId = "0941";

    @Element(name = "password")
    private String password = "Y2hpMDk0MQ==";

    @Element(name = "progId")
    private String progId = "ppProduceOrder";

    @Element(name = "methodName")
    private String methodName;

    @Element(name = "ucoInvoke")
    private String ucoInvoke = "false";

    @Element(name = "logMode")
    private String logMode = "0";

    @Element(name = "wParams")
    private RequestParams requestParams;

    @Inject
    public RequestExecuteProc(RequestParams requestParams){
        this.requestParams = requestParams;
    }

    public RequestParams getRequestParams() {
        return requestParams;
    }

    public RequestExecuteProc setMethodName(String methodName) {
        this.methodName = methodName;
        return this;
    }

    public RequestExecuteProc setProgId(String progId) {
        this.progId = progId;
        return this;
    }
}
