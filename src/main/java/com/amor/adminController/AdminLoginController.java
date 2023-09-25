package com.amor.adminController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.admin.model.*;
import com.amor.admin.service.AdminService;

@Controller
public class AdminLoginController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/admin/adminLogin.do")
	public String adminLogin(@CookieValue(value = "autologin", required = false)String autologin) {
		System.out.println(autologin);
		if(autologin != null) {
			return "admin/admin_header";
		}
		return "admin/adminLogin";
	}
	
	@RequestMapping("/admin/adminMain.do")
	public ModelAndView goAdminPage(AdminDTO dto,
			@RequestParam(value = "id_remember",defaultValue = "off")String check1,
			@RequestParam(value = "autoLogin",defaultValue = "off")String check2,
			HttpServletResponse resp, HttpSession session) {
		System.out.println(check1);
		System.out.println(check2);
		ModelAndView mav = new ModelAndView();
		Boolean result = adminService.adminLogin(dto);
		if(result == true) {
			if(check1.equals("on")) {
				Cookie ck = new Cookie("idremember",dto.getAdmin_id());
				ck.setMaxAge(60*60*24*30);
				resp.addCookie(ck);
			}else if(check1.equals("off")) {
				Cookie ck = new Cookie("idremember",dto.getAdmin_id());
				ck.setMaxAge(0);
				resp.addCookie(ck);
			}else if(check2.equals("on")) {
				Cookie ck = new Cookie("autologin",dto.getAdmin_id());
				ck.setMaxAge(60*60*24*30);
				resp.addCookie(ck);
			}else if(check2.equals("off")) {
				Cookie ck = new Cookie("autologin",dto.getAdmin_id());
				ck.setMaxAge(0);
				resp.addCookie(ck);
			}
			session.setAttribute("name", dto.getAdmin_id());
			mav.addObject("msg", "관리자님 환영합니다");
			mav.addObject("href", "admin/admin_header");
			mav.setViewName("admin/msg/adminLoginMsg");
		}else {
			mav.addObject("msg", "아이디 및 비밀번호가 틀렸습니다");
			mav.addObject("href", "admin/adminLogin");
			mav.setViewName("admin/msg/adminLoginMsg");
		}
		return mav;
	}
}
