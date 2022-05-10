package com.example.mymachan.utils.api.soap.request;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SearchRequestBoolean extends SearchRequest {
    @Inject
    public SearchRequestBoolean(){
        value = "xsd:boolean";
        requestText = "true";
    }
}
