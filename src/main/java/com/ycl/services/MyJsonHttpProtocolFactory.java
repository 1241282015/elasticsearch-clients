package com.ycl.services;


import com.amazon.opendistroforelasticsearch.jdbc.protocol.ProtocolFactory;
import com.amazon.opendistroforelasticsearch.jdbc.protocol.http.JsonHttpProtocol;
import com.amazon.opendistroforelasticsearch.jdbc.transport.http.HttpTransport;
import com.amazon.opendistroforelasticsearch.jdbc.config.ConnectionConfig;

public class MyJsonHttpProtocolFactory implements ProtocolFactory<JsonHttpProtocol, HttpTransport> {
    static MyJsonHttpProtocolFactory INSTANCE = new MyJsonHttpProtocolFactory();
    public MyJsonHttpProtocolFactory() {

    }

    public JsonHttpProtocol getProtocol(ConnectionConfig connectionConfig, HttpTransport transport) {
        return new JsonHttpProtocol(transport, "");
    }

}
