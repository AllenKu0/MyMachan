package com.example.mymachan.utils.api.soap.request;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SearchRequestMethod extends SearchRequest{
    @Inject
    public SearchRequestMethod(){
        value = "xsd:string";
    }
}
