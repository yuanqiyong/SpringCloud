package com.springcloud.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAutoConfiguration
@RestController
@Profile("configclient")
public class Demo6 {

	/**
	 * http://localhost:8766/version
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Demo6.class, args);
	}

	@Value("${version}")
	String version;

	@GetMapping("/version")
	public String version() {
		return version;
	}

}
