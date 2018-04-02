package com.example.springboot.enmus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public enum ProcessRunEnum {
	//审核信息对应的 级别（0:, 初审, 1:一级车评, 2:复审, 3:外访, 4:二级车评, 5:终审, 6:风控经理, 7:总经理审）
	
	create_order(-1,"新建"),
	order_first_evaluate(0,"初审"),
	car_first_evaluate(1,"一级车评"),
	order_second_evaluate(2,"复审"),
	car_second_evaluate(4,"二级车评"),
	order_final_evaluate(5,"终审"),
	outer_visit(3,"外访"),
	risk_control(6,"风控经理"),
	gm_approve(7,"总经理审"),
	
	order_first_evaluate_contract(8,"初审上传合同"),
	contract_approve(9,"合同管理员"),
	treasury_approve(10,"资管"),
	
	complete(100,"贷后");
	
	private Integer id; 
	private String name;
	private static Map<String, ProcessRunEnum> map;
	
	static{
		map=new HashMap<String, ProcessRunEnum>(values().length);
		for (ProcessRunEnum item : values()) {
			map.put(item.name(), item);
		}
	}

	private ProcessRunEnum() {
	}

	private ProcessRunEnum(Integer id, String name) {
		this.id = id;
		this.name = name;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static Map<String,String> getNameMap() {
		Map<String,String> result=new HashMap<String,String>();
		ProcessRunEnum[] enums = values();
		for (ProcessRunEnum e : enums) {
			result.put(e.toString(),e.getName());
		}
		return result;
	}
	
	public static String getStatusName(Integer id) {
		ProcessRunEnum[] enums = values();
		for (ProcessRunEnum e : enums) {
			if (e.getId() == id) {
				return e.getName();
			}
		}
		return null;
	}
	
	public static Integer getKey(String roleName) {
		ProcessRunEnum[] enums = values();
		for (ProcessRunEnum e : enums) {
			if (e.toString().equalsIgnoreCase(roleName)) {
				return e.getId();
			}
		}
		return null;
	}

	public static List<ProcessRunEnum> getStatusName() {
		List<ProcessRunEnum> list = new ArrayList<ProcessRunEnum>();
		ProcessRunEnum[] enums = values();
		for (ProcessRunEnum e : enums) {
			list.add(e);

		}
		return list;
	}
	
	public static Integer getIdByElement(String element) {
		if (map.containsKey(element)) {
			return map.get(element).getId();
		}
		return null;
	}

}
