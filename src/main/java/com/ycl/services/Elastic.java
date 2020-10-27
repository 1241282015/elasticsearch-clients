package com.ycl.services;

import com.amazon.opendistroforelasticsearch.jdbc.ConnectionImpl;
import com.amazon.opendistroforelasticsearch.jdbc.config.ConnectionConfig;
import com.amazon.opendistroforelasticsearch.jdbc.logging.LogLevel;
import com.amazon.opendistroforelasticsearch.jdbc.logging.Logger;
import com.amazon.opendistroforelasticsearch.jdbc.logging.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class Elastic implements InitializingBean {

    ConnectionImpl impl;
    ConnectionConfig.Builder configBuilder = ConnectionConfig.builder();
    Logger logger = LoggerFactory.getLogger(Opendistro.class.toString(), LogLevel.WARN);


    public void afterPropertiesSet() throws Exception {

    }
}
