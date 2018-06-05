package com.java.test.board;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.java.test.util.HttpUtil;

@Service
public class Board2Service implements Board2ServiceInterface {

	@Autowired
	BoardDaoInterface bdi; // BoardDao 사용할수 있도록 주입 받기 
	
	HashMap<String, Object> param; // 파라메터 사용할 전역 변수 선언 : param => type, param, sql
	String view;
	ModelAndView mav;
	
	@Override
	public String board(String type, HttpServletRequest req, Model model) {
		
		param = new HashMap<String, Object>();
		param.put("type", type);
		param.put("param", HttpUtil.getParamMap(req));
		
		if("selectList".equals(type)) {
			view = "boardList";
		}else if("selectOne".equals(type)) {
			view = "boardOne";
		}else if("insert".equals(type)) {
			view = "redirect:selectList";
		}else if("updateView".equals(type)) {
			param.put("type", "selectOne");
			view = "updateView";
		}else if("update".equals(type)) {
			view = "redirect:selectList";
		}else if("delete".equals(type)) {
			view = "redirect:selectList";
		}

		model.addAttribute("data", bdi.board(param));
		
		return view;
	}

	@Override
	public ModelAndView boardMnV(String menu, String type, HttpServletRequest req) {
		mav = new ModelAndView();
		
		param = new HashMap<String, Object>();
		param.put("menu", menu);
		param.put("type", type);
		
		
		if("selectList".equals(type)) {
			mav.setViewName("boardList");
		}else if("selectOne".equals(type)) {
			mav.setViewName("boardOne");
		}else if("insert".equals(type)) {
			mav.setViewName("redirect:selectList");
		}else if("updateView".equals(type)) {
			param.put("type", "selectOne");
			mav.setViewName("updateView");
		}else if("update".equals(type)) {
			mav.setViewName("redirect:selectList");
		}else if("delete".equals(type)) {
			mav.setViewName("redirect:selectList");
		}
		
		
		System.out.println("ServiceMnV param="+param);
		mav.addObject("data", bdi.board(param));
		return mav;
	}

	@Override
	public ModelAndView getJson(String menu, String type, HttpServletRequest req) {
		mav = new ModelAndView();
		
		param = new HashMap<String, Object>();
		param.put("menu", menu);
		param.put("type", type);
		if("updateView".equals(type)) {
			param.put("type", "selectOne");
		}
		
		HashMap<String, Object> map = HttpUtil.getParamMap(req);
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		System.out.println("service layer map: "+map);
		
		if("updateView".equals(type)) {param.put("type", "selectOne");}
		
		if( map == null) {
			System.out.println("null 값이 옴!");
			result.put("status", 0);
			result.put("msg", "입력값이 없습니다.");
		}else {
			param.put("param", map);
			result = bdi.board(param);
			result.put("status", 1);
		}
		
		System.out.println("getJson method / menu="+menu+", type="+type);
		
		return HttpUtil.makeJsonView(result);
	}
	
	

}
