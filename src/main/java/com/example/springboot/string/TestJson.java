package com.example.springboot.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TestJson {

	public static void main(String[] args) {

		String result = "{\"SCNF\":\"2014\",\"SSYF\":\"3\"}";
//		String result = "{\"code\": 200,\"message\": [{\"id\": 4,\"name\": \"AC Schnitzer\"},{\"id\": 162,\"name\": \"ALPINA\"},{\"id\": 161,\"name\": \"ARCFOX\"},{\"id\": 33,\"name\": \"DS\"},{\"id\": 52,\"name\": \"GMC\"}]}";
//		String result = "{\"date\":\"2018-3\",\"mile\":\"\",\"is_run\":\"\",\"transfer\":\"\",\"color\":\"\",\"vin\":\"LFV2B28V6E5004981\",\"city\":\"\\u4e1c\\u57ce\",\"min_price\":\"22.90\"}";
		List<Map<String,String>> resultList = new ArrayList<Map<String,String>>();
		Map<String,String> map = new HashMap<String,String>();
//		JSONObject jsonObject = JSONObject.fromObject(result);
//		JSONArray jan = (JSONArray) jsonObject.get("message"); 
		
		JSONObject jan = JSONObject.fromObject(result);
		System.out.println(jan.getString("SCNF")+";"+jan.getString("SSYF")+";");
//		System.out.println(jan.toString());
//		if(jan!=null||jan.size()!=0){ 
//			for(int i=0;i<jan.size();i++){ 
//				JSONObject jo = JSONObject.fromObject(jan.get(i));
//				String id = jo.getString("date");
//				String name = jo.getString("mile");
//				map.put("id", id);
//				map.put("name", name);
//				System.out.println("id:"+id+"==name:"+name);
//				resultList.add(map);
//			}
//		}
//		System.out.println("============================");
		for(Map<String, String> map1 :resultList){

			for(Entry<String,String> entry : map1.entrySet()){
				 System.out.println("KEY:"+entry.getKey()+"  -->  Value:"+entry.getValue()+"\n"); 
			 }
		
		}
		
		
		
		//Map<String,String[]> map=request.getParameterMap(); 
		//for(Iterator iter=map.entrySet().iterator();iter.hasNext();){  
		// Map.Entry element=(Map.Entry)iter.next();
		// Object strKey = element.getKey();
		//String[] value=(String[])element.getValue();
		// System.out.print(strKey.toString() +"=");
//		 for(int i=0;i<value.length;i++){  
//	         System.out.print(value[i]+",");  
//	     }   
		
		
		
		//
//		Object json = JSONObject.fromObject(result).get("message");
//		System.out.println(json.toString());
//		
//		JSONArray jsonR = JSONArray.fromObject(json);
//		for(int i= 0;i<jsonR.size();i++){
//			System.out.println(jsonR.get(i));
//		}
//		
//		
//		
//		
//		
//		for(Object o:jsonR){
//			List<List<Map<String,String>>> listMaps = (List<List<Map<String,String>>>) o;
//			
////			System.out.println("KEY:"+map.get("name"));
//			for(List<Map<String,String>> listMap : listMaps){
//				for(Map<String,String> map : listMap){
//					for(Entry<String,String> entry : map.entrySet()){
//						 System.out.println("KEY:"+entry.getKey()+"  -->  Value:"+entry.getValue()+"\n"); 
//					 }
//				}
//				 
//			}
			
//			Map<String,String> maps = new HashMap<String,String>();
//		}
//		JSONObject myJson = JSONObject.fromObject(result);
//		System.out.println(myJson.toString());
//		
//		JSONArray jsonR = JSONArray.fromObject(result);
//		System.out.println(jsonR.toString());
		
//		 Map<String, Object> mapJson = JSONObject.fromObject(myJson);
//		 for(Entry<String,Object> entry : mapJson.entrySet()){
//	            Object strval1 = entry.getValue();
//	            JSONObject jsonObjectStrval1 = JSONObject.fromObject(strval1);
//	            Map<String, Object> mapJsonObjectStrval1 = JSONObject.fromObject(jsonObjectStrval1);
//	            System.out.println("KEY:"+entry.getKey()+"  -->  Value:"+entry.getValue()+"\n");
//	            for(Entry<String, Object> entry1:mapJsonObjectStrval1.entrySet()){
//	                System.out.println("KEY:"+entry1.getKey()+"  -->  Value:"+entry1.getValue()+"\n");
//	            }
//	             
//	        }
		
		
		
		
		
		
//		Map m = (Map)myJson; 
//		for(Map.Entry<Object, Object> entry:m.entrySet()){
//			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
//		}
		
		
		
		
		
		
		
		
		
		//		Object json = JSONObject.fromObject(result).get("message");
		
		
		
		
//		JSONArray fromObject = JSONArray.fromObject(json);
//		JSONObject fromObject2 = JSONObject.fromObject(json);
//		Map<String,String> map = (Map) JSONObject.toBean(fromObject2, Map.class);
//		for(Map.Entry<String, String> entry:map.entrySet()){
//			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
//		}
//		System.out.println(fromObject.toString());
//		Map<String, String> map = new HashMap<String, String>();
//		for(Object key:json.keySet()){
//			Object value = json.get(key);
//			System.out.println(value.toString());
////			if(value instanceof JSONArray){
////				List<Map<String, String>> list = new ArrayList<Map<String,String>>();   
////				Iterator<JSONObject> iterator = ((JSONArray)value).iterator();
////				while(iterator.hasNext()){
////					JSONObject json2 = iterator.next(); 
////					list.add(parseJSON2Map(json2.toString()));
////				}
////			}
//		}
		
//		System.out.println(object.toString());
//		for(
//		 JSONArray jsonR = JSONArray.fromObject(result); 
//		 System.out.println(jsonR.get(0));
//		 System.out.println(jsonR.get(1));
	}

}
