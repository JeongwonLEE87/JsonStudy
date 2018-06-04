package com.java.test.board;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService implements BoardServiceInterface {
	
	@Autowired
	BoardDaoInterface bdi; // BoardDao 사용할수 있도록 주입 받기 
	
	HashMap<String, Object> result; // 리턴값 사용할 전역 변수 선언
	HashMap<String, Object> param; // 파라메터 사용할 전역 변수 선언 : param => type, param, sql 

	@Override
	public HashMap<String, Object> selectList() {
		this.param = new HashMap<String, Object>();
		this.param.put("type", "selectList");		
		this.result = bdi.board(this.param);
		return this.result;
	}

	@Override
	public HashMap<String, Object> selectOne(HashMap<String, Object> param) {
		this.param = new HashMap<String, Object>();
		this.param.put("type", "selectOne");
		this.param.put("param", param);
		this.result = bdi.board(this.param);
		return this.result;
	}

	@Override
	public HashMap<String, Object> insert(HashMap<String, Object> param) {
		this.param = new HashMap<String, Object>();
		this.param.put("type", "insert");
		this.param.put("param", param);
		this.result = bdi.board(this.param);
		return this.result;
	}

	@Override
	public HashMap<String, Object> update(HashMap<String, Object> param) {
		this.param = new HashMap<String, Object>();
		this.param.put("type", "update");
		this.param.put("param", param);
		this.result = bdi.board(this.param);
		return this.result;
	}

	@Override
	public HashMap<String, Object> delete(HashMap<String, Object> param) {
		this.param = new HashMap<String, Object>();
		this.param.put("type", "delete");
		this.param.put("param", param);
		this.result = bdi.board(this.param);
		return this.result;
	}

}
