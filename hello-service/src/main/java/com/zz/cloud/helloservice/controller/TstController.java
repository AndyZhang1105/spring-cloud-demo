package com.zz.cloud.helloservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/tst")
public class TstController {

    @Value("${server.port}")
    private String port;

    @GetMapping(path = "/index")
    public String getIndex() {
        return "/tst/index";
    }

    @GetMapping(path = "/port")
    public String getPort() {
        return "/tst/port: " + port;
    }

}
