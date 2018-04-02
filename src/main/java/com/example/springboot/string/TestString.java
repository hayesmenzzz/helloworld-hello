package com.example.springboot.string;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.example.springboot.enmus.ProcessRunEnum;

public class TestString {

	public static void main(String[] args) throws ParseException {
		String tests = "order_first_evaluate_contract!10";
		String tests3 = "complete";
		String tests2 = "-order_final_evaluate";
		String aa = "order_first_evaluate,car_second_evaluate";
		String tests1 = "-complete";
	
		String time = "2018-01-18 00:00:00";
		System.out.println(time.split(" ")[0]);
		
		Calendar specialDate = Calendar.getInstance();
		specialDate.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time));
		specialDate.add(Calendar.DAY_OF_YEAR, 14);
		//string 转 calendar 进行加减计算  calendar 转date
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((specialDate.getTime())));
//		if(!aa.contains(",")){
//			if(!tests.startsWith("-")){
//				String state = tests.split("!")[0];
//				Integer idByElement = ProcessRunEnum.getIdByElement(state);
////				if(idByElement > 8){
//					System.out.println("可以放款");
////				}
//			}
//		}
//		
	}
}
