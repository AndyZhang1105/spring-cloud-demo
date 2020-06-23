package com.zz.cloud.service.demo.service;

public class ServiceHelloHystric implements ServiceHello {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry " + name;
    }

}
