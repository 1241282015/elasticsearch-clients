package com.ycl.services;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.env.Environment;
import org.elasticsearch.node.Node;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.NodeValidationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;

//@Service
public class ElasticEmbedNode  {
//    private Node node;
//
//    public void afterPropertiesSet() throws URISyntaxException, NodeValidationException, RuntimeException {
//        Settings settings = Settings.builder()
//                .put("path.home","/Users/jack/Documents/projects/allProjects/elasticsearch-clients/tmp")
////                .put("path.conf", "elasticsearch.yml")
//                .put("path.data", "/Users/jack/Documents/projects/allProjects/elasticsearch-clients/tmp")
//                .put("client.type", "node")  //master, node, ingest
////                .put("transport.type", "http")  //master, node, ingest
//                .put("client.transport.sniff", false)
////                .put("index.number_of_replicas", 0)
////                .put("index.number_of_shards", 1)
////                .put("action.write_consistency", "one")
//                .build();
//
////        NodeClient client = new NodeClient(settings, new ThreadPool(settings, null));
//        URL url = this.getClass().getClassLoader().getResource("elasticsearch.yml");
//
//        Path path = new File(url.toURI()).toPath();
//        Environment env = new Environment(settings, path);
//
//        this.node = new Node(env);
//        node.start();
//    }
//
//    public Object search() throws RuntimeException {
//
//        SearchRequest request = new SearchRequest("secisland");
//        return node.client().search(request).actionGet();
//
//    }
}
