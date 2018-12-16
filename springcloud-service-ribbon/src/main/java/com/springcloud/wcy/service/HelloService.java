package com.springcloud.wcy.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author wanchongyang
 * @date 2018-12-15 22:29
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloError")
    public String hello(String name) {
        return restTemplate.getForObject("http://SERVICE-HELLO/hello?name=" + name, String.class);
    }

    public String helloError(String name) {
        return "hello " + name + ", sorry, error!";
    }
}
