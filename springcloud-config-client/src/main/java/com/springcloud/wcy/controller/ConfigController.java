package com.springcloud.wcy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanchongyang
 * @date 2018-12-16 22:08
 */
@RestController
public class ConfigController {
    @Value("${foo}")
    private String foo;

    @GetMapping(value = "/config/get")
    public String getConfig() {
        return foo;
    }
}
