package com.example.mymachan.utils.api.soap.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.inject.Inject;

@Root(name = "soap:Body")
public class SearchRequestBody {
    @Element(name = "ExecuteProc")
    private SearchRequestExecuteProc searchRequestExecuteProc;
    @Inject
    public SearchRequestBody(SearchRequestExecuteProc searchRequestExecuteProc){
        this.searchRequestExecuteProc = searchRequestExecuteProc;
    }

    public SearchRequestExecuteProc getSearchRequestExecuteProc() {
        return searchRequestExecuteProc;
    }
}
