package com.ycl.services;

import com.amazon.opendistroforelasticsearch.jdbc.ConnectionImpl;
import com.amazon.opendistroforelasticsearch.jdbc.ElasticsearchDataSource;
import com.amazon.opendistroforelasticsearch.jdbc.config.ConnectionConfig;
import com.amazon.opendistroforelasticsearch.jdbc.logging.LogLevel;
import com.amazon.opendistroforelasticsearch.jdbc.logging.Logger;
import com.amazon.opendistroforelasticsearch.jdbc.logging.LoggerFactory;
import com.amazon.opendistroforelasticsearch.jdbc.transport.http.ApacheHttpTransportFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


@Service
public class Opendistro implements InitializingBean {


    ConnectionImpl impl;
    ConnectionConfig.Builder configBuilder = ConnectionConfig.builder();
    Logger logger = LoggerFactory.getLogger(Opendistro.class.toString(), LogLevel.WARN);



    public void afterPropertiesSet() throws Exception {


        Properties properties = new Properties();
        properties.setProperty("fetchSize", "10");
//        properties.setProperty("path", "/secisland/");
        ConnectionConfig config = configBuilder
                .setUrl("jdbc:elasticsearch://localhost:9200")
                .setProperties(properties)
                .build();
        this.impl = new ConnectionImpl(config, ApacheHttpTransportFactory.INSTANCE, MyJsonHttpProtocolFactory.INSTANCE, logger);
//        this.impl


//        PreparedStatement statement = this.impl.prepareStatement("/secisland/secilog/1/");
        PreparedStatement statement = this.impl.prepareStatement("select * from secisland");
        try {
            ResultSet set = statement.executeQuery();
        } catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
//            System.out.println(e.getStackTrace());
        }




    }

    public void initial2() {

        ElasticsearchDataSource source = new ElasticsearchDataSource();
        Properties properties = new Properties();
        properties.setProperty("fetchSize", "10");
        properties.setProperty("path", "/secisland/_doc/1/");

        try {
            source.setProperties(properties);
            Connection impl = source.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
