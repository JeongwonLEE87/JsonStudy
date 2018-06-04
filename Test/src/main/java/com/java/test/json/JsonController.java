package com.java.test.json;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.test.util.HttpUtil;

@Controller
public class JsonController {

	@RequestMapping("/json")
	public ModelAndView getJson(Model model) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("key", "value");
		
		return HttpUtil.makeJsonView(map);
	}
	
	@RequestMapping("/json2")
	public void getJson2(HttpServletResponse res) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("key", "value2");
		HttpUtil.makeJsonWriter(res, map);
	}
}