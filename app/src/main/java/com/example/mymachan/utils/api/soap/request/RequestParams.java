package com.example.mymachan.utils.api.soap.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Root(name = "wParams")
public class RequestParams {
    @Element(name = "anyType",required = false)
    private RequestText requestText;

    @Inject
    public RequestParams(RequestText requestText){
        this.requestText = requestText;
    }

    public RequestText getRequestText() {
        return requestText;
    }
}
