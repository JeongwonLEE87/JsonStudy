package com.java.test.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public interface Board2ServiceInterface {
	public String board(String type, HttpServletRequest req, Model model);
	public ModelAndView boardMnV(String menu, String type, HttpServletRequest req);
}
