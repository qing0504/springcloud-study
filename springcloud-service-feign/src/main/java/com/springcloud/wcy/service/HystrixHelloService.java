package com.springcloud.wcy.service;

import org.springframework.stereotype.Component;

/**
 * @author wanchongyang
 * @date 2018-12-16 17:31
 */
@Component
public class HystrixHelloService implements FeignHelloService {
    @Override
    public String sayHelloFromClientOne(String name) {
        return "sorry " + name + ", error!";
    }
}
