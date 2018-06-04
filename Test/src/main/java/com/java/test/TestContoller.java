package com.java.test;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestContoller {
	
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	
	/*@Autowired
	TestServiceInterface ts;*/
	
	@Resource(name="testService")
	TestService ts;
			
	@RequestMapping("/test2")
	public String test2(String result) {
		result = ts.test();
		return result;
	}
	
	@RequestMapping("/test3")
	public String test3(Model model) {
		model.addAttribute("result", ts.test3());
		return "test";
	}
	
}
