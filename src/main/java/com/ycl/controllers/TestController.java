package com.ycl.controllers;

import com.ycl.services.Opendistro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    Opendistro opendistro;

    @GetMapping("/")
    public Object serviceOk() throws Exception{

        return opendistro.search();

    }
}
