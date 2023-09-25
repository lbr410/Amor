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
		MemberDTO dto=sqlmap.selectOne("memberLogin", id);
		return dto;
	}
	
	 @Override
	public int memberWithDraw(String id) {
		int result=sqlmap.update("memberWithDraw", id);
		return result;
	}
	 
	 @Override
	public String memberPwdCheck(String pwd) {
		String dbId=sqlmap.selectOne("memberPwdCheck", pwd);
		return dbId;
	}
	 
	@Override
	public int memberPwdUpdate(Map map) {
		int result=sqlmap.update("memberPwdUpdate", map);
		return result;
	}
	
	@Override
	public MemberDTO memberInfo(int sidx) {
		MemberDTO dto=sqlmap.selectOne("memberInfo", sidx);
		return dto;
	}
}
