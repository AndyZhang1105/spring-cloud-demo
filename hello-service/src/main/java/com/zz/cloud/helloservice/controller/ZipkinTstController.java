package com.zz.cloud.helloservice.controller;

import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/zipkin")
public class ZipkinTstController {

    private static final Logger LOG = Logger.getLogger(ZipkinTstController.class.getName());

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/hi")
    public String home() {
        LOG.log(Level.INFO, "calling trace service-hello, hi");
        return restTemplate.getForObject("http://localhost:8767/zipkin/miya", String.class);
    }

    @GetMapping("/info")
    public String info() {
        LOG.log(Level.INFO, "calling trace service-hello, info ");
        return "i'm service-hello";
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

}
