package com.ycl.services;
import com.amazon.opendistroforelasticsearch.jdbc.ConnectionImpl;
import com.amazon.opendistroforelasticsearch.jdbc.config.ConnectionConfig;
import com.amazon.opendistroforelasticsearch.jdbc.logging.LogLevel;
import com.amazon.opendistroforelasticsearch.jdbc.logging.Logger;
import com.amazon.opendistroforelasticsearch.jdbc.logging.LoggerFactory;
import com.amazon.opendistroforelasticsearch.jdbc.protocol.http.JsonHttpProtocolFactory;
import com.amazon.opendistroforelasticsearch.jdbc.transport.http.ApacheHttpTransportFactory;
import com.ycl.services.entity.SecislandResponse;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import com.ycl.services.entity.Response;

import java.sql.*;
import java.util.*;

/**
 * dependency: opendistro-sql-jdbc):
 */
@Service
public class ElasticOdfesql implements InitializingBean {

    ConnectionImpl impl;
    ConnectionConfig.Builder configBuilder = ConnectionConfig.builder();
    Logger logger = LoggerFactory.getLogger(ElasticOdfesql.class.toString(), LogLevel.WARN);

    /**
     * 1. use opendistro
     *      transport: used to interact with remote es server, see ApacheHttpTransportFactory
     *      protocol: used to do param and result conversion , see JsonHttpProtocol
     */
    public void afterPropertiesSet() throws Exception {

        Properties properties = new Properties();
        properties.setProperty("fetchSize", "10");
        properties.setProperty("method", "GET");
//        properties.setProperty("host", "locahost");
//        properties.setProperty("port", "9200");
//        properties.setProperty("path", "/secisland/");
//        properties.setProperty("authenticationType", "elastic"); // to see enum AuthenticationType
//        properties.setProperty("isUseSSL", false);  //to decide use http or https
        ConnectionConfig config = configBuilder
                .setUrl("jdbc:elasticsearch://localhost:9200")
                .setProperties(properties)
                .build();
        this.impl = new ConnectionImpl(config, ApacheHttpTransportFactory.INSTANCE, JsonHttpProtocolFactory.INSTANCE, logger);

//        search();
    }

    ///TODO 理想的状态是 查询时类似JPARepository 直接返回或者类似传入结果clazz，内部protocol进行序列化时直接返回类型结果
    public Object search() throws Exception {

        PreparedStatement statement = this.impl.prepareStatement("select name,message from secisland");
        ResultSet set = null;
        try {
            set = statement.executeQuery();
        } catch (Exception e){
            e.printStackTrace();
        }
        if(set == null) { return null; }
        List ret = convert(set, SecislandResponse.class);

        return ret;
    }

    ///TODO 参考CGLIB做或者JDKDynamic
    private List<? extends Response> convert(ResultSet set, Class<? extends Response> clazz) throws Exception{
        List<Response> list = new ArrayList<Response>();
        if(set == null) {
            return list;
        }

        if(set.next()) {
            list.add(setReflectively(set,clazz ));
        }
        return list;
    }

    private Response setReflectively(ResultSet set, Class<? extends Response> clazz) throws Exception {
        Response res = clazz.newInstance();
        Arrays.asList(clazz.getDeclaredFields())
               .forEach((it) -> {
                   try {
                       switch(it.getType().getSimpleName()) {
                           case "String":
                               it.set(res, set.getString(set.findColumn(it.getName())));
                               break;
                           case "Integer":
                               it.set(res, set.getInt(set.findColumn(it.getName())));
                               break;
                           default:
                               it.set(res, set.getString(set.findColumn(it.getName())));
                       }

                   } catch (IllegalAccessException e) {
                       e.printStackTrace();
                   } catch (SQLException e) {
                       e.printStackTrace();
                   }
               });
        return res;
    }

    public void search2() {

    }


}
