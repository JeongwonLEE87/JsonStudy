package com.java.test.board;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
//@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardServiceInterface bsi; // BoardService 사용 할 수 있도록 주입 받기.
	
	HashMap<String, Object> param;  // model로 사용할 전역 변수 선언
	
	@RequestMapping("/selectList")
	public String selectList(Model model) {
		model.addAttribute("data", bsi.selectList());
		return "boardList"; // jsp 화면 출력
	}
	
	@RequestMapping("/selectOne")
	public String selectOne(Model model, HttpServletRequest req) {
		model.addAttribute("data", bsi.selectOne(getParamMap(req)));
		return "boardOne"; // jsp 화면 출력
	}
	
	@RequestMapping("/insert")
	public String insert(Model model, HttpServletRequest req) {
		model.addAttribute("data", bsi.insert(getParamMap(req)));
		return "redirect:selectList"; // selectList에게 기능 전달
	}
	
	@RequestMapping("/updateView")
	public String updateView(Model model, HttpServletRequest req) {
		model.addAttribute("data", bsi.selectOne(getParamMap(req)));
		return "updateView"; // jsp 화면 출력
	}
	
	@RequestMapping("/update")
	public String update(Model model, HttpServletRequest req) {
		model.addAttribute("data", bsi.update(getParamMap(req)));
		return "redirect:selectList"; // selectList에게 기능 전달
	}
	
	@RequestMapping("/delete")
	public String delete(Model model, HttpServletRequest req) {
		model.addAttribute("data", bsi.delete(getParamMap(req)));
		return "redirect:selectList"; // selectList에게 기능 전달
	}

    public HashMap<String, Object> getParamMap(HttpServletRequest req){
    	HashMap<String, Object> result = new HashMap<String, Object>();
    	
    	Enumeration<?> enums = req.getParameterNames();
    	while(enums.hasMoreElements()) {
    		String paramName = enums.nextElement().toString();
    		result.put(paramName, req.getParameter(paramName));
    	}
    	
    	return result;
    }
}
