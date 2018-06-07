package com.springcloud.feign.bus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	IFeignService feignService;

	@GetMapping(value = "/hi")
	public String sayHi(@RequestParam String name) {
		log.info("Action sayHi:" + name);
		return feignService.sayHi(name);
	}
}