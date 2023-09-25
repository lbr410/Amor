package com.amor.member.model;

import java.util.*;

public interface MemberDAO {
	
	public MemberDTO memberLogin(String id);
	
	public int memberWithDraw(String id);
	
	public String memberPwdCheck(String pwd);
	
	public int memberPwdUpdate(Map map);
	
	public MemberDTO memberInfo(int sidx);
}
