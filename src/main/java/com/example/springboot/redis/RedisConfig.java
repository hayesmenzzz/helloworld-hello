package com.example.springboot.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 配置针对User的RedisTemplate实例
 * @author Administrator
 *
 */

//@Configuration
public class RedisConfig {

	private Logger log = LoggerFactory.getLogger(RedisConfig.class);
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory(){
		return new JedisConnectionFactory();
	}
	
	@Bean
	public RedisTemplate<String,User> redisTemplate(RedisConnectionFactory factory){
		RedisTemplate<String,User> template = new RedisTemplate<String,User>();
		template.setConnectionFactory(jedisConnectionFactory());
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new RedisObjectSerializer());
		log.info("create RedisTemplate success！");
		return template;
	}
	
	
}
