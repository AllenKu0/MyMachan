package com.example.mymachan.utils.api.soap.request;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Text;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RequestText {
    @Attribute(name = "xsi:type")
    public String value = "xsi:string";

    @Text
    private String requestText;

    @Inject
    public RequestText(){

    }

    public String getRequestText() {
        return requestText;
    }

    public void setRequestText(String requestText) {
        this.requestText = requestText;
    }
}
