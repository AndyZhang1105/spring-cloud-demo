package com.zz.cloud.callservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "hello-service")
public interface HelloService {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClientOne();

    @RequestMapping(value = "/tst/index", method = RequestMethod.GET)
    String sayTstFromClientOne();

}
