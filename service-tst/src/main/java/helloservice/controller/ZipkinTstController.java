package helloservice.controller;

import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@RequestMapping(path = "/zipkin")
@RestController
public class ZipkinTstController {

    private static final Logger LOG = Logger.getLogger(ZipkinTstController.class.getName());

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/hi")
    public String home(){
        LOG.log(Level.INFO, "/tst/hi is being called");
        return "hi i'm miya!";
    }

    @GetMapping("/miya")
    public String info(){
        LOG.log(Level.INFO, "/tst/miya is being called");
        return restTemplate.getForObject("http://localhost:8768/zipkin/info",String.class);
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

}
