package com.amor.theater.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

public class TheaterDAOImple implements TheaterDAO {
	
	private SqlSessionTemplate sqlmap;

	public TheaterDAOImple(SqlSessionTemplate sqlmap) {
		super();
		this.sqlmap = sqlmap;
	}
	
	@Override
	public TheaterDTO theaterInfo(int theater_idx) {
		TheaterDTO dto = sqlmap.selectOne("theaterInfo", theater_idx);
		return dto;
	}
	
	@Override
	public int theaterAdd() {
		int result = sqlmap.insert("theaterAdd");
		return result;
	}
	
	@Override
	public List<TheaterDTO> theaterSelect() {
		List<TheaterDTO> lists = sqlmap.selectList("theaterSelect");
		return lists;
	}
	
	@Override
	public int updateSeate(Map<String, Object> map) {
		int result = sqlmap.update("updateSeate", map);
		return result;
	}
	
	@Override
	public int totalTheater() {
		int result = sqlmap.selectOne("totalTheater");
		return result;
	}
	
	@Override
	public int theaterDelete(int tidx) {
		int result = sqlmap.delete("theaterDelete", tidx);
		return result;
	}
}