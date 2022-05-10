package com.example.mymachan.utils.api.soap.request;

import com.example.mymachan.utils.api.soap.requestValue.RequestValue;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SearchRequestTable extends SearchRequest {
    @Inject
    public SearchRequestTable(){
        value ="xsd:string";
    }
}


