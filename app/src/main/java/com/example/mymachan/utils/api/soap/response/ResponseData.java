package com.example.mymachan.utils.api.soap.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

@Root(name = "ExecuteProcResponse",strict = false)
@Namespace(reference = "http://tempuri.org/")
public class ResponseData {
    @Element(name = "ExecuteProcResult",required = false)
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
