package com.amor.member.model;

import org.apache.commons.collections.map.HashedMap;
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
	public Map<String, String> findUserId(HashMap<String, Object> parameters) {
		return sqlmap.selectOne("com.amor.member.model.MemberDAO.findUserId", parameters);
	}



	
	@Override
	public MemberDTO memberInfo(int sidx) {
		MemberDTO dto=sqlmap.selectOne("memberInfo", sidx);
		return dto;
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
	
	@Override
	public int memberInfoUpdate(MemberDTO dto, int sidx) {
		Map map=new HashedMap();
		map.put("dto", dto);
		map.put("sidx", sidx);
		int result=sqlmap.update("memberInfoUpdate", map);
		return result;
	}
}
