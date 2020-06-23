package com.zz.cloud.service.demo.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.zz.cloud.service.demo.ribbon.service.ServiceHello;

@RestController
@RequestMapping(path = "/hello")
public class HelloController {

    @Autowired
    ServiceHello serviceHello;

    @GetMapping(path = "/hi")
    public String hi(@RequestParam String name) {
        return serviceHello.sayHiFromClientOne(name);
    }

}
