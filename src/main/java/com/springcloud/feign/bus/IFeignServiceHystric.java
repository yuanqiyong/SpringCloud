package com.springcloud.feign.bus;

import org.springframework.stereotype.Component;

/**
 * 如果Feign调用失败，则直接返回当前Hystric
 * 
 * @author yuanqy
 *
 */
@Component
public class IFeignServiceHystric implements IFeignService {

	@Override
	public String sayHi(String name) {
		return "[Call failed]: " + name;
	}

}
