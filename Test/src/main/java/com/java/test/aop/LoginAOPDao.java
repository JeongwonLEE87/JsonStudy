package com.java.test.aop;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class LoginAOPDao implements LoginAOPInterface {

	@Resource(name="sqlSession")
	SqlSession sqlSession;
	
	@Override
	public HashMap<String, Object> loginCheck(HashMap<String, Object> paramMap) {
		return sqlSession.selectOne("login.selectOne", paramMap);
	}

}
