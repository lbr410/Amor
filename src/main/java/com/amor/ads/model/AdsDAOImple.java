package com.amor.ads.model;

import org.mybatis.spring.SqlSessionTemplate;

public class AdsDAOImple implements AdsDAO {

	private SqlSessionTemplate sqlmap;

	public AdsDAOImple(SqlSessionTemplate sqlmap) {
		super();
		this.sqlmap = sqlmap;
	}
	
	
	
}
