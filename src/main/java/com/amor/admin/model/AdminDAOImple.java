package com.amor.admin.model;

import org.mybatis.spring.SqlSessionTemplate;

public class AdminDAOImple implements AdminDAO {

	private SqlSessionTemplate sqlmap;
	
	public AdminDAOImple(SqlSessionTemplate sqlmap) {
		super();
		this.sqlmap = sqlmap;
	}

	@Override
	public Boolean adminConection(AdminDTO dto) {
		
		String result = sqlmap.selectOne("adminConection",dto.getAdmin_id());
		if(result != null) {
			if(result.equals(dto.getAdmin_pwd())) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
}
