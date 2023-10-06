package com.amor.adminController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.admin.model.*;
import com.amor.admin.service.AdminService;
import com.amor.dual.model.DualDTO;
import com.amor.dual.service.DualService;
import com.amor.inquiry.model.InquiryDTO;
import com.amor.inquiry.service.InquiryService;

@Controller
public class AdminLoginController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private DualService dualService;
	
	@Autowired
	private InquiryService inquiryService;
	
	@RequestMapping("/admin/adminLogin.do")
	public ModelAndView adminLoginSubmit(@CookieValue(value = "autologin", required = false)String autologin,
			HttpSession session) {
		String id = (String)session.getAttribute("data");
		ModelAndView mav = new ModelAndView();

		if(autologin != null && id != null) {
			List<DualDTO> chartData = dualService.chartData();
			List<DualDTO> tableData = dualService.threeTableResult(); // 3개의 테이블(member, movie, notice)의 결과
			List<DualDTO> memberResult = new ArrayList<DualDTO>();
			List<DualDTO> movieResult = new ArrayList<DualDTO>();
			List<DualDTO> noticeResult = new ArrayList<DualDTO>();
			for(int i=0; i<tableData.size(); i++) {
				if(tableData.get(i).getOrders() == 0) {
					memberResult.add(tableData.get(i));
				} else if(tableData.get(i).getOrders() == 1) {
					movieResult.add(tableData.get(i));
				} else if(tableData.get(i).getOrders() == 2) {
					noticeResult.add(tableData.get(i));
				}
			}
			List<InquiryDTO> inquiryResult = inquiryService.adminMainInquiryList(); 
			
			mav.addObject("chartData", chartData);
			mav.addObject("memberResult", memberResult);
			mav.addObject("movieResult", movieResult);
			mav.addObject("noticeResult", noticeResult);
			mav.addObject("inquiryResult", inquiryResult);
			mav.setViewName("admin/adminIndex");
			
		}else {
			mav.setViewName("admin/adminLogin");
		}
		return mav;
	}
	
	@RequestMapping("/admin/adminMain.do")
	public ModelAndView goAdminPage(AdminDTO dto,
			@RequestParam(value = "id_remember",defaultValue = "off")String check1,
			@RequestParam(value = "autoLogin",defaultValue = "off")String check2,
			HttpServletResponse resp, HttpSession session) {
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
			}
			
			if(check2.equals("on")) {
				Cookie ck = new Cookie("autologin",dto.getAdmin_id());
				ck.setMaxAge(60*60*24*30);
				resp.addCookie(ck);
			}else if(check2.equals("off")) {
				Cookie ck = new Cookie("autologin",dto.getAdmin_id());
				ck.setMaxAge(0);
				resp.addCookie(ck);
			}
			session.setAttribute("data", dto.getAdmin_id());
			mav.addObject("msg", "관리자님 환영합니다.");
			mav.addObject("href", "/amor/admin/adminIndex.do");
			mav.setViewName("admin/msg/adminMsg");
		}else {
			mav.addObject("msg", "아이디 및 비밀번호가 틀렸습니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("admin/msg/adminMsg");
		}
		return mav;
	}
	
	@RequestMapping("/admin/admin.do")
	public String goMainPage() {
		return "admin/adminIndex";
	}
	
	@RequestMapping("/admin/adminlogout.do")
	public String adminLogout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		return "admin/adminLogin";
	}
}
