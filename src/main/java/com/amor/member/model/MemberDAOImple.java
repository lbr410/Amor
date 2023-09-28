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
	public MemberDTO memberSession(String id) {
		MemberDTO dto=sqlmap.selectOne("memberSession", id);
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
	public String userIdFind(String member_name, String member_email) {
		Map map=new HashedMap();
		map.put("member_email", member_email);
		map.put("member_name", member_name);
		String result=sqlmap.selectOne("userIdFind", map);
		System.out.println(result);
		return result;
	}
	
	@Override
	public String userPwdIdck(String member_id) {
		String id=sqlmap.selectOne("userPwdIdck", member_id);
		return id;
	}
	
	@Override
	public int userPwdFindUpdate(Map map) {
		int result=sqlmap.update("userPwdFindUpdate", map);
		return result;
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
	public int memberInfoUpdate(Map map) {
		int result=sqlmap.update("memberInfoUpdate", map);
		return result;
	}
	
	@Override
	public List<MemberDTO> memberList(Map map) {
		List<MemberDTO>lists=sqlmap.selectList("memberList",map);
		return lists;
	}
	
	@Override
	public int memberTotalCnt() {
		int result=sqlmap.selectOne("memberTotalCnt");
		return result;
	}
	
	@Override
	public List<MemberDTO> memberSearch(Map map) {
		List<MemberDTO> lists=sqlmap.selectList("memberSearch", map);
		return lists;
	}
	
	@Override
	public int memberSearchTotalCnt(String search) {
		int result=sqlmap.selectOne("memberSearchTotalCnt", search);
		return result;
	}
}
