package com.amor.emp.model;

import org.mybatis.spring.SqlSessionTemplate;

public class EmpDAOImpl implements EmpDAO {

	private SqlSessionTemplate sqlmap;
	
	public EmpDAOImpl(SqlSessionTemplate sqlmap) {
		super();
		this.sqlmap = sqlmap;
	}

	public int EmpAdd(EmpDTO dto) {
		int result = sqlmap.insert("empAdd", dto);
		return result;
	}
}