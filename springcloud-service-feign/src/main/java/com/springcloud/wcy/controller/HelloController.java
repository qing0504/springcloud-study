package com.springcloud.wcy.controller;

import com.springcloud.wcy.service.FeignHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanchongyang
 * @date 2018-12-16 16:46
 */
@RestController
public class HelloController {
    @Autowired
    private FeignHelloService feignHelloService;

    @GetMapping(value = "/hi")
    public String sayHello(@RequestParam String name) {
        return feignHelloService.sayHelloFromClientOne(name);
    }
}
