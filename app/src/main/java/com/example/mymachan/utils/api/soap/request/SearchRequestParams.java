package com.example.mymachan.utils.api.soap.request;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

import javax.inject.Inject;

@Root(name = "wParams")
public class SearchRequestParams {
    @ElementList(entry = "anyType",inline = true,empty = false,required = false)
    private List<SearchRequest> requestValue;

    @Inject
    public SearchRequestParams(){

    }

    public void setRequestText(List<SearchRequest> requestValue){
        this.requestValue = requestValue;
    }
}

