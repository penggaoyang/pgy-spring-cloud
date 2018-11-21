package com.pgy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class HystrixCommandController {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/hystrixTimeout")
    public String hystrixTimeout() {
        log.error("i5xforyou-service-gateway触发了断路由");
        return "i5xforyou-service-gateway触发了断路由=hystrixTimeout";
    }

    @HystrixCommand(commandKey="authHystrixCommand")
    public String authHystrixCommand() {
        return "i5xforyou-service-gateway触发了断路由---authHystrixCommand";
    }

}

