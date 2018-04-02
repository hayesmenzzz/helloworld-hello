package com.example.springboot.redis;

import java.io.Serializable;

import lombok.Data;

/**
 * 创建redis要存储的对象
 * @author Administrator
 *
 */
@Data
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6460514637392394055L;
	
	private String username;
	private Integer age;
	
	public User(String username,Integer age){
		this.username = username;
		this.age = age;
	}

}
