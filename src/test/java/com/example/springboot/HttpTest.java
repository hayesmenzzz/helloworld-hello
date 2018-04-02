/**
 * Project Name:midai-oa-service-impl
 * File Name:HttpTest.java
 * Package Name:com.midai.test
 * Date:2017年12月25日下午2:47:18
 * Copyright (c) 2017, jing9241120@sina.com
 *
*/

package com.example.springboot;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.springboot.SpringBootHelloApplication;
import com.example.springboot.httpclient.HttpClient;

import lombok.extern.slf4j.Slf4j;

/**
 * ClassName:HttpTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年12月25日 下午2:47:18 <br/>
 * @author   孟海山  
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootHelloApplication.class)
public class HttpTest {

	@Autowired
	private HttpClient httpClient;
	
	@Test
	public void test01(){
		String resp = httpClient.myPostTest();
		log.info("---"+resp);
		System.out.println("===="+resp);
	}
	
	@Test
	public void test02(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("", "");
		httpClient.myGetTest(map);
	}
	
	public static void main(String[] args) {
		System.out.println("now:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}
	
	
	
	
	
	
	
	
	
}

