package com.amor.member.service;

import java.util.*;

import com.amor.member.model.*;

public interface MemberService {
  
	int SUCCES=1;
	int NOT_ID_PWD=2;
	int BLOK=3;
	int Join=4;
	int ERROR=-1;
<<<<<<< HEAD
  
	public Map<String, String> userIdFind(String member_name, String member_email);
=======

	public String userIdFind(String member_name, String member_email);
	public String userPwdIdck(String member_id);
>>>>>>> 62bb5dceaf04c7d7c5b652a7ee93421a65e9732f
	public int memberLogin (MemberDTO dto);
	public MemberDTO memberSession(MemberDTO dto);
	public int memberWithDraw(String id);
	public int memberPwdCheck(String sid, String pwd);
	public int memberPwdUpdate(String sid, String pwd);
	public MemberDTO memberInfo(int sidx);
	public String idCheck(String id);
	public int signUp(MemberDTO dto);
	public int memberInfoUpdate(MemberDTO dto, int sidx);
}