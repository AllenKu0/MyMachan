package com.example.mymachan.utils.api.soap.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

import javax.inject.Inject;

@Root(name ="ExecuteProc")
@Namespace(reference = "http://tempuri.org/")
public class SearchRequestExecuteProc {
    @Element(name = "groupId")
    private String groupId = "machan02";

//    @Element(name = "language")
//    private String language = "zh_TW";

    @Element(name = "userId")
    private String userId = "0941";

    @Element(name = "password")
    private String password = "Y2hpMDk0MQ==";

    @Element(name = "progId")
    private String progId = "ppProduceOrder";

    @Element(name = "methodName")
    private String methodName = "GetDataFromInterface";

    @Element(name = "ucoInvoke")
    private String ucoInvoke = "false";

    @Element(name = "logMode")
    private String logMode = "0";

    @Element(name = "wParams")
    private SearchRequestParams searchRequestParams;

    @Inject
    public SearchRequestExecuteProc(SearchRequestParams searchRequestParams){
        this.searchRequestParams = searchRequestParams;
    }

    public SearchRequestParams getSearchRequestParams(){
        return searchRequestParams;
    }

    public SearchRequestExecuteProc setMethodName(String methodName){
        this.methodName = methodName;
        return this;
    }

    public SearchRequestExecuteProc setProgId(String progId){
        this.progId = progId;
        return this;
    }


}
