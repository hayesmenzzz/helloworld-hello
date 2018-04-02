package com.example.springboot.dubbo;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.springboot.dubbo.api.TestService;
@Component
public class DubboConsumerService {

	@Reference(version = "1.0.0")
	private TestService testService;
	
	public String hello(){
		return testService.sayHello("God");
	}
}
