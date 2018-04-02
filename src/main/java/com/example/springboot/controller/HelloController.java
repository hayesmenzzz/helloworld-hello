package com.example.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.springboot.dubbo.DubboConsumerService;
import com.example.springboot.dubbo.api.SayHelloService;
import com.example.springboot.dubbo.vo.SayHelloVo;

import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;

@RestController
public class HelloController {

	protected static Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@Autowired
	private DubboConsumerService dubboService;
	
	@Reference(version = "1.0.0")
	private SayHelloService sayHelloService;
	
	@RequestMapping("/")
	public String helloworld(){
		logger.debug("访问hello");
		return "Hello World!";
	}
	
	@RequestMapping("/hello/{Name}")
	public String helloName(@PathVariable String Name){
		logger.debug("访问helloName，Name={}",Name);
		
		return "Hello " + Name + ";" + dubboService.hello();
	}
	
	@ApiOperation(value="测试")
	@RequestMapping(value = "/sayHello" , method = {RequestMethod.GET})
	public ResponseEntity<JSONObject> wellcome(@RequestBody SayHelloVo vo){
		String result = sayHelloService.sayHello(vo);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", result);
		return ResponseEntity.ok(jsonObject);
	}
	
}
