package com.ycl.controllers;

import com.ycl.services.ElasticEmbedNode;
import com.ycl.services.ElasticOdfesql;
import com.ycl.services.ElasticTerminal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    ElasticOdfesql elasticOdfesql;

//    @Autowired
//    ElasticEmbedNode elasticEmbedNode;
    @Autowired
    ElasticTerminal elasticTerminal;

    @GetMapping("/")
    public Object odfesqlServiceOk() throws Exception{
        return elasticOdfesql.search();
    }

//    @GetMapping("/embed")
//    public Object embedServiceOk() throws Exception {
//        return elasticEmbedNode.search();
//    }


    @GetMapping("/terminal")
    public Object termimalServiceOk() throws Exception {
        return elasticTerminal.search();
    }
}
