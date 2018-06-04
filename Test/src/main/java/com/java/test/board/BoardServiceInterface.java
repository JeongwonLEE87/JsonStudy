package com.java.test.board;

import java.util.HashMap;

public interface BoardServiceInterface {
	
	public HashMap<String, Object> selectList();
	public HashMap<String, Object> selectOne(HashMap<String, Object> param);
	public HashMap<String, Object> insert(HashMap<String, Object> param);
	public HashMap<String, Object> update(HashMap<String, Object> param);
	public HashMap<String, Object> delete(HashMap<String, Object> param);
	
}
