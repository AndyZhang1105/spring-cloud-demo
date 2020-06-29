package com.zz.cloud.service.demo.test;

import com.zz.cloud.service.demo.ServiceDemoApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private ServiceDemoApplication serviceDemoApplication;

    @Test
    public void contexLoads() throws Exception {
        assertThat(serviceDemoApplication).isNotNull();
    }

}
