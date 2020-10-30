package com.ycl.services;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.client.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.apache.http.HttpHost;
/**
 * (dependency: org.elasticsearch.client:transport)
 */
@Service
public class ElasticTerminal implements InitializingBean {


    RestClient client;
    
    public void afterPropertiesSet() throws Exception {

        Node node = new Node(new HttpHost("localhost", 9200, "http"));
        Node[] nodes = new Node[]{node};
        this.client = RestClient.builder(nodes).build();
    }

    public Object search() throws Exception {

        Request req = new Request("GET", "/secisland/_search");
        Response response = this.client.performRequest(req);
        if(response == null || response.getStatusLine().getStatusCode() != 200) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
//        ObjectInputStream intput = new ObjectInputStream(response.getEntity().getContent());
        return mapper.readValue(response.getEntity().getContent(), Object.class);
    }
}
