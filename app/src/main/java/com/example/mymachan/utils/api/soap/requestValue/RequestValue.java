package com.example.mymachan.utils.api.soap.requestValue;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RequestValue implements RequestValueProvider {

    @Inject
    ReceiveGoodRequestValue receiveGoodRequestValue;
    @Inject
    public RequestValue() {

    }

    @Override
    public ReceiveGoodRequestValue getReceiveGoodRequest() {
        return receiveGoodRequestValue;
    }
}