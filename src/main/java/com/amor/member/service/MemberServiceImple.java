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
	public MemberDTO memberSession(String id) {
		MemberDTO dbDto=memberDao.memberSession(id);
		return dbDto;
	}
	
	@Override
	public int memberWithDraw(String id) {
		int result=memberDao.memberWithDraw(id);
		return result;
	}
	
	@Override
	public int memberPwdCheck(String sid, String pwd) {
		Map map=new HashedMap();
		map.put("sid", sid);
		map.put("pwd", pwd);
		String dbId=memberDao.memberPwdCheck(map);
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
	public List<MemberDTO> userIdFind(String member_name, String member_email) {
		List<MemberDTO> result=memberDao.userIdFind(member_name,member_email);
		return result;
	}
	
	@Override
	public String userPwdIdck(String member_id) {
		String result=memberDao.userPwdIdck(member_id);
		return result;
	}

	@Override
	public int userPwdFindUpdate(String fid, String pwd) {
		Map map=new HashedMap();
		map.put("fid", fid);
		map.put("member_pwd", pwd);
		int result=memberDao.userPwdFindUpdate(map);
		return result;
	}
	
	@Override
	public String userEmailCheck(String id) {
		String result=memberDao.userEmailCheck(id);
		return result;
	}
	@Override
	public int memberInfoUpdate(MemberDTO dto, int sidx) {
		Map map=new HashedMap();
		map.put("dto", dto);
		map.put("sidx", sidx);
		int result=memberDao.memberInfoUpdate(map);
		return result;
	}
	
	@Override
	public List<MemberDTO> memberList(int cp, int listSize) {
		int start=(cp-1) * listSize + 1;
		int end=cp * listSize;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		List<MemberDTO> lists=memberDao.memberList(map);		
		return lists;
	}
	
	@Override
	public int memberTotalCnt() {
		int result=memberDao.memberTotalCnt();
		return result;
	}
	
	@Override
	public List<MemberDTO> memberSearch(int cp, int listSize, String search) {
		int start=(cp-1) * listSize + 1;
		int end=cp * listSize;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("search", search);
		
		List<MemberDTO> lists=memberDao.memberSearch(map);
		return lists;
	}
	
	@Override
	public int memberSearchTotalCnt(String search) {
		int result=memberDao.memberSearchTotalCnt(search);
		return result;
	}
	
	@Override
	public int memberListBlock(int idx, String value) {
		Map map=new HashMap();
		map.put("idx", idx);
		map.put("value", value);
		int result=memberDao.memberListBlock(map);
		return result;
	}
}