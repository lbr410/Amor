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
	
	@Override
	public String idCheck(String id) {
		String result = sqlmap.selectOne("idCheck", id);
		return result;
	}
	
	@Override
	public int signUp(MemberDTO dto) {
		int result = sqlmap.insert("signUp", dto);
		return result;
	}
}
