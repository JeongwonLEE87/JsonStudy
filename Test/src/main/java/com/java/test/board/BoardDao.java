package com.java.test.board;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao implements BoardDaoInterface {
	
	private Logger logger = LogManager.getRootLogger();

	@Resource(name="sqlSession")
	SqlSession session; // mybatis가 관리하는 session 정보 주입 받기.
	
	@Override
	public HashMap<String, Object> board(HashMap<String, Object> param) {
		HashMap<String, Object> result = new HashMap<String, Object>();  // 리턴값 사용할 지역 변수 생성
		
		
		System.out.println("dao layer board() param="+param);
		
		if("selectList".equals(param.get("type"))) {
			System.out.println(" Dao Layer ++selectList++ ");
			result.put("result", session.selectList(param.get("menu")+".selectList"));
		}else if("selectOne".equals(param.get("type"))) {
			System.out.println(" Dao Layer ++selectOne++ ");
			result.put("result", session.selectOne(param.get("menu")+".selectOne", param.get("param")));
		}else if("insert".equals(param.get("type"))) {
			System.out.println(" Dao Layer ++insert++");
			result.put("result", session.insert(param.get("menu")+".insert", param.get("param")));
		}else if("update".equals(param.get("type"))) {
			System.out.println(" Dao Layer ++update++");
			result.put("result", session.update(param.get("menu")+".update", param.get("param")));
		}else if("delete".equals(param.get("type"))) {
			System.out.println(" Dao Layer ++delete++");
			result.put("result", session.update(param.get("menu")+".delete", param.get("param")));
		}
		
		System.out.println(" :: before dao out :: "+result);
		
		return result;
	}

}
