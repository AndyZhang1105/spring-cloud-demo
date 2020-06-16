package com.zz.cloud.callservice.controller;

import com.zz.cloud.callservice.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hi")
    public String hello() {
        return helloService.sayHiFromClientOne();
    }

    @RequestMapping("/tst")
    public String tst() {
        return helloService.sayTstFromClientOne();
    }

}