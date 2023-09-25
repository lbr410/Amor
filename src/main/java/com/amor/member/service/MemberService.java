package com.amor.member.service;

import com.amor.member.model.*;

public interface MemberService {
	
	int SUCCES=1;
	int NOT_ID_PWD=2;
	int BLOK=3;
	int Join=4;
	int ERROR=-1;
	
	public int memberLogin (MemberDTO dto);
	
	public MemberDTO memberSession(MemberDTO dto);
	
	public int memberWithDraw(String id);
	
	public int memberPwdCheck(String sid, String pwd);
	
	public int memberPwdUpdate(String sid, String pwd);
	
	public MemberDTO memberInfo(int sidx);

}
