package com.springcloud.feign.bus;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * FeignHTTP负载均衡客户端
 * fallback：断路器
 * @author yuanqy
 */
@FeignClient(value = "SERVICE-HI", fallback = IFeignServiceHystric.class)
public interface IFeignService {

	@GetMapping(value = "/hi")
	String sayHi(@RequestParam(value = "name") String name);
}