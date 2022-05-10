package com.example.mymachan.utils.api.soap.request;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;
import javax.inject.Inject;

@Root(name = "anyType")
public class SearchRequest {
    @Attribute(name = "xsi:type")
    protected String value;

    @Text
    protected String requestText;

    @Inject
    public SearchRequest(){

    }

    public void setRequest(String requestText){
        this.requestText = requestText;
    }
}
