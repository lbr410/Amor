package com.amor.member.service;

import com.amor.member.model.*;

public interface MemberService {
	
	public String memberLogin (MemberDTO dto,String saveid);
	public String idCheck(String id);
	public int signUp(MemberDTO dto);
}
