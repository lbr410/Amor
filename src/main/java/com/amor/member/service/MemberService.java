package com.amor.member.service;

import java.util.*;

import com.amor.member.model.*;

public interface MemberService {
	
	public String memberLogin (MemberDTO dto,String saveid);

	public Map<String, String> userIdFind(String member_name, String member_email);
}
