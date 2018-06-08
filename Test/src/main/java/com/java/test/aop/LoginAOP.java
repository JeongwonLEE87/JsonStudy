package com.java.test.aop;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import com.java.test.util.HttpUtil;

@Aspect
public class LoginAOP {

	@Autowired
	LoginAOPInterface lai;
	
	@Around("within(com.java.test.user.UserController)")
	public Object loginCheck(ProceedingJoinPoint jp) {
		
		String name = jp.getSignature().getName();
		System.out.println(name + "호출됨!");
		
		/**************************************************************/
		Object[] args = jp.getArgs();
		for(int i = 0; i < args.length; i++) {
			if(args[i] instanceof HttpServletRequest) {
				HttpServletRequest req = (HttpServletRequest) args[i];
				HashMap<String, Object> params = HttpUtil.getParamMap(req);
				String id = params.get("id").toString();
				String pwd = params.get("pwd").toString();
				params.put("pass", pwd);
				
				System.out.println("inputId: "+id+", inputPwd: "+pwd);
				System.out.println("LoginAOP params: "+params);
				
				HashMap<String, Object> resultMap = lai.loginCheck(params);
				
				System.out.println("LoginAOP resultMap: "+resultMap);
				
				
				boolean check = false;
				
				if(resultMap == null) {
					
					System.out.println("resultMap is null");
					
					check = false;
				} else {
					
					System.out.println("resultMap is not null");
					if(resultMap.get("id").equals(id)) {
						System.out.println("resultMap id is equal");
						if(resultMap.get("pass").equals(pwd)) {
							System.out.println("resultMap pass is equal");
							check = true;
						}
					}
				}
				
				
				if(check) {
					try {
						return jp.proceed();
					} catch (Throwable e) {
						e.printStackTrace();
					}
				} else {
					HashMap<String, Object> map = new HashMap<String, Object>();
					map.put("status", 0);
					map.put("msg", "누구세용?");
					return HttpUtil.makeJsonView(map);
				}
			}
		}
		/**************************************************************/
		return args;
	}
}
