package com.example.springboot.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/shaseng")
public class ShasengCallBack {
	
	private static final Logger log = LoggerFactory.getLogger(ShasengCallBack.class);
	
	@RequestMapping(path = "createOrder/ascallback",method = {RequestMethod.POST})
	private ResponseEntity<JSONObject> CreateOrderResp(HttpServletRequest request,HttpServletResponse response){
		log.info(" ============== shaseng-NotifyUrl start ================ ");
		String message = "";
		String line = "";
		try {
			InputStream input = request.getInputStream();
			BufferedReader read = new BufferedReader(new InputStreamReader(input));
			if((line = read.readLine())!= null){
				message += line;
			}
		} catch (IOException e) {
			log.info(e.getMessage());
		}
		
		JSONObject jsonObject = new JSONObject();
		
		//处理逻辑
		log.info(" ****** Message ******** " + message);
		
		jsonObject.put("result", "success");
		log.info(" ============== shaseng-NotifyUrl end ================ ");
		return ResponseEntity.ok(jsonObject);
	}
}
