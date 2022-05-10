package com.example.mymachan.utils.api.soap;

import com.example.mymachan.utils.api.soap.request.SearchRequestEnvelope;

public interface ErpAPIRequestProvider {
    SearchRequestEnvelope getRequest();

    void setRequestValue(String requestValue);
}
