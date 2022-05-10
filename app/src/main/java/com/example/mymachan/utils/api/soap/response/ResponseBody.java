package com.example.mymachan.utils.api.soap.response;



import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "soap:Body",strict = false)
public class ResponseBody {
    @Element(name = "ExecuteProcResponse",required = false)
    private ResponseData responseData;

    public ResponseData getResponseData(){
        return responseData;
    }

    public void setResponseData(ResponseData responseData){
        this.responseData = responseData;
    }
}
