package com.example.springboot;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import com.example.springboot.dubbo.DubboConsumerService;

import lombok.extern.slf4j.Slf4j;


@SpringBootApplication
@ImportResource("classpath*:META-INF/spring/*.xml")
public class SpringBootHelloApplication {

//	@Bean
//	public Queue queue(){
//		return new ActiveMQQueue("sample.queue");
//	}
	
	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SpringBootHelloApplication.class, args);
//		DubboConsumerService service = run.getBean(DubboConsumerService.class);
//		service.hello();
	}
}
