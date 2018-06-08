package com.java.test.aop;

import java.util.HashMap;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class TestAOP {
	
	@Autowired
	TestAOPInterface tai;
	
	@Pointcut("within(com.java.test..*)")
	private void pointCut() {}
	
	@Pointcut("bean(*Dao)")
	private void pointCutDAO() {}
	
//	공통적으로 사용하고 싶으면 @Pointcut 선언 후 범위설정
//	@Before("within(com.java.test..*)")
	@Before("within(com.java.test..*)")
	public void before(JoinPoint jp) {
		String name = jp.getSignature().toShortString();
		System.out.println("	$ AOP[Before] " + name + " 시작 전!");

		// 수행 매게변수를 가지고 온다
		Object[] obj = jp.getArgs();
		System.out.println("	$ AOP[Before] parameter's length: " + obj.length);
		
		// 들어오는 매개변수의 타입을 체크
		for(int i = 0; i < obj.length; i++) {
			System.out.println("	$ AOP[before] "+ obj[i]);
			if(obj[i] instanceof HashMap) {
				System.out.println("	$ AOP[before] HashMap 타입! ");
				HashMap<String, Object> map = (HashMap<String, Object>) obj[i];
				for(String key: map.keySet()) {
					System.out.println("	$ AOP: key: "+key+", value: "+map.get(key));
				}
			}
		}
	}

//	@After("within(com.java.test..*)")
	@After("pointCut()")
	public void after(JoinPoint jp) {
		String name = jp.getSignature().toShortString();
		System.out.println("	$ AOP[after] " + name + " 종료 후!");
	}

//	@Around("within(com.java.test..*)")
	@Around("pointCut()")
	public Object callAOP(ProceedingJoinPoint joinPoint) {
		String name = joinPoint.getSignature().toShortString();
		System.out.println("	$ AOP[around] " + name + "시작");
		
		/*******************************************************************/
		if(name.contains("Controller")) {
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("methodNm", joinPoint.getSignature().getName());
			Object[] args = joinPoint.getArgs();
			
			if(args[0] instanceof String) { param.put("menu", args[0]); };
			if(args[1] instanceof String) { param.put("type", args[1]); };
			
			tai.insert(param);
		}
		/*******************************************************************/
		
		long st = System.currentTimeMillis();

		try {
			Object obj = joinPoint.proceed();
			return obj;
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			long et = System.currentTimeMillis();
			System.out.println("	$ AOP[around] " + name + " 종료!" + (et - st));
		}
		return null;
	}
}
