package com.amor.theater.model;

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
}