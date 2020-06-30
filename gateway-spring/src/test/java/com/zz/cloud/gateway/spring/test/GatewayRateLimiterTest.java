package com.zz.cloud.gateway.spring.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.CountDownLatch;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GatewayRateLimiterTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private int threadCnt = 1000;
    private CountDownLatch latch = new CountDownLatch(threadCnt);
    private int okCnt = 0;
    private int failCnt = 0;
    private int expCnt = 0;
    private int returnCnt = 0;
    int[] threadFlags = new int[1300];

    protected synchronized void incOkCnt() {
        this.okCnt ++;
    }

    protected synchronized void incFailCnt() {
        this.failCnt ++;
    }

    protected synchronized void incExpCnt() {
        this.expCnt ++;
    }

    protected synchronized void incReturnCnt() {
        this.returnCnt ++;
    }

    class Runner implements Runnable {
        @Override
        public void run() {
            System.out.println("【当前线程ID】:" + Thread.currentThread().getId());

            threadFlags[((int) Thread.currentThread().getId())] = 1;

            try {
                ResponseEntity responseEntity = restTemplate.getForEntity("http://localhost:" + port + "/hello/tst/port?token=111", String.class);
                if(responseEntity.getStatusCode().equals(HttpStatus.OK)) {
                    incOkCnt();
                    System.out.println(Thread.currentThread().getId() + ": " + responseEntity.getBody().toString());
                } else {
                    incFailCnt();
                }
            } catch (Exception e) {
                incExpCnt();
            } finally {
                incReturnCnt();
            }

            latch.countDown(); // 执行完毕，计数器减1
        }
    }

    @Test
    public void testRateLimiter() throws Exception {
        for (int i = 0; i < threadCnt; i++) {
            new Thread(new Runner(), "JUNIT多线程测试").start();
        }

        try {
            latch.await(); // 主线程等待

            System.out.println("ok cnt: " + okCnt);
            System.out.println("fail cnt: " + failCnt);
            System.out.println("exception cnt: " + expCnt);
            System.out.println("return cnt: " + returnCnt);

            assertThat(okCnt).isBetween(10, 15);

            int sum = 0;
            for (int i = 0; i < threadFlags.length; i++) {
                sum += threadFlags[i];
            }
            System.out.println("threadFlags sum: " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
