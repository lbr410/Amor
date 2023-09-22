package com.amor.movie.model;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;

public class MovieDAOImple implements MovieDAO {
	
	private SqlSessionTemplate sqlmap;
	
	public MovieDAOImple(SqlSessionTemplate sqlmap) {
		super();
		this.sqlmap = sqlmap;
	}

	@Override
	public int movieAdd(MovieDTO dto) {
		int result = sqlmap.insert("movieAdd",dto);
		return result;
	}
}
