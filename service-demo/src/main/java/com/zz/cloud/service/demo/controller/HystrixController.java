package com.zz.cloud.service.demo.controller;

import com.zz.cloud.service.demo.service.ServiceHello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hello")
public class HystrixController {

    @Autowired
    ServiceHello serviceHello;

    @GetMapping(value = "/hiFromFeign")
    public String hiFromFeign(@RequestParam String name) {
        return serviceHello.sayHiFromClientOne(name);
    }

}

