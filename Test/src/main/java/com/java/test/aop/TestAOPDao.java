package com.java.test.aop;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class TestAOPDao implements TestAOPInterface {
	
	@Resource(name="sqlSession")
	SqlSession session;
	
	@Override
	public int insert(HashMap<String, Object> param) {
		int status = session.insert("aop.insert", param);
		return status;
	}

}
