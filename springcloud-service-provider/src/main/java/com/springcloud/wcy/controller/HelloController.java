package com.springcloud.wcy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanchongyang
 * @date 2018-12-15 21:24
 */
@RestController
public class HelloController {
    @Value("${server.port}")

    String port;

    @RequestMapping("/hello")
    public String home(@RequestParam String name) {
        return "hello " + name + ",i am from port:" + port;
    }
}
