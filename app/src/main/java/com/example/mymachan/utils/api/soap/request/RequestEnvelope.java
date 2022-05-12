package com.example.mymachan.utils.api.soap.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@Root(name = "soap:Envelope")
@NamespaceList({
        @Namespace(prefix = "xsi",reference = "http://www.w3.org/2001/XMLSchema-instance"),
        @Namespace(prefix = "xsd",reference = "http://www.w3.org/2001/XMLSchema"),
        @Namespace(prefix = "soap",reference = "http://schemas.xmlsoap.org/soap/envelope/")
})
public class RequestEnvelope {
    @Element(name = "soap:Bod")
    private RequestBody requestBody;
    @Inject
    public RequestEnvelope(RequestBody requestBody){
        this.requestBody = requestBody;
    }

    public RequestBody getRequestBody() {
        return requestBody;
    }
}
