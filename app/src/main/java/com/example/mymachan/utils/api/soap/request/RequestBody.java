package com.example.mymachan.utils.api.soap.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Root(name = "soap:Body")
public class RequestBody {
    @Element(name = "ExecuteProc")
    private RequestExecuteProc requestExecuteProc;
    @Inject
    public RequestBody(RequestExecuteProc requestExecuteProc){
        this.requestExecuteProc = requestExecuteProc;
    }

    public RequestExecuteProc getRequestExecuteProc() {
        return requestExecuteProc;
    }
}
