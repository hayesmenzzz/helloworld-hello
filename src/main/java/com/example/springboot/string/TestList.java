package com.example.springboot.string;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * List 的四种遍历
 * @author Administrator
 *
 */

public class TestList {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(5);
		list.add(2);
		list.add(3);
		list.add(4);
		
		
		//for each 循环
		for(Integer i:list){
			System.out.print(i);
		}
		
		System.out.println();
		
		//集合迭代器
//		Iterator<Integer> iterator = list.iterator();
//		while (iterator.hasNext()) {
//			Integer integer = (Integer) iterator.next();
//			System.out.print(integer);
//		}
		
		for(Iterator<Integer> iterator = list.iterator();iterator.hasNext();){
			Integer next = iterator.next();
			System.out.print(next);
		}
		
		System.out.println();
		
		//下标递增循环，终止条件为每次调用size()函数比较判断
		for(int j = 0; j< list.size(); j++){
			Integer integer = list.get(j);
			System.out.print(integer);
		}
		
		//另外为下标递减
	}
}
