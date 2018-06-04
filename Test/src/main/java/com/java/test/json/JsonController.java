package com.java.test.json;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

@Controller
public class JsonController {

	@RequestMapping("/json")
	public String getJson(Model model) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("key", "value");
		
		JSONObject j = new JSONObject();
		j = JSONObject.fromObject(JSONSerializer.toJSON(map));
		
		model.addAttribute("json", j);
		return "json";
	}
	
	@RequestMapping("/json2")
	public String getJson2(HttpServletResponse res) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("key", "value");
		
		JSONObject j = new JSONObject();
		j = JSONObject.fromObject(JSONSerializer.toJSON(map));
		
		
		return "json";
	}
}