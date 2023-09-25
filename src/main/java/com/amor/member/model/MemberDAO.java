package com.amor.member.model;

import java.util.*;

public interface MemberDAO {
	
	public MemberDTO memberLogin(String id);
  public Map<String, String> findUserId(HashMap<String, Object> parameters);
	public int memberWithDraw(String id);
	public String memberPwdCheck(String pwd);
	public int memberPwdUpdate(Map map);
	public MemberDTO memberInfo(int sidx);
	public String idCheck(String id);
	public int signUp(MemberDTO dto);
}
 