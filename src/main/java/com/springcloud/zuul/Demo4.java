package com.springcloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@Profile("zuul")
public class Demo4 {
	/**
	 * http://localhost:8764/api-1/hi?name=yuanqy&token=123456
	 * 
	 * http://localhost:8764/api-2/hi?name=yuanqy&token=123456
	 */
	public static void main(String[] args) {
		SpringApplication.run(Demo4.class, args);
	}
}
