package com.amor.userController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserIdFindController {
 
	@RequestMapping("member/userIdFind.do")
	public String userIdFindForm() {
		return "user/member/userIdFind";
	}
	
}
