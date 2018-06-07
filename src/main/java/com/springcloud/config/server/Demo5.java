package com.springcloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaServer
@Profile("configserver")
public class Demo5 {

	/**
	 * GIT ： http请求地址和资源文件映射如下:
	 * 
	 * /{application}/{profile}[/{label}] <br>
	 * /{application}-{profile}.yml <br>
	 * /{label}/{application}-{profile}.yml <br>
	 * /{application}-{profile}.properties <br>
	 * /{label}/{application}-{profile}.properties <br>
	 * 
	 * @param args
	 * @demo http://localhost:8765/master/application
	 * @demo http://localhost:8765/application/configclient/master
	 * @demo http://localhost:8765/master/application-configclient.yml
	 * 
	 */
	public static void main(String[] args) {
		SpringApplication.run(Demo5.class, args);
	}
}
