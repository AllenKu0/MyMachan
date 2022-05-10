package com.example.mymachan.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

import okhttp3.ResponseBody;

@Root(name = "soap12:Envelope")
@NamespaceList({
        @Namespace( prefix = "xsi", reference = "http://www.w3.org/2001/XMLSchema-instance"),
        @Namespace( prefix = "xsd", reference = "http://www.w3.org/2001/XMLSchema"),
        @Namespace( prefix = "soap12", reference = "http://www.w3.org/2003/05/soap-envelope")
})
public class ResponseEnvelope {

    @Element(required = false, name = "Body")
    private com.example.mymachan.utils.api.soap.response.ResponseBody responseBody;

    public com.example.mymachan.utils.api.soap.response.ResponseBody getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(com.example.mymachan.utils.api.soap.response.ResponseBody responseBody) {
        this.responseBody = responseBody;
    }
}