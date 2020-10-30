package com.ycl.services;

import org.apache.http.HttpHost;
import org.elasticsearch.action.ActionType;
import org.elasticsearch.action.search.*;
import org.elasticsearch.action.support.TransportAction;
import org.elasticsearch.client.*;
import org.elasticsearch.client.node.NodeClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.threadpool.ExecutorBuilder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.elasticsearch.threadpool.ThreadPool;

import java.util.HashMap;
import java.util.Map;

/**
 * dependency(org.elasticsearch.client:elasticsearch-rest-high-level-client)
 *
 */
@Service
public class ElasticEmbedded implements InitializingBean {

    RestHighLevelClient client;


    public void afterPropertiesSet() throws Exception {
        Node node = new Node(new HttpHost("localhost", 9200, "http"));
        Node[] nodes = new Node[]{node};
        this.client = new RestHighLevelClient(RestClient.builder(nodes));
    }

    public Object search() throws Exception {
        MultiSearchRequest request = new MultiSearchRequest().add(new SearchRequest("secisland"));
        MultiSearchResponse res = this.client.msearch(request, RequestOptions.DEFAULT);
        return res;
    }
}



