package com.springcloud.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@EnableEurekaServer // 开启Eureka，提供注册中心
@Profile("eurekaserver")
public class Demo1 {

	/**
	 * http://localhost:8761
	 */
	public static void main(String[] args) {
		SpringApplication.run(Demo1.class, args);
	}
}
