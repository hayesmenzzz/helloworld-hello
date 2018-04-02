package com.example.springboot.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestStatic {

	public static void main(String[] args) {
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("A", "a");
		
		Map<String,String> map2 = new HashMap<>();
		build(map, map2);
		
		Set<Entry<String, String>> entrySet = map2.entrySet();
		for(Entry<String, String> entry:entrySet){
			System.out.println(entry.getKey()+","+entry.getValue());
		}
		
		
	}
	
	public static void build(Map A,Map B){
		B.putAll(A);
	}
}
