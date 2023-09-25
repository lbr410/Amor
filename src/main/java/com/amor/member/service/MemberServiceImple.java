package com.amor.member.service;

import java.util.*;

import org.apache.commons.collections.map.HashedMap;

import com.amor.member.model.*;

public class MemberServiceImple implements MemberService {
	
	private MemberDAO memberDao;
	
	public MemberServiceImple(MemberDAO memberDao) {
		super();
		this.memberDao = memberDao;
	}

	@Override
	public int memberLogin(MemberDTO dto) {
		MemberDTO dbDto=memberDao.memberLogin(dto.getMember_id());
		int result=ERROR;
		if(dbDto!=null) {
			if(dbDto.getMember_pwd().equals(dto.getMember_pwd())) {
				result=SUCCES;
				
				if(dbDto.getMember_quit().equals("y") || dbDto.getMember_block().equals("y")) {
					result=BLOK;
				}
			}else {
				result=NOT_ID_PWD;
			}
		}else {
			result=Join;
		}
		return result;
	}
	
	@Override
	public MemberDTO memberSession(MemberDTO dto) {
		MemberDTO dbDto=memberDao.memberLogin(dto.getMember_id());
		return dbDto;
	}
	
	@Override
	public int memberWithDraw(String id) {
		int result=memberDao.memberWithDraw(id);
		return result;
	}
	
	@Override
	public int memberPwdCheck(String sid, String pwd) {
		String dbId=memberDao.memberPwdCheck(pwd);
		int result=ERROR;	
		if(dbId!=null) {
			if(dbId.equals(sid)) {
				result=SUCCES;
			}
		}else {
			result=ERROR;
		}
		return result;
	}
	
	@Override
	public int memberPwdUpdate(String sid, String pwd) {
		Map map=new HashedMap();
		map.put("sid", sid);
		map.put("pwd", pwd);
		int result=memberDao.memberPwdUpdate(map);
		return result;
	}
	
	@Override
	public MemberDTO memberInfo(int sidx) {
		MemberDTO dto=memberDao.memberInfo(sidx);
		return dto;
	}
	
	@Override
	public String idCheck(String id) {
		String result = memberDao.idCheck(id);
		return result;
	}
	
	@Override
	public int signUp(MemberDTO dto) {
		int result = memberDao.signUp(dto);
		return result;
	}
	
	@Override
	public String userIdFind(String member_name, String member_email) {
		String result=memberDao.userIdFind(member_name,member_email);
		return result;
	}

	@Override
	public String userPwdIdck(String member_id) {
		String result=memberDao.userPwdIdck(member_id);
		return result;
	}
	
	@Override
	public int memberInfoUpdate(MemberDTO dto, int sidx) {
		int result=memberDao.memberInfoUpdate(dto, sidx);
		return result;
	}
	
}