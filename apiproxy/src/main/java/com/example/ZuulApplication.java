package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
// import org.springframework.context.annotation.ComponentScan;
// import org.springframework.stereotype.Controller;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
// import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
// @Configuration
// @ComponentScan
// @EnableAutoConfiguration
// @Controller
@EnableZuulProxy
public class ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
		// new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
	}
}
