package com.zz.cloud.service.hello.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/tst")
public class TstController {

    @Value("${server.port}")
    private String port;

    @GetMapping(path = "")
    public String getIndex() {
        return "/tst";
    }

    @GetMapping(path = "/port")
    public String getPort() {
        return "/tst/port: " + port;
    }

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "ZZ") String name) {
        return "hi " + name + " , I am from port:" + port;
    }

}
