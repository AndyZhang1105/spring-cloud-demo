package com.zz.cloud.service.hystrix.controller;

import com.zz.cloud.service.hystrix.service.HelloService;
import com.zz.cloud.service.hystrix.service.ServiceHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hello")
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping(value = "/hiFromRibbon")
    public String hiFromRibbon(@RequestParam String name) {
        return helloService.hiService( name );
    }

    @Autowired
    ServiceHello serviceHello;

    @GetMapping(value = "/hiFromFeign")
    public String hiFromFeign(@RequestParam String name) {
        return serviceHello.sayHiFromClientOne(name);
    }

}

