package com.pgy.spring.cloud.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@EnableEurekaClient
@Configuration
@RestController
public class Application {
	@RequestMapping("/user")
	  public String home() {
	    return "Hello World";
	  }
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
}
