package com.java.test;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
public class Main {

	/***********************************************************************************************************************
	 * IoC (Inversion of Control) 컨테이너
	 * 1) 컨테이너
	 *  : 인스턴스의 생명주기를 관리하며, 생성된 인스턴스들에게 추가적인 기능을 제공하도록하는 것이라 할 수 있다.
	 *  2) 컨테이너의 종류
	 *  : Servlet 컨테이너, EJB 컨테이너....
        : Servlet 컨테이너는 Servlet의 생성, 생성 후 초기화, 서비스 실행, 소멸에 관한 모든 권한을 가지고 있다.
           -> Servlet 컨테이너의 web.xml을 보면 JSP/Servlet 접근 권한에 대한 추가적인 서비스도 지원하고 있다.
        3) Spring 컨터이너
        : 스프링 프레임워크의 핵심부에 위치하며, 종속객체 주입을 이용하여 애플리케이션을 구성하는 컴포넌트들을 관리한다.
        4) Spring 컨터이너의 종류
        : BeanFactory (org.springframework.beans.factory.BeanFactory)
        : ApplicationContext (org.springframework.context.factory.BeanFactory)
        5) IoC (Inversion of Control)
        : inversion은 사적적 의미로는 '도치, 역적'이다.
        : 보통 IoC를 제어의 역적, 의존적 주입이라는 번역한다.
        : 제어의 역적 즉 외부에서 제어를 한다는 것이다.
          - IoC는 바로 컨테이너이다.
        : 자바 기반으로 어플리케이션을 개발할 때 자바 객체를 생성하고 서로간의 의존관계를 연결시키는 작업에 대한 제어권은 보통 개발되는 
          어플리케이션 이지만 Servlet을 사용하는 경우 Servlet Container에게 제어권이 넘어가서 객체의 생명주기(라이프사이클)을 
          Container들이 전담하게 된다.
        : IoC에서 이야기하는 제어권의 역전이란 객체의 생명주기의 관리까지 모든 객체에 대한 제어권이 바뀌었다는 것(IoC 컨테이너)을 의미 한다.
     * DI 
     * 1) xml 파일을 이용한 방법 : spring config file 이용한 방법
       2) java 를 이용한 방법 : @Configuration 선언, @Bean 생성
       3) xml과 java를 같이 이용한 방법 :

     * ApplicationContext 인터페이스 : 인스턴스 생성
         - 오브젝트 생성, 관계설정, 만들어지는 방식, 자동생성, 후처리
	 ***********************************************************************************************************************/

	public static void main(String[] args) {
		String config = "file:src/main/webapp/WEB-INF/spring/root-context.xml";        // xml 파일 경로
		AbstractApplicationContext ac = new GenericXmlApplicationContext(config); // 컨터이너를 생성
		
		/*****************************************************************************************************************************************
		 * Bean 사용 테스트
			TestService ts = ac.getBean("testService", TestService.class); // 컨테이너에 있는 bean를 가져와서 주입
		//	ts.type = "select"; // 초기값 설정
			String result = ts.test();  // bean 사용
			System.out.println(result);
			HashMap<String, Object>  result = ts.test3();
			System.out.println(result);
		 *****************************************************************************************************************************************/	

		/*****************************************************************************************************************************************
		 * DB 연결 테스트
		 *****************************************************************************************************************************************/
		 	SqlSessionTemplate session = ac.getBean("sqlSession", SqlSessionTemplate.class);
			List<HashMap<String, Object>> list = session.selectList("test.select");
			for(int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		 
	}

}
