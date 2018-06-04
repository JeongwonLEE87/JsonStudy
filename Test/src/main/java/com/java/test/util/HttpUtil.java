package com.java.test.util;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public class HttpUtil {
	public static HashMap<String, Object> getParamMap(HttpServletRequest req){
    	HashMap<String, Object> result = new HashMap<String, Object>();
    	
    	Enumeration<?> enums = req.getParameterNames();
    	while(enums.hasMoreElements()) {
    		String paramName = enums.nextElement().toString();
    		result.put(paramName, req.getParameter(paramName));
    	}
    	
    	return result;
    }
}
