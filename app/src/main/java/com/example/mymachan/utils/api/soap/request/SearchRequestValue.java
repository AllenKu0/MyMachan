package com.example.mymachan.utils.api.soap.request;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SearchRequestValue extends SearchRequest{
    @Inject
    public SearchRequestValue(){
        value = "xsd:string";
    }
}
