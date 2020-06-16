package com.zz.cloud.client.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Path;

@RequestMapping(path = "/tst")
@RestController
public class TstController {

    @Value("${my.prop}")
    String myProp;

    @Value("${eureka.client.serviceUrl.defaultZone}")
    String zuulProp;

    @GetMapping(path = "/props")
    public String tst() {
        return myProp;
    }

    @GetMapping(path = "/zuul")
    public String zuul() {
        return zuulProp;
    }

}
