package com.amor.member.model;

import java.util.*;

import org.apache.ibatis.annotations.Param;

public interface MemberDAO {
	
	public MemberDTO memberLogin(String id);
	public MemberDTO memberSession(String id);
	public int memberWithDraw(String id);
	public String memberPwdCheck(Map map);
	public int memberPwdUpdate(Map map);
	public MemberDTO memberInfo(int sidx);
	public String idCheck(String id);
	public int signUp(MemberDTO dto);
	public List<MemberDTO> userIdFind(String member_name, String member_email);
	public String userPwdIdck(String member_id);
	public int memberInfoUpdate(Map map);
	public int userPwdFindUpdate(Map map);
	public List<MemberDTO> memberList(Map map);
	public int memberTotalCnt();
	public List<MemberDTO> memberSearch(Map map);
	public int memberSearchTotalCnt(String search);
	public int memberListBlock(Map map);
}
 