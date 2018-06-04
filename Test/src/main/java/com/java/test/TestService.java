package com.java.test;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class TestService implements TestServiceInterface {

	public String type;
	public void setType(String type) {
		this.type = type;
	}

	public String test() {
		return "test";
	}
	
	public HashMap<String, Object> test3() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		System.out.println(type);
		
		/*if(type.equals("select")) {*/
			map.put("view", "test");
			map.put("data", "안녕하세요!");
		/*}*/
		
		return map;
	}
	
	public String test4() {
		System.out.println("test4");
		return "test";
	}
}
