package com.amor.banner.model;

import org.mybatis.spring.SqlSessionTemplate;

public class BannerDAOImple implements BannerDAO {

	private SqlSessionTemplate sqlmap;

	public BannerDAOImple(SqlSessionTemplate sqlmap) {
		super();
		this.sqlmap = sqlmap;
	}
	
	
	
}
