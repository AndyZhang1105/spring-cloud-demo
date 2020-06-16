package com.zz.cloud.helloservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/tst")
public class TstController {

    @GetMapping(path = "/index")
    public String getIndex() {
        return "/tst/index";
    }

}
