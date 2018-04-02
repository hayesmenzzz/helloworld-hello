package com.example.springboot.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * MAP 的四种遍历方式
 * @author Administrator
 *
 */
public class TestMap {
	
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("A", "a");
		map.put("B", "b");
		map.put("C", "c");
		map.put("D", "d");
		
		//
		for(Entry<String,String> entry:map.entrySet()){
			System.out.print(entry.getKey()+"-"+entry.getValue());
		}
		
		System.out.println();
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, String> entry = it.next();
			System.out.print(entry.getKey()+"-"+entry.getValue());
		}
		System.out.println();
		
	}

}
