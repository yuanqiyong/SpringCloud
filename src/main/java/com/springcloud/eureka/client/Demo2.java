package com.springcloud.eureka.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Eureka服务提供者
 * 
 * 分别启动两次，创建两个服务提供者，端口分别为：8772，8762
 * 
 * @author yuanqy
 * @time 2018年6月5日 上午11:08:53
 */
@SpringBootApplication
@RestController // 配置Rest风格控制类
@EnableEurekaClient // 开启Eureka，提供服务
@Profile("eurekaclient")
public class Demo2 {
	Logger log = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(Demo2.class, args);
	}

	@Value("${server.port}")
	String port;

	@RequestMapping("/hi")
	public String sayHi(@RequestParam String name) {
		log.info("Action sayHi:" + name);
		return "hi " + name + ",i am from port:" + port;
	}
}
