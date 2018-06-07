package com.springcloud.ribbon.bus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {
	@Autowired
	RestTemplate resttemplate;

	public String sayHi(String name) {
		return resttemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
	}
}
