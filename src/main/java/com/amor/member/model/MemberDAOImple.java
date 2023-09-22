package com.amor.member.model;

import org.mybatis.spring.SqlSessionTemplate;
import java.util.*;

public class MemberDAOImple implements MemberDAO {
	
	private SqlSessionTemplate sqlmap;

	public MemberDAOImple(SqlSessionTemplate sqlmap) {
		super();
		this.sqlmap = sqlmap;
	}

	@Override	
	public MemberDTO memberLogin(String id) {
		MemberDTO result=sqlmap.selectOne("memberLogin", id);
		System.out.println(result);
		return result;
	}
	
}
