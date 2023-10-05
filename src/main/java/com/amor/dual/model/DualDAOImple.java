package com.amor.dual.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class DualDAOImple implements DualDAO {

	private SqlSessionTemplate sqlmap;

	public DualDAOImple(SqlSessionTemplate sqlmap) {
		super();
		this.sqlmap = sqlmap;
	}
	
	@Override
	public List<DualDTO> chartData() {
		List<DualDTO> lists = sqlmap.selectList("chartData");
		return lists;
	}
	
	@Override
	public List<DualDTO> threeTableResult() {
		List<DualDTO> lists = sqlmap.selectList("threeTableResult");
		return lists;
	}
	
	@Override
	public List<DualDTO> salesChartData() {
		List<DualDTO> lists = sqlmap.selectList("salesChartData");
		return lists;
	}
}