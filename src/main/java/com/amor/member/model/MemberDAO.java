package com.amor.member.model;

import java.util.*;

public interface MemberDAO {
	
	public MemberDTO memberLogin(String id);
    public Map<String, String> findUserId(HashMap<String, Object> parameters);
}
 