package com.amor.member.model;

import java.util.*;

import org.apache.ibatis.annotations.Param;

public interface MemberDAO {
	
	public MemberDTO memberLogin(String id);
	public MemberDTO memberSession(String id);
	public int memberWithDraw(String id);
	public String memberPwdCheck(String pwd);
	public int memberPwdUpdate(Map map);
	public MemberDTO memberInfo(int sidx);
	public String idCheck(String id);
	public int signUp(MemberDTO dto);
	public String userIdFind(String member_name, String member_email);
	public String userPwdIdck(String member_id);
	public int memberInfoUpdate(MemberDTO dto, int sidx);
	public int userPwdFindUpdate(Map map);
}
 