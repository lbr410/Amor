package com.amor.member.service;

import java.util.*;

import org.apache.commons.collections.map.HashedMap;

import com.amor.member.model.*;

public class MemberServiceImple implements MemberService {
	
	private MemberDAO memberDao;
	
	public MemberServiceImple(MemberDAO memberDao) {
		super();
		this.memberDao = memberDao;
	}

	@Override
	public String memberLogin(MemberDTO dto, String saveid) {
		
		MemberDTO loginResult=memberDao.memberLogin(dto.getMember_id());
		String msg="";
		
		
		if(loginResult!=null) {
			if(loginResult.getMember_pwd().equals(dto.getMember_pwd())) {
				msg="로그인 성공";
				if(loginResult.getMember_quit().equals("y") || loginResult.getMember_block().equals("y")) {
					msg="접근이 제한되었습니다. 고객센터로 문의 바랍니다.";
				}
			}else {
				msg="아이디 혹은 비밀번호가 잘 못 되었습니다.";
			}
		}else {
			msg="아이디와 비밀번호를 입력해주세요.";
		}
		return msg;
	}
}
