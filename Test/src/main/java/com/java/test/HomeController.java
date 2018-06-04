package com.java.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/****************************************
 * 응용 프로그램 홈 페이지에 대한 요청을 처리합니다.
 ****************************************/
@Controller
public class HomeController {
	
	/**********************************************
	 * 해당 클래스에서 발생하는 로그를 출력하기 위하여 사용합니다.
	 **********************************************/
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/*******************************************
	 * 이름을 반환하여 렌더링 할 홈 뷰를 선택하기만 하면됩니다.
	 *******************************************/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		/********************************
		 * 현재 일시에 대한 값을 변수에 대입한다.
		 ********************************/
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		/***************************************************
		 * 요청한 곳으로 데이터를 보내기 위하여 키와 값을 속성으로 담는다.
		 * model : 데이터 집합
		 * addAttribute : 데이터 속성 추가
		 * "serverTime" : 데이터 속성 키 이름
		 * formattedDate : 데이터 속성 키 이름에 담을 값
		 ***************************************************/
		model.addAttribute("serverTime", formattedDate );
		
		/***************************************************************************
		 * 요청한 결과를 화면으로 보내기 위하여 ViewResolver에서 선언한 내용을 결합하여 화면를 보낸다.
		 * prefix           + 리턴값  + suffix   조합   파일 위치값
		 * /WEB-INF/views/    home   .jsp      >  /WEB-INF/views/home.jsp  
		 ***************************************************************************/
		return "home";
	}
	
}