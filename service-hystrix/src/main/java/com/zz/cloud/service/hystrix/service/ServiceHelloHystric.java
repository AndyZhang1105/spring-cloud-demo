package com.zz.cloud.service.hystrix.service;

public class ServiceHelloHystric implements ServiceHello {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry " + name;
    }

}
