package com.java.test.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/view")
public class Board2Controller {
	
	@Autowired
	Board2ServiceInterface bsi; // BoardService 사용 할 수 있도록 주입 받기.
	
	@RequestMapping("/{menu}/{type}")
	public ModelAndView boardMnV(@PathVariable("menu") String menu,
								@PathVariable("type") String type, HttpServletRequest req) {
		return bsi.boardMnV(menu, type, req);
	}
	
}
