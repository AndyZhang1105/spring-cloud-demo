package com.zz.cloud.service.demo.controller;

import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class ZipkinController {

    private static final Logger logger = Logger.getLogger(ZipkinController.class.getName());

    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.zipkin.base-url}")
    private String zipkinBaseUrl;

    @RequestMapping("/hi")
    public String callHome(){
        logger.log(Level.INFO, "calling trace service-demo  ");
        return restTemplate.getForObject("http://localhost:8161/info", String.class);
    }

    @RequestMapping("/info")
    public String info(){
        logger.log(Level.INFO, "calling trace service-demo, info ");
        return "i'm service-demo, info";
    }

    @RequestMapping("/zipkin")
    public String zipkin(){
        logger.log(Level.INFO, "calling trace service-demo, zipkin ");
        return zipkinBaseUrl;
    }

}
