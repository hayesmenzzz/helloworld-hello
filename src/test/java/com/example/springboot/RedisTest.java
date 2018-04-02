package com.example.springboot;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.springboot.redis.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootHelloApplication.class)
public class RedisTest {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
//	@Autowired
	@Resource
	private RedisTemplate<String, User> redisTemplate;
	
	@Test
	public void test() throws Exception{
		/**
		 * StringRedisTemplate实现RedisTemplate<K,V>
		 * SpringBoot 不支持存储RedisTemplate<String,Object> 需要自己实现RedisSerializer<T>接口来对传入对象进行序列化和反序列化
		 */
		stringRedisTemplate.opsForValue().set("www", "222");
		Assert.assertEquals("222", stringRedisTemplate.opsForValue().get("www"));
	}
	
	/**
	 * 打开RedisConfig的配置 就报错
	 * redis-cli --raw 可中文显示key
	 */
	@Test
	public void test02(){
		User user = new User("超人", 20);
		redisTemplate.opsForValue().set(user.getUsername(), user);
		user = new User("蝙蝠侠", 30);
		redisTemplate.opsForValue().set(user.getUsername(), user);
		user = new User("蜘蛛侠", 40);
		redisTemplate.opsForValue().set(user.getUsername(), user);
		
		Assert.assertEquals(20, redisTemplate.opsForValue().get("超人").getAge().longValue());
		Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
		Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());
	}
	
}
