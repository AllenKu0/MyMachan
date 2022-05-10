package com.example.mymachan.api;
import com.example.mymachan.response.ResponseEnvelope;
import com.example.mymachan.utils.api.soap.request.SearchRequestEnvelope;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ErpAPI {
//    @POST("CAPInteropServiceEx.asmx")
//    Observable<ResponseEnvelope> getERPData(@Body RequestEnvelope requestEnvelope);

    @POST("CAPInteropServiceEx.asmx")
    Observable<ResponseEnvelope> getERPData(@Body SearchRequestEnvelope searchRequestEnvelope);
}
