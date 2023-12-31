package com.amor.member.service;

import java.util.*;

import com.amor.member.model.*;

public interface MemberService {
  
	int SUCCES=1;
	int NOT_ID_PWD=2;
	int BLOK=3;
	int Join=4;
	int ERROR=-1;

	public List<MemberDTO> userIdFind(String member_name, String member_email);
	public String userPwdIdck(String member_id);
	public int userPwdFindUpdate(String fid, String pwd);
	public String userEmailCheck(String id);
	public int memberLogin (MemberDTO dto);
	public MemberDTO memberSession(String id);
	public int memberWithDraw(String id);
	public int memberPwdCheck(String sid, String pwd);
	public int memberPwdUpdate(String sid, String pwd);
	public MemberDTO memberInfo(int sidx);
	public String idCheck(String id);
	public int signUp(MemberDTO dto);
	public int memberInfoUpdate(MemberDTO dto, int sidx);
	public List<MemberDTO> memberList(int cp, int listSize);
	public  int memberTotalCnt();
	public List<MemberDTO> memberSearch(int cp, int listSize, String search);
	public int memberSearchTotalCnt(String search);
	public int memberListBlock(int idx, String value);
}