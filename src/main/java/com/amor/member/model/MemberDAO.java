package com.amor.member.model;

import java.util.*;

public interface MemberDAO {
	
	public MemberDTO memberLogin(String id);
	public String idCheck(String id);
	public int signUp(MemberDTO dto);
}
