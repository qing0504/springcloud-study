package com.springcloud.wcy.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wanchongyang
 * @date 2018-12-16 16:43
 */
@FeignClient(value = "service-hello", fallback = HystrixHelloService.class)
public interface FeignHelloService {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String sayHelloFromClientOne(@RequestParam(value = "name") String name);
}
