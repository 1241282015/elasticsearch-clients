package com.ycl.services;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.search.MultiSearchRequest;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.apache.http.HttpHost;
/**
 * (dependency: org.elasticsearch.client:transport)
 * dependency(org.elasticsearch.client:elasticsearch-rest-high-level-client)
 */
@Service
public class ElasticTerminal implements InitializingBean {


    RestClient client;
    RestHighLevelClient highLevelClient;
    
    public void afterPropertiesSet() throws Exception {

        Node node = new Node(new HttpHost("localhost", 9200, "http"));
        Node[] nodes = new Node[]{node};
        this.client = RestClient.builder(nodes).build();


        this.highLevelClient = new RestHighLevelClient(RestClient.builder(nodes));
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

    public Object searchByHighLevelClient() throws Exception {
        MultiSearchRequest request = new MultiSearchRequest().add(new SearchRequest("secisland"));
        MultiSearchResponse res = this.highLevelClient.msearch(request, RequestOptions.DEFAULT);
        return res;
    }
}
