package com.amor.userController;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.member.model.MemberDTO;
import com.amor.member.service.MemberService;

@Service
@Controller
public class UserIdFindController {
	private SqlSessionTemplate sqlmap;

	@Autowired
	private MemberService memberService;
	
	@RequestMapping("member/userIdFindForm.do")
	public String userIdFindForm() {
		return "/user/member/userIdFind";
	}
	 
	@RequestMapping(value = "member/userIdFindSubmit.do", method = RequestMethod.POST)
	public Map<String, String> searchId(HttpServletRequest request,HttpServletResponse response, Model model,MemberDTO dto,
			@RequestParam(value="member_name", defaultValue = "notname")String member_name,
			@RequestParam(value="member_email", defaultValue = "notemail")String member_email) {
		
		Map<String, String> member_id=memberService.userIdFind(member_name, member_email);
		return member_id;
	}
	
//	 @RequestMapping(value = "member/userIdFindSubmit.do", method = RequestMethod.POST)
//		public String searchId(HttpServletRequest request,HttpServletResponse response, Model model,MemberDTO dto,
//				@RequestParam(value="member_name", defaultValue = "notname")String member_name,
//				@RequestParam(value="member_email", defaultValue = "notemail")String member_email,
//				@RequestParam(value="member_id")String member_id) {
//			try {
//				dto.setMember_name(member_name);
//				dto.setMember_email(member_email);
//				MemberDTO id = memberService.userIdFind(dto);
//				System.out.println(member_name);
//				System.out.println(member_id);
//				model.addAttribute("findId", id);
//
//			} catch (Exception e) {
//				model.addAttribute("msg", "회원정보가 일치하지 않습니다.");
//				e.printStackTrace();
//			}
//			return "user/member/userIdFindResult";
//		}
//

 
}
