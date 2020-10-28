package com.ycl.services;

import org.elasticsearch.action.ActionType;
import org.elasticsearch.action.admin.indices.create.AutoCreateAction;
import org.elasticsearch.action.support.TransportAction;
import org.elasticsearch.client.node.NodeClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.threadpool.ExecutorBuilder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.elasticsearch.threadpool.ThreadPool;

import java.util.HashMap;
import java.util.Map;

//@Service
public class ElasticEmbedded implements InitializingBean {

    NodeClient client;

    Settings settings;
    ExecutorBuilder[] args = {};
    ThreadPool pool;


    public void afterPropertiesSet() throws Exception {
        settings = Settings.builder()
                .put("nodeName", "es-client-1-1")
                .put("size", "10")
                .put("queueSize", 10)

                .put("client.type", "")   //1: node  2: transport
                .build();

        ActionType actionType = new ActionType("bulk", null);
//        Map<ActionType, TransportAction> actions = new HashMap<>();

//        TransportAction transportAction = new TransportAction();


//        actions.put(actionType, null);

        pool = new ThreadPool(settings, args);
        this.client = new NodeClient(settings, pool);

//        this.client.initialize( actions, ()->{return "es-node-1-1";},null );


    }
}
