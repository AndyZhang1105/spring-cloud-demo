package com.zz.cloud.gateway.spring.test;

import static org.assertj.core.api.Assertions.assertThat;

import com.zz.cloud.gateway.spring.GatewaySpingApplication;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private GatewaySpingApplication gatewaySpingApplication;

    @Test
    public void contexLoads() throws Exception {
        assertThat(gatewaySpingApplication).isNotNull();
    }

}
